package com.linkedlist;

// последний вошел - первый вышел
public interface IntStack {

    void addFirst(int value);
    int peekFirst();   // получить значение элемента на вершине стека
    int removeFirst();  // получить значение и удалить из стека

    public String stackToString();

}
