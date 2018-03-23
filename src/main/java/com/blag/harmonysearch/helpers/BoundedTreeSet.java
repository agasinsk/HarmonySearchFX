package com.blag.harmonysearch.helpers;

import lombok.Getter;

import java.util.*;

public class BoundedTreeSet<E> extends TreeSet<E>
{
    @Getter
    private List<E> list;

    @Getter
    private final int capacity;

    public BoundedTreeSet(final int capacity)
    {
        super();
        this.capacity = capacity;
        this.list = new ArrayList<E>(capacity);
    }

    public BoundedTreeSet(final int capacity, final Collection<? extends E> c)
    {
        super(c);
        this.capacity = capacity;
        this.list = new ArrayList<E>(capacity);
    }

    public BoundedTreeSet(final int capacity, final Comparator<? super E> comparator)
    {
        super(comparator);
        this.capacity = capacity;
        this.list = new ArrayList<E>(capacity);
    }

    public BoundedTreeSet(final int capacity, final SortedSet<E> s)
    {
        super(s);
        this.capacity = capacity;
        this.list = new ArrayList<E>(capacity);
    }

    @Override
    public boolean remove(Object e)
    {
        list.remove(e);
        return super.remove(e);
    }

    @Override
    public boolean add(final E e)
    {
        return size() < capacity && super.add(e) && list.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c)
    {
        return size() + c.size() < capacity && super.addAll(c);
    }

    public E get(int index)
    {
        return list.get(index);
    }
}