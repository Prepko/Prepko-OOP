package hr.fer.oop.ZI2024.zad2;

import java.util.Comparator;
import java.util.Objects;

public class ChessPlayer implements Comparable<ChessPlayer> {
    private String firstname;
    private String lastname;
    private Country country;
    private int rating;
    private int birthyear;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Country getCountry() {
        return country;
    }

    public int getRating() {
        return rating;
    }

    public int getBirthyear() {
        return birthyear;
    }

    public ChessPlayer(String firstname, String lastname, Country country, int rating, int birthyear){
        this.firstname = firstname;
        this.lastname = lastname;
        this.country = country;
        this.rating = rating;
        this.birthyear = birthyear;
    }

    public String toString() {
        return String.format("(%s) %s %s %d: %d", country, firstname, lastname, birthyear, rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getFirstname(), this.getLastname(), this.getBirthyear());
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ChessPlayer)) return false;

        ChessPlayer ch = (ChessPlayer) obj;
        return ch.getFirstname().equals(this.getFirstname()) &&
                ch.getLastname().equals(this.getLastname()) &&
                ch.getBirthyear() == this.getBirthyear();

    }

    public static final Comparator<ChessPlayer> BY_LASTNAME = (c1, c2) -> c1.getLastname().compareTo(c2.getLastname());
    public static final Comparator<ChessPlayer> BY_FIRSTNAME = (c1, c2) -> c1.getFirstname().compareTo(c2.getFirstname());
    public static final Comparator<ChessPlayer> BY_BIRTHYEAR = (c1, c2) -> Integer.compare(c1.getBirthyear(), c2.getBirthyear());

    @Override
    public int compareTo(ChessPlayer o) {
        Comparator<ChessPlayer> comp = BY_LASTNAME.thenComparing(BY_FIRSTNAME).thenComparing(BY_BIRTHYEAR.reversed());

        return comp.compare(this, o);
    }
}
