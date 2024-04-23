/*
 * Manages memory allocation and deallocation. It maintains a list of memory 
 * blocks and provides methods to allocate and deallocate memory.
 * Virutal memory, paging, and segmentation. What are these thigs?
 * 
 * Blocks are found using startAddress + size.
 */

 package com.blit;

import java.util.ArrayList;
import java.util.List;

public class MemoryManager {
    
    private List<MemoryBlock> memoryBlocks;
    private int totalMemory;
    
    public MemoryManager (int totalMemory) {
        this.totalMemory = totalMemory;
        memoryBlocks = new ArrayList<>();
        memoryBlocks.add(new MemoryBlock(0, totalMemory));
    }
    
    /**
     * Allocate memory of a given size.
     */
    public int allocate (int size) {
        for(int i = 0; i < this.memoryBlocks.size(); i++) {
            MemoryBlock block = this.memoryBlocks.get(i);

            if(block.getSize() >= size) {
                // Split the block if it is larger than requested size.
                MemoryBlock newBlock = new MemoryBlock(
                    block.getStartAddress() + size,
                    block.getSize() - size);
                
                block = memoryBlocks.remove(i); // Remove allocated block.
                return block.getStartAddress(); // Return start allocation.
            }
        }

        return -1; // Allocation failed.
    }

    /**
     * Deallocate memory given a start address and a size. 
     */
    public void deallocate (int startAddress, int size) {
        MemoryBlock newBlock = new MemoryBlock(startAddress, size);
        // Insert the deallocated block in the sorted order.
        int i = 0;
        while(i < this.memoryBlocks.size() &&
        memoryBlocks.get(i).getStartAddress() < newBlock.getStartAddress()) {
            memoryBlocks.add(i, newBlock);
            this.mergeBlocks();
        }
    }

    /**
     * Merge adjacent blocks if possible.
     */
    private void mergeBlocks () {
        for(int i = 0; i < this.memoryBlocks.size(); i++) {
            MemoryBlock currBlock = this.memoryBlocks.get(i);
            MemoryBlock nextBlock = this.memoryBlocks.get(i+1);

            if(currBlock.getStartAddress() + currBlock.getSize() 
                == nextBlock.getStartAddress()) {
                currBlock = new MemoryBlock(
                        currBlock.getStartAddress(),
                        currBlock.getSize() + nextBlock.getSize()
                        );
                this.memoryBlocks.remove(i + 1);
                this.memoryBlocks.set(i, currBlock);
            }
        }
    }
    
    /*
     * Print the current state of memory blocks.
     */
    public void printMemoryState () {
        System.out.println("Memory State: ");
        for(MemoryBlock block : this.memoryBlocks) {
            System.out.println("Start Address: "+block.getStartAddress() +
                    "Size: "+block.getSize()+"\n");
        }
    }
}
