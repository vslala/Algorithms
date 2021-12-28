package com.bma.problemsolving.leetcode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

public class Model {

    @Value
    @AllArgsConstructor
    public static class Coordinate {
        int row;
        int col;

        public Coordinate minusRow(int number) {
            return new Coordinate(row - number, col);
        }

        public Coordinate minusCol(int number) {
            return new Coordinate(row, col - number);
        }

        public Coordinate plusRow(int number) {
            return new Coordinate(row + number, col);
        }

        public Coordinate plusCol(int number) {
            return new Coordinate(row, col + number);
        }

        public boolean isInBounds(int[][] grid) {
            return row >= 0 && row < grid.length &&
                    col >= 0 && col < grid[row].length;
        }

        public Coordinate plus(Coordinate coordinate) {
            return new Coordinate(row + coordinate.getRow(), col + coordinate.getCol());
        }
    }

    @Data
    @AllArgsConstructor
    public static class Node {
        private int val;
        private Node left;
        private Node right;
        private Node next;
    }
}