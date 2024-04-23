package com.blit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardDriver {
  
    /**
     * Read lines from keyboard. Pass this to the Kernel for input.
     */
    public void start () {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while(true) {
                String input = reader.readLine();
                if(input != null && !input.isEmpty()) {
                    System.out.println(input);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                reader.close();
            } catch (IOException f) {
                e.printStackTrace();
            }
        }
    }
}
