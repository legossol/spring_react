package com.example.demo.stream;

import java.util.ArrayList;
import java.util.Comparator;

public class Series<T> {
    private ArrayList<T> list;

    public Series() {
        list = new ArrayList<T>();
    }

    public void add(T t) {
        list.add(t);
    }

    public void clear() {
        list.clear();
    }

    public boolean contains(T t) {
        return list.contains(t);
    }

    public T get(int index) {
        return list.get(index);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean remove(T t) {
        return list.remove(t);
    }

    public int size() {
        return list.size();
    }

    public void sort(Comparator c) {
        list.sort(c);
    }

}
