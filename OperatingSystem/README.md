# OperatingSystem #
Learning operating system concepts in Java. This file serves as 
documentation and as a notepad to illustrate OS concepts. The OS intend to give
the user access to low level functions and make them easy to use such as
process profiling and memory debugging. It will be a primarily shell based OS
and provide networking features.


## Architecture ##
Layered architecture.


## TODO ##
    * Copy compiler code from OSDev.net. This will bootstrap you into a dev
      environment.
    * Debug MM.
    * System logger.


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