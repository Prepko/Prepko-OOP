package hr.fer.oop.ZI2024.zad1;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class MyFileVisitor implements FileVisitor<Path> {

    List<Item> items = new ArrayList<>();

    public List<Item> getItems() {
        return items;
    }

    public double getTotalPrice(){
        double totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getTotalPrice();
        }

        return totalPrice;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String ext = file.toString().substring(file.toString().lastIndexOf("."));

        if(ext.equals(".txt")){
            for(String line: Files.readAllLines(file)){
                String[] split = line.split(";");

                if(split.length != 3){
                    continue;
                }

                String name = split[0];

                int quantity;
                try{
                    quantity = Integer.parseInt(split[1]);
                }
                catch(Exception e){
                    continue;
                }

                double price;

                try{
                    price = Double.parseDouble(split[2]);
                }
                catch(Exception e){
                    continue;
                }

                Item item = new Item(name, quantity, price);
                items.add(item);
            }
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
}
