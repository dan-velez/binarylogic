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
* Create repo
  * OperatingSystem/
      * Java/
      * C/
* Build out project enough to make public and add to resume.
* Primer on **x86 Assembler**
* Primer on **C**
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