package com.akos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
    public void takeTest (Map<String,Map<String,Boolean>> test) {
        Scanner in = new Scanner(System.in);
        for (Map.Entry<String,Map<String,Boolean>> map : test.entrySet()) {
            System.out.println(map.getKey());
            System.out.println(map.getValue().keySet());
            System.out.println("Chose your answer");
            String answer = in.nextLine();
            this.input.put(map.getKey(), map.getValue().get(answer));
            in.nextLine();
        }
    }
}
