package com.linkedlist;

import java.util.Arrays;

public class IntLinkedList implements IntList, IntStack, IntQueue {

    private class Element {
        int value;
        Element next;  // ссылка на след.элем

        Element(int val) {
            this.value = val;
        }
    }

    private Element first;


    // Common functions

    private void addElemListStackQueue(int value, int quantity) {
        Element myElement = new Element(value);

        if (quantity == 0) {
            first = myElement;
        } else {
            Element last = getElement(quantity - 1);
            last.next = myElement;
        }
    }

    private Element getElement(int index) {

        Element myElement = first;
        for (int i = 0; i < index; i++) {
            myElement = myElement.next;
        }

        return myElement;
    }

    private String toString(int quantity) {

        int[] arr = new int[quantity];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getElement(i).value;
        }

        return Arrays.toString(arr);
    }


    // LinkedList

    private int countList = 0;

    @Override
    public void add(int value) {
        addElemListStackQueue(value, countList);
        countList++;
    }

    @Override
    public void add(int index, int value) {
        if (index < 0 || index >= countList) {
            System.out.println(" Error. Array index out of bounds exception");
        } else {

            int j = 0;
            countList++;
            int[] arr = new int[countList];
            for (int i = 0; i < arr.length; i++) {
                if (i == index) {
                    arr[i] = value;
                    continue;
                }

                arr[i] = getElement(j).value;
                j++;
            }

            for (int i = 0; i < countList; i++) {
                addElemListStackQueue(arr[i], i);
            }

        }
    }

    @Override
    public boolean contains(int value) {
        Element myElement = first;
        for (int i = 0; i < countList; i++) {
            if (myElement.value == value) {
                return true;
            }
            myElement = myElement.next;
        }
        return false;
    }

    @Override
    public int indexOf(int value) {

        Element myElement = first;
        for (int i = 0; i < countList; i++) {
            if (myElement.value == value) {
                return i;
            }
            myElement = myElement.next;
        }

        return -1;
    }

    @Override
    public int get(int index) {

        if (index < 0 || index >= countList) {
            System.out.println(" Error. Array index out of bounds exception");
            return 0;
        }

        return getElement(index).value;
    }

    @Override
    public void set(int index, int element) {
        if (index < 0 || index >= countList) {
            System.out.println(" Error. Array index out of bounds exception");
        } else {
            getElement(index).value = element;
        }
    }

    @Override
    public int size() {
        return countList;
    }

    @Override
    public void clear() {
        countList = 0;
        first = null;
    }

    @Override
    public boolean isEmpty() {
        return countList == 0;
    }

    @Override
    public int remove(int index) {

        if (index < 0 || index >= countList) {
            System.out.println(" Error. Array index out of bounds exception");
            return 0;
        }
        Element myElement = first;

        for (int i = 0; i < countList; i++) {
            if (i == index) {
                continue;
            }
            myElement.value = get(i);
            myElement = myElement.next;
        }
        countList--;

        return 0;
    }

    @Override
    public void deleteDuplicates() {
        if (countList == 0) {
            System.out.println(" Error. Array index out of bounds exception");
            return;
        }

        int[] arr = new int[countList];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getElement(i).value;
        }
        System.out.println(countList);
        clear();
        boolean isAttend = false;

        for (int i = 1; i <= arr.length; i++) {
            if (isAttend == false) {
                add(arr[i - 1]);
            }

            if (i != arr.length) {
                isAttend = (arr[i - 1] == arr[i]);
            }
        }

    }

    @Override
    public void sort() {

        if (countList == 0) {
            System.out.println(" Error. Array index out of bounds exception");
            return;
        }

        int[] arr = new int[countList];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getElement(i).value;
        }

        Arrays.sort(arr);
        clear();
        for (int i = 0; i < arr.length; i++) {
            add(arr[i]);
        }
    }

    @Override
    public String listToString() {
        return toString(countList);
    }


    // Stack

    int countStack = 0;

    @Override
    public void addFirst(int value) {
        addElemListStackQueue(value, countStack);
        countStack++;
    }

    @Override
    public int peekFirst() {
        if (countStack == 0) {
            System.out.println(" Error. Array index out of bounds exception");
            return 0;
        }

        return getElement(countStack - 1).value;
    }

    @Override
    public int removeFirst() {

        if (countStack == 0) {
            System.out.println(" Error. Array index out of bounds exception");
            return 0;
        }

        int num = getElement(countStack - 1).value;

        Element element = first;
        for (int i = 0; i < countStack; i++) {
            if (i == countStack - 1) {
                continue;
            }
            element.value = getElement(i).value;
            element = element.next;
        }
        countStack--;

        return num;
    }

    @Override
    public String stackToString() {
        return toString(countStack);
    }


    // Queue

    int countQueue = 0;

    @Override
    public void addQueue(int value) {
        addElemListStackQueue(value, countQueue);
        countQueue++;
    }

    @Override
    public int peek() {
        if (countQueue == 0) {
            System.out.println(" Error. Array index out of bounds exception");
            return 0;
        }
        return getElement(0).value;
    }

    @Override
    public int poll() {

        if (countQueue == 0) {
            System.out.println(" Error. Array index out of bounds exception");
            return 0;
        }

        int num = getElement(0).value;

        Element element = first;

        for (int i = 1; i < countQueue; i++) {
            element.value = getElement(i).value;
            element = element.next;
        }

        countQueue--;

        return num;

    }

    @Override
    public String queueToString() {
        return toString(countQueue);
    }

}
