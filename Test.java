package com.akos;

import java.util.HashMap;
import java.util.Map;

public class Test extends Questions{
    private Map<String,Boolean> input = new HashMap<>();

    public double result (Map<String,Boolean> input) {
        int count = 0;
        for (Map.Entry<String,Boolean> map : input.entrySet()) {
            if (map.getValue()) {
                count++;
            }
        }
        return (double) count / input.size();
    }
    
}
