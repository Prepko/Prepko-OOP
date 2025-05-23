package hr.fer.oop;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SecretFileVisitor implements FileVisitor<Path> {
    private String decryptionKey;
    private int secretFileCount;
    private List<Path> foundFiles;

    public SecretFileVisitor(String decryptionKey) {
        this.decryptionKey = decryptionKey;
        this.secretFileCount = 0;
        this.foundFiles = new ArrayList<>();
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public int getSecretFileCount() {
        return secretFileCount;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(Files.isRegularFile(file)) {
            String decryptedText = decryptText(file);

            if(decryptedText.contains(decryptionKey)) {
                foundFiles.add(file);
                secretFileCount++;
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

    public String decryptText(Path path) throws IOException {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader bf = Files.newBufferedReader(path)){
            String line = bf.readLine();
            while(line != null) {
                String decryptedLine = decrypt(line);

                sb.append(decryptedLine);
                sb.append('\n');

                line = bf.readLine();
            }
        }

        return sb.toString();
    }

    public String decrypt(String text){
        StringBuilder sb = new StringBuilder(text);
        sb.reverse();
        return sb.toString();
    }
}
