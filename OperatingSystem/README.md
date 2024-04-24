# OperatingSystem #
Learning operating system concepts in Java. This file serves as 
documentation and as a notepad to illustrate OS concepts. The OS intend to give
the user access to low level functions and make them easy to use such as
process profiling and memory debugging. It will be a primarily shell based OS
and provide networking features. Swappable architecture -> Switch PM and MM
to different strategies depending on needs.


## Architecture ##
Layered architecture.


## TODO ##
* Primer on **x86 Assembler**
* Primer on **C**
* **OS-Dev** whitepage
    * Substitue C code with compiled Java assembly?
    * Decouple bootloader into files.
* Build out project enough to make public and add to resume.
* Begin writing bootloader and kernel.
* MM, PM, Drivers, FS, Shell, Sys libraries.


## Memory Management ##
* Ensures that each process can only access memory locations allocated to it 
  and cannot interfere with other processes' memory.

* **Memory Mapping**
    * The memory manager handles the mapping between virtual memory addresses 
      used by processes and physical memory addresses or device addresses.

* **Paging**
    * Paging involves dividing memory into fixed-size blocks (pages) and 
      swapping pages between main memory and secondary storage (e.g., disk). 

* **Virtual Memory**
    * Transparently manage physical memory and provide each process with a 
      virtual address space.
    
    * Demand paging, page replacement, memory mapping.

    * Address translation, page table management, and demand paging.

* **Segmentation**
* Segmentation divides memory into variable-sized segments based on logical 
  divisions (e.g., code, data, stack).

* **Memory Compaction**
    * reduces memory fragmentation by rearranging memory contents.

* **Memory Caching**
    * Stores frequently accessed memory contents in cache for faster access.

* **Diagnostics**
    * Monitor memory usage and performance metrics to identify potential issues 
      such as memory leaks, excessive memory fragmentation, or out-of-memory 
      conditions.


## Process Management ##
 Locks, semaphores, monitors, and message passing mechanisms. 
* A process can be defined as an instance of a program in execution. 
* The process manager handles the 
    * creation
        * This involves allocating the necessary resources (such as memory, 
          CPU time, and I/O devices) 

    * scheduling
        * The process manager decides which processes to execute next and in 
          what order.
        * It employs scheduling algorithms to determine the order of process 
          execution.
        * process priority, CPU burst time, and system load 

    * execution
        * It allocates CPU time to each process according to the 
          scheduling policy, switches between processes when necessary 
          (context switching), and handles interruptions such as hardware 
          interrupts and system calls.
    
    * suspension
        *  The process manager may suspend or resume processes based on certain 
          conditions. For example, a process may be temporarily suspended to 
          allow another higher-priority process to execute, or it may be 
          suspended while waiting for I/O completion.

    * termination of processes
        * Releases the resources allocated to the terminated process, 
          including memory, file descriptors, and other system resources.

    * synchronization and communication
        *  inter-process communication (IPC) 
        * shared memory
        * message passing
        * semaphores
        * mutex

    * monitor
        * monitor
        * profile
        * debugging
        * access permisions.

* Ensuring efficient and fair utilization of system resources.


## File System ##


## Device Drivers ##
* Hardware abstraction.
* Device initialization.
    * configure device settings
    * allocating memory

* memory buffers, I/O ports, interrupts, and DMA (Direct Memory Access) channels. 
* Error handling.
* Power management.
* 


## User Interface ##


## System Libraries ##


## Compilers ##
* **LLVM** - Can be used to develop frontend for any language and backend for 
  any architecture. A series of modular and reusable compiler and toolchain
  technologies. 

* Plain text -> Object Code -> Assembler code -> Machine code

* **Linker** -> Takes object code and links it to C library. Static or dynamic.
    * **static** -> Includes references to C lib code into executable.
    * **dynamic** -> Reference the lib on disk at runtime.


## Systems Programming ##
Systems programming requires a great degree of hardware awareness.  Its goal is 
to achieve efficient use of available resources.  by using an algorithm that is 
known to be efficient when used with specific hardware. Programs can be 
efficient with little runtime overhead, possibly having either a small runtime 
library or none at all. Programs may use direct and "raw" control over memory 
access and control flow. The programmer may write parts of the program directly 
in assembly language. 

The ones writing **databases**, **operating systems**, **compilers**, and 
foundational building blocks.

