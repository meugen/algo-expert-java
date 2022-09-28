package com.algo.expert.recurtion;

import java.util.HashMap;
import java.util.Map;

public interface NthFibonacci {

    int getNthFib(int n);

    class Solution1 implements NthFibonacci {

        @Override
        public int getNthFib(int n) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(1, 0);
            map.put(2, 1);
            for (int i = 3; i <= n; i++) {
                map.put(i, map.get(i-1) + map.get(i-2));
            }
            return map.get(n);
        }
    }

    class Solution2 implements NthFibonacci {

        private final Map<Integer, Integer> memo = new HashMap<>();

        @Override
        public int getNthFib(int n) {
            if (n == 1) return 0;
            if (n == 2) return 1;
            Integer result = memo.get(n);
            if (result != null) return result;
            result = getNthFib(n - 1) + getNthFib(n - 2);
            memo.put(n, result);
            return result;
        }
    }

    class Solution3 implements NthFibonacci {

        @Override
        public int getNthFib(int n) {
            if (n == 1) return 0;
            int n0 = 0;
            int n1 = 1;
            for (int i = 3; i <= n; i++) {
                int n2 = n0 + n1;
                n0 = n1;
                n1 = n2;
            }
            return n1;
        }
    }
}
