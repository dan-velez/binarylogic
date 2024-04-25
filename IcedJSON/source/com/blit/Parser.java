package com.blit;

import java.util.HashMap;
import java.util.Map;

public class Parser {

    int index = 0;
    String json = "";
    
    public Map<String, Object> parseJson () {
        Map<String, Object> res = new HashMap<>();

        boolean inKey = true;
        String buffer = "";
        Object o = null;

        for (index = 0; index < json.length(); index++) {
            char ch = json.charAt(index);
            if (ch == '{' || ch == '"' || ch == '}') {
                continue;
            }
            res.put(this.parseKey(), this.parseObject());
        }

        return res;
    }

    public String parseKey () {
        String res = "";

        return res;
    }

    public Object parseArray (String json) {
        Object res = new Object();

        return res;
    }

    public Map<String, Object> parseObject () {
        Map<String, Object> res = new HashMap<>();

        return res;
    }

}
