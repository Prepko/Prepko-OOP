package hr.fer.oop.ZI2024.zad4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
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

    public Country getCountry() {
        return country;
    }

    public int getRating() {
        return rating;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String toString() {
        return String.format("(%s) %s %s %d: %d", country, firstname, lastname, birthYear, rating);
    }

    public static Stream<ChessPlayer> getOldChessPlayers(List<ChessPlayer> lplayers, int year){
        return lplayers.stream()
                .filter(p -> p.getBirthYear() < year)
                .sorted(Comparator.comparing(ChessPlayer::getRating));

    }

    public static int getBestRating(Stream<ChessPlayer> cpstream, Country country){
         OptionalInt maxRating = cpstream.filter(p -> p.getCountry() == country)
                .mapToInt(p -> p.getRating())
                .max();

         if (maxRating.isPresent()){
             return maxRating.getAsInt();
         }

         return -1;

    }

    public static String getGoodPlayers(Stream<ChessPlayer> cpstream, int ratingthreshold){
        return cpstream.filter(p -> p.getRating() > ratingthreshold)
                .map(p -> p.getLastname()  + ", " + p.getFirstname())
                .collect(Collectors.joining("; "));
    }

    public static Map<Country, Integer> getPlayersForCountry(Stream<ChessPlayer> cpstream){
        return cpstream.collect(Collectors.toMap(p -> p.getCountry(), p -> 1, (p1, p2) -> p1 + p2));
    }
}
