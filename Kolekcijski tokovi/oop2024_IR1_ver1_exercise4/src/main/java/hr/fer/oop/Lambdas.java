package hr.fer.oop;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Lambdas {
    public static BiConsumer<Stream<String>, 
            Map<Pair<String, String>, Collection<Pair<Integer, Long>>>> loadFromStream = (lines, map) -> {
            lines.map(line -> line.split(";"))
                    .forEach(arr -> map.compute(new Pair<>(arr[0], arr[1]), (k, v) -> {
                        if(v == null){
                            v = new ArrayList<>();
                        }

                        v.add(new Pair<>(Integer.parseInt(arr[2]), Long.parseLong(arr[3])));
                        return v;
                    }));
    }; //TODO


    public static BiFunction<Map<Pair<String, String>, Collection<Pair<Integer, Long>>>, 
            String, Triple<String, Integer, Long>> getMinForIncomingCountry = (map, incomingCountry) ->
            map.entrySet()
                    .stream()
                    .filter(entry -> entry.getKey().first().equals(incomingCountry))
                    .map(entry -> new Pair<>(entry.getKey().second(), entry.getValue().stream().sorted(Comparator.comparing(Pair::second)).findFirst().get()))
                    .map(pair -> new Triple<>(pair.first(), pair.second().first(), pair.second().second()))
                    .sorted(Comparator.comparing(Triple::third))
                    .findFirst().get();//TODO
            

    public static BiFunction<Map<Pair<String, String>, Collection<Pair<Integer, Long>>>, 
            Integer, Collection<Triple<String, String, Long>>> getValuesForYear = (map, year) ->
            map.entrySet()
                    .stream()
                    .map(entry -> new Triple<>(entry.getKey().first(), entry.getKey().second(), entry.getValue().stream().filter(pair -> pair.first().intValue() == year).findFirst()))
                    .map(triple -> new Triple<>(triple.first(), triple.second(), triple.third().get().second()))
                    .collect(Collectors.toList());//TODO

}
