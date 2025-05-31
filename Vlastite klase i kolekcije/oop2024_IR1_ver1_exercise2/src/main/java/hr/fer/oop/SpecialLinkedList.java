package hr.fer.oop;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class SpecialLinkedList<E extends Comparable<E>> extends LinkedList<E> implements SpecialCollection<E> {

    public void provjeraElementa(E element) throws NullPointerException, IllegalArgumentException{
        if(element == null) throw new NullPointerException();
        if(super.contains(element)) throw new IllegalArgumentException();
    }
    @Override
    public void addFirst(E e) {
        provjeraElementa(e);
        super.addFirst(e);
    }

    @Override
    public void addLast(E e) {
        provjeraElementa(e);
        super.addLast(e);
    }

    @Override
    public boolean add(E e) {
        provjeraElementa(e);
        return super.add(e);
    }

    @Override
    public void add(int index, E element) {
        provjeraElementa(element);
        super.add(index, element);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for(E e : c) provjeraElementa(e);
        return super.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        for(E e : c) provjeraElementa(e);
        return super.addAll(index, c);
    }

    @Override
    public SpecialCollection<E> getSorted() {
        SpecialLinkedList<E> sortedCollection = new SpecialLinkedList<>();
        sortedCollection.addAll(this);
        Collections.sort(sortedCollection);
        return sortedCollection;
    }
}
