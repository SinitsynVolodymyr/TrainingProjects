package com.task2;

import java.util.ArrayList;
import java.util.Collection;

public class CustomArrayList<E> extends ArrayList<E> {

    public static void main(String[] args) {
        ArrayList<String> customArrayList = new CustomArrayList<>();
        customArrayList.add("Hello");
        customArrayList.add("my");
        customArrayList.add("custom");
        customArrayList.add("list.");

        customArrayList.remove("my");
        customArrayList.remove(2);
        customArrayList.clear();

        System.out.println(customArrayList);
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public void clear() {
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

}
