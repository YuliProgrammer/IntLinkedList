package com.linkedlist;

public interface IntList {

    void add(int value);
    void add(int index, int element); // Вставляет указанный элемент в указанную позицию в этом списке

    boolean contains(int value);
    int indexOf(int value);  // получает элемент и возвращает его индекс если элеменета нет - то возвращает -1
    int get(int index);
    void set(int index, int element);
    int size();

    void clear();
    boolean isEmpty();
    int remove(int index); // Удаляет элемент в указанной позиции в этом списке
    void deleteDuplicates();  // Удаляет дубликаты

    void sort();
    String listToString();
}
