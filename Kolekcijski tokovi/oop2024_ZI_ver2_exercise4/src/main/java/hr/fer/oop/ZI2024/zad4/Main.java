package hr.fer.oop.ZI2024.zad4;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static hr.fer.oop.ZI2024.zad4.ChessPlayer.*;

public class Main {
    public static void main(String[] args) {
        List<ChessPlayer> players = ChessPlayerData.loadChessPlayersTop();

        Stream<ChessPlayer> cpstream = getGoodChessPlayers(players, 2770);
        System.out.println("Chess players with rating over 2770:");
        cpstream.forEach(cp -> System.out.println(cp));

        double avgratingusa =  getAvgRating(players.stream(), Country.USA);
        double avgratinggermany =  getAvgRating(players.stream(), Country.GERMANY);

        System.out.printf("\nAverage rating in USA: %.2f", avgratingusa);
        System.out.printf("\nAverage rating in Germany: %.2f", avgratinggermany);

        String filteredplayers = getFilteredPlayers(players.stream(), cp -> cp.getCountry() == Country.CHINA);
        System.out.println("\n\nPlayers from China: " + filteredplayers);

        System.out.println("\nCountry map:");
        Map<Country, Integer> cplayers = getMaxRatingForCountry(players.stream());
        cplayers.forEach((k,v) -> System.out.println(k + ": " + v));
    }
}
