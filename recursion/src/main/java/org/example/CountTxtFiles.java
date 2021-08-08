package org.example;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class CountTxtFiles {
    @SneakyThrows
    public List<String> count (Path startDirectory) {
        List<String> txtFiles = Files.list(startDirectory)
                .filter(path -> path.getFileName().toString().endsWith(".txt"))
                .map(Path::toAbsolutePath)
                .map(Path::toString)
                .collect(Collectors.toList());

        Files.list(startDirectory)
                .filter(Files::isDirectory)
                .forEach(subDirectory -> {
                    txtFiles.addAll(count(subDirectory));
                });

        return txtFiles;
    }
}
