package com.algo.expert.linkedlists;

public interface RemoveDuplicatesFromLinkedList {

    class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList);

    class Solution1 implements RemoveDuplicatesFromLinkedList {

        @Override
        public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
            LinkedList current = linkedList;
            while (current != null) {
                current.next = findNextUniqueNode(current);
                current = current.next;
            }
            return linkedList;
        }

        private LinkedList findNextUniqueNode(LinkedList item) {
            int value = item.value;
            while (item != null && item.value == value) item = item.next;
            return item;
        }
    }
}
