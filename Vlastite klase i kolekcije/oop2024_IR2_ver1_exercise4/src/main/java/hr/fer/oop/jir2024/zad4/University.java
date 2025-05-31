package hr.fer.oop.jir2024.zad4;

import java.util.Comparator;
import java.util.Objects;

public class University implements Comparable<University> {
    private String name;
    private String country;
    private int founded;
    private int therank;
    private int arwurank;

    public University(String name, String country, int founded, int therank, int arwurank) {
        this.name = name;
        this.country = country;
        this.founded = founded;
        this.therank = therank;
        this.arwurank = arwurank;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getFounded() {
        return founded;
    }

    public int getTherank() {
        return therank;
    }

    public int getArwurank() {
        return arwurank;
    }

    public String toString() {
        return String.format("%s (%s, %d) THE: %d ARWU: %d", name, country, founded, therank, arwurank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, founded);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof University)) return false;

        University university = (University) obj;

        return university.getName().equals(name) &&
                university.getCountry().equals(country) &&
                university.getFounded() == this.getFounded();
    }

    public static final Comparator<University> BY_NAME = (u1, u2) -> u1.getName().compareTo(u2.getName());
    public static final Comparator<University> BY_COUNTRY = (u1, u2) -> u1.getCountry().compareTo(u2.getCountry());
    public static final Comparator<University> BY_THE = (u1, u2) -> Integer.compare(u1.getTherank(), u2.getTherank());
    public static final Comparator<University> BY_ARWU = (u1, u2) -> Integer.compare(u1.getArwurank(), u2.getArwurank());

    @Override
    public int compareTo(University o) {
        Comparator<University> comparator = BY_NAME.thenComparing(BY_COUNTRY).thenComparing((u1, u2) -> Integer.compare(u1.getFounded(), u2.getFounded()) * -1 );

        return comparator.compare(this, o);
    }
}
