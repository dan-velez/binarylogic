package com.blit;

/**
 * Compiler class from OSDev.net. This is used to bootstrap the code into a 
 * dev environment for Java.
 */
 
import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;
import java.util.*;
import java.io.*;
 
public class Compiler
{
    public static byte[] readEntireFile(String filename)
    {
        File file = new File(filename);
        try 
        {
            FileInputStream input = new FileInputStream(file);
            byte bytes[] = new byte[(int)file.length()];
            input.read(bytes);
            return bytes;
        }
        catch (IOException e)
        {
            throw new RuntimeException("Unable to read file " + file, e);
        }
    }
 
    public static void writeOutput(String filename, List<String> lines)
    {
        try 
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filename)));
            for (String string : lines)
            {
                writer.write(string);
                writer.newLine();
            }
            writer.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException("Unable to write output file " + filename, e);
        }
    }
 
    public static String decorate(String classname, String method, String signature)
    {
        // make all these assembly-friendly names. Note that the 
        // constructor is for instance called <init>
        return classname.replace("/","_") + "__" + method.replace("<","_").replace(">","_");
    }
 
    public static void jumpgroup(List<String> output, String jumpcode, LabelNode dest)
    {
    	output.add("pop edx");
    	output.add("pop ecx");
    	output.add("cmp ecx, edx");
    	output.add(jumpcode + " .l" + dest.getLabel());
    }
 
    public static void main(String args[])
    {
        if (args.length != 2) throw new RuntimeException("Usage: compiler input-file output-file");
 
        ClassNode node = new ClassNode();
        ClassReader reader = new ClassReader(readEntireFile(args[0]));
        reader.accept(node, 0);
 
        List<String> outputdata = new LinkedList<String>();
 
        outputdata.add("section .text");
 
        for (MethodNode method : node.methods)
        {
            method.visitCode();
            String methodname = decorate(node.name, method.name, method.signature);
 
            if ((method.access & Opcodes.ACC_NATIVE) != 0) continue;
 
            // prologue
            System.out.println("; attributes: " + method.attrs);
            outputdata.add("global " + methodname);
            outputdata.add(methodname + ":");
            outputdata.add("push ebp");
            outputdata.add("mov ebp, esp");
 
            int locals = (method.localVariables == null) ? 0 : method.localVariables.size();
            outputdata.add("; locals: + " + locals);
			int arguments = (method.parameters == null) ? 0 : method.parameters.size();
            if ((method.access & Opcodes.ACC_STATIC) == 0) arguments++; // hidden "this"
            outputdata.add("; params: + " + arguments);
            // copy params so that they correspond with java indexing and join with the local numbering
			for (int i = 0; i < arguments; i++)
            {
                outputdata.add("push dword [ebp + " + (8 + 4 * i) + "]");
            }
            // do some frame checking for many variables, locals is not of much use...
            outputdata.add("sub esp, 32");
 
            Iterator<AbstractInsnNode> iterator = method.instructions.iterator();
            while (iterator.hasNext())
            {     
                AbstractInsnNode insn = iterator.next();
                int opcode = insn.getOpcode() & 0xff;
                outputdata.add("    ; " + opcode + " = " + insn.getClass().getSimpleName());
                //outputdata.add("mov byte [" + (0xb8000 + 156) + "], '0' + " + (opcode % 10));
                //outputdata.add("mov byte [" + (0xb8000 + 154) + "], '0' + " + (opcode / 10)%10);
                //outputdata.add("mov byte [" + (0xb8000 + 152) + "], '0' + " + (opcode / 100));
 
                if (insn instanceof LabelNode)
                {
                    LabelNode labelinsn = (LabelNode)insn;
                    outputdata.add(".l" + labelinsn.getLabel());
                }
                else if (insn instanceof LineNumberNode)
                {
                    // ignore these
                }
                else if (insn instanceof VarInsnNode)
                {
                    // copy a variable
                    VarInsnNode varinsn = (VarInsnNode) insn;
                    switch(varinsn.getOpcode())
                    {
                        case Opcodes.ILOAD:
                        case Opcodes.ALOAD:
                            // todo: verify offset
                            outputdata.add("push dword [ebp - " + (4 + 4 * varinsn.var) + "]");
                            break;
 
                        case Opcodes.ISTORE:
                        case Opcodes.ASTORE:
                            outputdata.add("pop dword [ebp - " + (4 + 4 * varinsn.var) + "]");
                            break;
 
                        default:
                            outputdata.add("Can't deal with varinsnnode: " + varinsn.getOpcode());
                    }
                }
                else if (insn instanceof MethodInsnNode)
                {
                    MethodInsnNode methodinsn = (MethodInsnNode) insn;
                    String calledmethod = decorate(methodinsn.owner, methodinsn.name, methodinsn.desc);
                    outputdata.add("extern " + calledmethod);
                    outputdata.add("call " + calledmethod);
                    if (!methodinsn.desc.endsWith("V"))
                    {
                        // not a void return value
                        outputdata.add("push eax");
                    }
                    /*switch (methodinsn.getOpcode())
                    {
                        default:
                            outputdata.add("Can't deal with methodcall: " + methodinsn.getOpcode());
                    }*/
                }
                else if (insn instanceof IntInsnNode)
                {
                	IntInsnNode intinsn = (IntInsnNode)insn;
                    switch(intinsn.getOpcode())
                    {
                        case Opcodes.BIPUSH:
                            outputdata.add("push " + intinsn.operand);
                            break;
 
                        default:
                            outputdata.add("Can't deal with intinsnnode: " + intinsn.getOpcode());
                    }
 
                }
                else if (insn instanceof JumpInsnNode)
                {
                	JumpInsnNode jmpinsn = (JumpInsnNode)insn;
 
                    switch(jmpinsn.getOpcode())
                    {
                    	case Opcodes.IF_ICMPEQ:		jumpgroup(outputdata, "je", jmpinsn.label); 	break; // 159
                    	case Opcodes.IF_ICMPNE:		jumpgroup(outputdata, "jne", jmpinsn.label); 	break; // 160                    	
                    	case Opcodes.IF_ICMPLT:		jumpgroup(outputdata, "jb", jmpinsn.label); 	break; // 161
                    	case Opcodes.IF_ICMPGE:		jumpgroup(outputdata, "jae", jmpinsn.label); 	break; // 162
                    	case Opcodes.IF_ICMPGT:		jumpgroup(outputdata, "ja", jmpinsn.label); 	break; // 163
                    	case Opcodes.IF_ICMPLE:		jumpgroup(outputdata, "jbe", jmpinsn.label);	break; // 164
 
                        case Opcodes.GOTO: // 167
                            outputdata.add("jmp .l" + jmpinsn.label.getLabel());
                            break;
 
                        default:
                            outputdata.add("Can't deal with jumpinsnnode: " + jmpinsn.getOpcode());
                    }
                }   
                else if (insn instanceof LdcInsnNode)
                {
                	LdcInsnNode ldcinsn = (LdcInsnNode) insn;
                	if (ldcinsn.cst instanceof Integer)
                	{
                		outputdata.add("push " + ldcinsn.cst.toString());
                	}
                	else
                	{
	                	outputdata.add("Can't deal with data in ldcinsnnode (" + ldcinsn.getOpcode() +"): " + ldcinsn.cst.getClass().getSimpleName());
                	}
                }             
                else if (insn instanceof IincInsnNode)
                {
                	IincInsnNode incinsn = (IincInsnNode) insn;
                	switch (incinsn.getOpcode())
                	{	
                	    case Opcodes.IINC:
                	    	outputdata.add("add dword [ebp - " + (4 + 4 * incinsn.var) + "], " + incinsn.incr);
                	    	break;
                		default:
                			outputdata.add("Can't deal with iincinsnnode: " + incinsn.getOpcode());                			
                	}
 
                }
                else if (insn.getOpcode() >= Opcodes.ICONST_M1 && insn.getOpcode() <= Opcodes.ICONST_5) // 2...8
                {
                    outputdata.add("push " + (insn.getOpcode() - Opcodes.ICONST_M1 - 1));
                }
                else if (insn.getOpcode() == Opcodes.IADD) // 96
                {
                	outputdata.add("pop edx");
                	outputdata.add("add [esp], edx");
                }
                else if (insn.getOpcode() == Opcodes.IMUL) // 104
                {
                	outputdata.add("pop eax");
                	outputdata.add("pop ecx");
                	outputdata.add("imul ecx"); // eax:edx = eax * ecx
                	outputdata.add("push eax");
                }                
                else if (insn.getOpcode() == Opcodes.I2B) // 145
                {
                	outputdata.add("and dword [esp], 0xff");
                }
                else if (insn.getOpcode() == Opcodes.RETURN)	// 177
                {
                	outputdata.add("xor eax, eax");
                }
                else if (insn instanceof FrameNode)
                {
                    outputdata.add("; framenode");
                }
                else
                {
                    outputdata.add("Can't deal with " + insn.getClass().getSimpleName() + ", fix it (" + insn.getOpcode() + ")");
                }
            }
 
            // epilogue, stdcall to save complexity on decoding methodinsns
            outputdata.add("leave");
            outputdata.add("ret " + arguments);
        }
 
        writeOutput(args[1], outputdata);
    }
}