knowing how sockets and pipes and shared memory and threads all work is useful 
in many situations. 

Everything is memory and hardware interrupts and clock cycles. 

extensive understanding of x86 hardware and assembly programming.

Familiarize yourself with the basic concepts of assembly language programming, 
such as registers, instructions, memory addressing modes, and the stack.

Master assembly language programming, as it provides low-level access to 
hardware and is essential for OS development.

The toolset is: x86 assembler, and C. NASM, GCC, MAKE, and LD. Basic development
programs. Learn these to develop compilers, databases and OS's.


## Notes ##
Application programming can become daunting with the number of frameworks, APIS,
and libraries available. Even contributing to a project requires you to learn
new stacks. Using a low level toolchain restricts the overflow of stacks needed.
Interupts, and registers. Learning the x86 architecture inside and out in order
to build **systems level** applications such as **OSs**, **Compilers**, and
**Databases**, and **Firmwares**. You are not at the mercy of any other software
it is bare bones, metal, learning the busses and architecure of the hardware.
Start with ASM -> C -> OSDev -> Compiler Dev. Keep building upon this system.
Build into the userspace. Have adequate debuggers for everything.

One toolset. No overhead. JS applications are not lightweight. OS and systems
apps focus on efficiancy. A lot to learn from this level of programming. 

Much progress to make. Bootloader is WIP. Bootloader should bootstrap into C.
Need to learn how to memory is structured in x64 system. CPU registers, 
instruction set using Intel syntax. Compiled to machine code. At this level, 
there is ultimate control of hardware. Learn interrupts for each device and
design a system and library to use them all. Implement own C library or use
Java compiled to ASM. How to reference memory in Java? How to issue interupts?

Understand the memory model, interupts, disk, devices, to freely program.


## Register Machine Model ##
* Sub type of Random Access Machines -> Stack Machine Model.
* Model of Computation -> A mechanical process for performing comutations.
* Earliest models were recursive function machines. 
* COunters, accumulators, stacks, and registers.
* ARM and MIPS and Reduced Instruction Sets.
* CISC (complex) come with different execution environments and security
  features. 
* Hybrid Instruction Set -> RISC as ALU in CISC envritonment. 
* There are several hundred instructions in the **x86_64** instruction set.
* CPU fetches and executes instructions from memory.


## BIOS ##
* Provides service routines to clock, disk drives, network cards, TTY.
* Interrupt vector is at the start of memory.
* BIOS loads boot sector to 0x7c00 to avoid interferring w/ boot sector.
* Bootloader needs to bootstrap OS into memory.
* CPUS emulate older versions of CPUs.
* x64 emulates the 8086
* Need to switch CPU into 64 bit mode 
* BIOS does auto detection of hardware devices.
* Interrupts - Run another instruction on device. 
* Each interrupt is a number, setup by BIOS initially at the start of memory.
* Interrupt Vector table contains pointers to service routines.
* e.g. read from disk or from network card.
* Interrupts are ONLY available in Real 8086 mode.


## Segment Registers ##
* Memory is divided into segments, indexed by registers. Absolute
  address is calculated as the segment start address offsetted by
  specified address.

* **data segment**, **stack segment**.

* To calculate absolute address, the CPU multiples the value in 
the segment register and then adds your offset address. 

* Each segment represents logical division in memory:
  code, data, stack, heap, other program structures.

* Segment number and offset number to address memory.
* Segment Descriptor table contains the segment and includes info such as
  base address, length, access rights.

* Paging has superseded segmentation. x64 contains both segmentation and paging.

* `org` is for raw binray files and it sets the relative address for which to
  use addresses. Botloaded is always at 0x7c00, thereofore all addresses are
  realtive to this. Labels are relative to themselves and do not count.

* **Segmentation** is the 16-bit memory model to access up to 1mb of memory. 
* x86 uses 4 registers to store the locations of segments: base addresses. 
* Segments are usually **64kb in size** and are moveable. If the base address
  is 0, this is **0-64kb**. 
    * **CS, DS, ES, SS** are all segment registers. 

* Add the base address to offset address to get absolute address. 

* Segments can overlap causing corruption. Bytes can be refered to in a number
  of different ways. This is what is meant when there is no memory protection.

* CODE SEGMENT, DATA SEGMENT, EXTRA SEGMENT, STACK SEGMENT.


## Protected Mode ##
* Provides memory protection through descriptor tables that describe memory
  layout. 