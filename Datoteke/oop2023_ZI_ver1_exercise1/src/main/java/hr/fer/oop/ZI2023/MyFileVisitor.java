package hr.fer.oop.ZI2023;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Set;

public class MyFileVisitor extends SimpleFileVisitor<Path> {
    private int numFiles = 0;
    private int numFolders = 0;
    private long largestFileSize = 0;

    Set<String> extensions = new HashSet<>();

    public MyFileVisitor(String[] extensions) {
        this.extensions = Set.of(extensions);
    }

    public int getNumFiles() {
        return numFiles;
    }

    public int getNumFolders() {
        return numFolders;
    }

    public long getLargestFileSize() {
        return largestFileSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String ext = file.toString().substring(file.toString().lastIndexOf("."));

        if(extensions.contains(ext)) {
            numFiles++;
            if(largestFileSize < attrs.size()) {
                largestFileSize = attrs.size();
            }
        }

        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        numFolders++;
        return super.preVisitDirectory(dir, attrs);
    }
}
