/*
 * interrupt handling, scheduling, file system support, device drivers, 
 * and security mechanisms. 
 */
package com.blit;

 public class Kernel {

    public static void main(String[] args) {
        System.out.println("Starting Kernel...");

        // MemoryManager memManager = new MemoryManager(1000);
        // ProcessManager processManager = new ProcessManager();

        // Bootstrapping the system.
        //memManager.initialize();
        //processManager.initialize();
        
        // Test system.
        testMemoryManager();

        while(true) {
            // Handle interupts or system calls.
            return;

            // Perform kernel low level tasks.
        }
    }

    public static void testMemoryManager () {
        MemoryManager memManager = new MemoryManager(1000);

        // Allocate.
        int address1 = memManager.allocate(200);
        int address2 = memManager.allocate(300);

        System.out.println(address1);
        System.out.println(address2);

        memManager.printMemoryState();
    }
}
