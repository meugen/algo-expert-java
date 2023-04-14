package com.algo.expert.linkedlists;

public interface MiddleNode {

    LinkedList middleNode(LinkedList linkedList);

    class LinkedList {
        public final int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    class Solution1 implements MiddleNode {

        @Override
        public LinkedList middleNode(LinkedList linkedList) {
            LinkedList middle = linkedList;
            LinkedList current = linkedList;
            int middleIndex = 0;
            int currentIndex = 0;
            do {
                int newMiddleIndex = currentIndex % 2 == 0 ? currentIndex / 2 : currentIndex / 2 + 1;
                while (middleIndex < newMiddleIndex) {
                    middleIndex++;
                    middle = middle.next;
                }
                currentIndex++;
                current = current.next;
            } while (current != null);
            return middle;
        }
    }

    class  Solution2 implements MiddleNode {
        @Override
        public LinkedList middleNode(LinkedList linkedList) {
            int count = 0;
            LinkedList current = linkedList;
            while (current != null) {
                current = current.next;
                count++;
            }
            int middle = count / 2;
            int index = 0;
            LinkedList result = linkedList;
            while (index < middle) {
                result = result.next;
                index++;
            }
            return result;
        }
    }
}
