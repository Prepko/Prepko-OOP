package hr.fer.oop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Item implements Comparable<Item> {
    private final String name;
    private final int value;
    private final String category;

    public Item(String name, int value, String category) {
        this.name = name;
        this.value = value;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public int hashCode() {        
        return Objects.hash(name, value, category);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Item)) return false;

        Item other = (Item) obj;
        return other.getName().equals(getName()) &&
                other.getValue() == getValue() &&
                other.getCategory().equals(getCategory());
    }

    @Override
    public int compareTo(Item other) {
        int r = this.getName().compareTo(other.getName());
        if(r != 0) return r;

        r = Integer.compare(this.getValue(), other.getValue());
        if(r != 0) return r;

        r = this.getCategory().compareTo(other.getCategory());
        return r;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", value=" + value + ", category=" + category + '}';
    }
}
