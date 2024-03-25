package com.blit;

import java.util.ArrayList;
import java.util.List;

public class MemoryBlock {
    private int startAddress;
    private int size;

    public MemoryBlock (int startAddress, int size) {
        this.startAddress = startAddress;
        this.size = size;
    }

    public int getStartAddress () {
        return this.startAddress;
    }

    public int getSize () {
        return this.size;
    }
}
