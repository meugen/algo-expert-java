package com.algo.expert.arrays;

import java.util.ArrayList;
import java.util.List;

public interface SpiralTraverse {

    List<Integer> spiralTraverse(int[][] array);

    class Solution1 implements SpiralTraverse {

        @Override
        public List<Integer> spiralTraverse(int[][] array) {
            Coordinates coordinates = new Coordinates(array);

            Move move = new RightMove();

            List<Integer> result = new ArrayList<>();
            result.add(array[coordinates.curY][coordinates.curX]);
            while (coordinates.bottom- coordinates.top >= 0 && coordinates.right- coordinates.left>=0) {
                while (move.canMove(coordinates)) {
                    move.doMove(coordinates);
                    result.add(array[coordinates.curY][coordinates.curX]);
                }
                move.markMoved(coordinates);
                move = move.next();
            }
            return result;
        }
    }

}

class Coordinates {
    int top;
    int bottom;
    int left;
    int right;

    int curX;
    int curY;

    Coordinates(int[][] array) {
        this.top = 0;
        this.bottom = array.length - 1;
        this.left = 0;
        this.right = array[0].length - 1;

        curX = 0;
        curY = 0;
    }

}

interface Move {
    boolean canMove(Coordinates coordinates);
    void doMove(Coordinates coordinates);
    void markMoved(Coordinates coordinates);
    Move next();
}

class RightMove implements Move {
    public boolean canMove(Coordinates coordinates) {
        return coordinates.curX < coordinates.right;
    }
    public void doMove(Coordinates coordinates) {
        coordinates.curX++;
    }
    public void markMoved(Coordinates coordinates) {
        coordinates.top++;
    }
    public Move next() {
        return new BottomMove();
    }
}

class BottomMove implements Move {
    public boolean canMove(Coordinates coordinates) {
        return coordinates.curY < coordinates.bottom;
    }
    public void doMove(Coordinates coordinates) {
        coordinates.curY++;
    }
    public void markMoved(Coordinates coordinates) {
        coordinates.right--;
    }
    public Move next() {
        return new LeftMove();
    }
}

class LeftMove implements Move {
    public boolean canMove(Coordinates coordinates) {
        return coordinates.curX > coordinates.left;
    }
    public void doMove(Coordinates coordinates) {
        coordinates.curX--;
    }
    public void markMoved(Coordinates coordinates) {
        coordinates.bottom--;
    }
    public Move next() {
        return new TopMove();
    }
}

class TopMove implements Move {
    public boolean canMove(Coordinates coordinates) {
        return coordinates.curY > coordinates.top;
    }
    public void doMove(Coordinates coordinates) {
        coordinates.curY--;
    }
    public void markMoved(Coordinates coordinates) {
        coordinates.left++;
    }
    public Move next() {
        return new RightMove();
    }
}