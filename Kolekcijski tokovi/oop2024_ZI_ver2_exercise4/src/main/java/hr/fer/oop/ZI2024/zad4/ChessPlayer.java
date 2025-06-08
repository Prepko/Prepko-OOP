package hr.fer.oop.ZI2024.zad4;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChessPlayer {
    private String firstname;
    private String lastname;
    private Country country;
    private int rating;
    private int birthYear;

    public ChessPlayer(String firstname, String lastname, Country country, int rating, int birthYear){
        this.firstname = firstname;
        this.lastname = lastname;
        this.country = country;
        this.rating = rating;
        this.birthYear = birthYear;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getRating() {
        return rating;
    }

    public Country getCountry() {
        return country;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String toString() {
        return String.format("(%s) %s %s %d: %d", country, firstname, lastname, birthYear, rating);
    }

    public static Stream<ChessPlayer> getGoodChessPlayers(List<ChessPlayer> lplayers, int ratingthreshold){
        return lplayers.stream()
                .filter(chessPlayer -> chessPlayer.getRating() > ratingthreshold)
                .sorted(Comparator.comparing(ChessPlayer::getBirthYear).reversed());
    }

    public static double getAvgRating(Stream<ChessPlayer> cpstream, Country country){
        OptionalDouble averageRating = cpstream.filter(p -> p.getCountry() == country)
                .mapToInt(p -> p.getRating())
                .average();

        if (averageRating.isPresent()){
            return averageRating.getAsDouble();
        }
        else return 0;
    }

    public static String getFilteredPlayers(Stream<ChessPlayer> cpstream, Predicate<ChessPlayer> filter){
        return cpstream.filter(filter)
                .map(p -> p.getLastname() + ", " + p.getFirstname())
                .collect(Collectors.joining("; "));
    }

    public static Map<Country, Integer> getMaxRatingForCountry(Stream<ChessPlayer> cpstream){
        return cpstream.collect(Collectors.toMap(ChessPlayer::getCountry, p -> p.getRating(), (a, b) -> {
            if(a > b) return a;
            else return b;
        }));
    }
}
