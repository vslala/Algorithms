package com.bma.algorithms.leetcode;

import lombok.AllArgsConstructor;
import lombok.Data;

public class FindNthTermFromEndInTheLinkedList<T extends Comparable<T>> {

    private Node<T> head;
    private Node<T> last;
    private int length;

    public void add(T val) {
        if (isFirstNode()) {
            head = new Node(val, null);
            last = head;
        } else {
            Node itr = getLastNode();
            itr.nextNode = new Node(val, null);
            last = itr.nextNode;
        }
        length++;
    }

    private Node getLastNode() {
        if (null != last && last != head)
            return last;

        Node itr = head;
        while (itr.nextNode != null)
            last = itr = itr.nextNode;
        return last;
    }

    public int size() {
        return length;
    }

    private boolean isFirstNode() {
        return head == null;
    }

    public T nthFromLast(int nth) {
        Node<T> first = head;
        Node<T> last = head;

        for (int index = 0; index < nth; index++) {
            last = last.nextNode;
        }

        while (last.nextNode != null) {
            first = first.nextNode;
            last = last.nextNode;
        }

        return first.getValue();
    }

    @AllArgsConstructor
    @Data
    public static class Node<T> {
        private T value;
        private Node nextNode;
    }
}
