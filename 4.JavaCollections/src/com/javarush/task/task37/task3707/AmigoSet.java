package com.javarush.task.task37.task3707;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;

public class AmigoSet <E> extends AbstractSet implements Serializable, Cloneable, Set {

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
