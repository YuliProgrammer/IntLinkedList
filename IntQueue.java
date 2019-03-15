package com.linkedlist;

// первым пришёл - первый вышел
public interface IntQueue {

    void addQueue(int value);
    int peek(); // получить значение первого элемента
    int poll(); //получить значение первого элемента и удалить его из очереди
    String queueToString();
}
