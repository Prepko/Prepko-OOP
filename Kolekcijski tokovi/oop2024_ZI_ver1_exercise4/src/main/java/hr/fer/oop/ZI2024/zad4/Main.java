package hr.fer.oop.ZI2024.zad4;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static hr.fer.oop.ZI2024.zad4.ChessPlayer.*;

public class Main {
    public static void main(String[] args) {
        List<ChessPlayer> players = ChessPlayerData.loadChessPlayersTop();

        Stream<ChessPlayer> cpstream = getOldChessPlayers(players, 1990);
        System.out.println("Chess players born before 1990:");
        cpstream.forEach(cp -> System.out.println(cp));

        int maxratingusa =  getBestRating(players.stream(), Country.USA);
        int maxratinggermany =  getBestRating(players.stream(), Country.GERMANY);

        System.out.printf("\nBest rating in USA: %d", maxratingusa);
        System.out.printf("\nBest rating in Germany: %d", maxratinggermany);

        String goodplayers = getGoodPlayers(players.stream(), 2780);
        System.out.println("\n\nVery good players: " + goodplayers);

        System.out.println("\nCountry map:");
        Map<Country, Integer> cplayers = getPlayersForCountry(players.stream());
        cplayers.forEach((k,v) -> System.out.println(k + ": " + v));
    }
}
