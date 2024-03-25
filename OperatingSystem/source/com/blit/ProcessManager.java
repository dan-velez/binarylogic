package com.blit;

import java.util.List;

public class ProcessManager {
    private List<Process> processQueue;

    public void scheduler () {
        // Round robin scheduler.
        for(int i = 0; i < this.processQueue.size(); i++) {
            Process p = this.processQueue.get(i);
            // p.execute();
            this.processQueue.remove(i);
        }
    }
}
