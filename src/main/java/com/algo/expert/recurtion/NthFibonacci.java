package com.algo.expert.recurtion;

import java.util.HashMap;
import java.util.Map;

public class NthFibonacci {

    public static int getNthFib(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        map.put(2, 1);
        for (int i = 3; i <= n; i++) {
            map.put(i, map.get(i-1) + map.get(i-2));
        }
        return map.get(n);
    }
}
