/**
 * Compiler class from OSDev.net. This is used to bootstrap the code into a 
 * dev environment for Java.
 */

package com.blit;

import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;

public class Compiler {
    public Compiler () {
        ClassNode node = new ClassNode();
        ClassReader reader = new ClassReader(new byte[10]);
    }    
}
