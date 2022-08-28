package com.algo.expert.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpiralTraverse {

    public static List<Integer> spiralTraverse(int[][] array) {
        // Write your code here.
        return new SpiralTraverse(array).internalSpiralTraverse();
    }

    private int[][] array;
    private int top;
    private int bottom;
    private int left;
    private int right;

    private int curX;
    private int curY;

    SpiralTraverse() {}

    SpiralTraverse(int[][] array) {
        this.array = array;
        top = 0;
        bottom = array.length - 1;
        left = 0;
        right = array[0].length - 1;
    }

    List<Integer> internalSpiralTraverse() {
        Move move = new RightMove();

        List<Integer> result = new ArrayList<>();
        curX = 0;
        curY = 0;
        result.add(array[curY][curX]);
        while (bottom-top >= 0 && right-left>=0) {
            while (move.canMove(this)) {
                move.doMove(this);
                result.add(array[curY][curX]);
            }
            move.markMoved(this);
            move = move.next();
        }
        return result;
    }

    interface Move {
        boolean canMove(SpiralTraverse program);
        void doMove(SpiralTraverse program);
        void markMoved(SpiralTraverse program);
        Move next();
    }

    static class RightMove implements Move {
        public boolean canMove(SpiralTraverse program) {
            return program.curX < program.right;
        }
        public void doMove(SpiralTraverse program) {
            program.curX++;
        }
        public void markMoved(SpiralTraverse program) {
            program.top++;
        }
        public Move next() {
            return new BottomMove();
        }
    }

    static class BottomMove implements Move {
        public boolean canMove(SpiralTraverse program) {
            return program.curY < program.bottom;
        }
        public void doMove(SpiralTraverse program) {
            program.curY++;
        }
        public void markMoved(SpiralTraverse program) {
            program.right--;
        }
        public Move next() {
            return new LeftMove();
        }
    }

    static class LeftMove implements Move {
        public boolean canMove(SpiralTraverse program) {
            return program.curX > program.left;
        }
        public void doMove(SpiralTraverse program) {
            program.curX--;
        }
        public void markMoved(SpiralTraverse program) {
            program.bottom--;
        }
        public Move next() {
            return new TopMove();
        }
    }

    static class TopMove implements Move {
        public boolean canMove(SpiralTraverse program) {
            return program.curY > program.top;
        }
        public void doMove(SpiralTraverse program) {
            program.curY--;
        }
        public void markMoved(SpiralTraverse program) {
            program.left++;
        }
        public Move next() {
            return new RightMove();
        }
    }
}
