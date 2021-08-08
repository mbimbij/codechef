package org.example;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

public class CountTxtFilesTest {
    @Test
    void canListFiles() {
        CountTxtFiles countTxtFiles = new CountTxtFiles();
        List<String> files = countTxtFiles.count(Path.of("src/test/resources"));
        System.out.println();
    }
}
