package chapter1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import util.CalcTime;

public class Ex_1_1_1 {
    private static final String PROJECT_DIR = System.getProperty("user.dir");
    private static final String READ_PATH = PROJECT_DIR + "/testfiles/ex_1_1_1_read.txt";
    private static final String WRITE_PATH = PROJECT_DIR + "/testfiles/ex_1_1_1_write.txt";

    public static void main(final String[] args) {

        Runnable runnable = () -> {
            Path read_path = Paths.get(READ_PATH);
            Path write_path = Paths.get(WRITE_PATH);
            try {
                List<String> lines = Files.readAllLines(read_path, StandardCharsets.UTF_8);
                Collections.reverse(lines);
                try (BufferedWriter writer = Files.newBufferedWriter(write_path)) {
                    for (String str : lines) {
                        writer.append(str);
                        writer.newLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (final IOException e) {
                e.printStackTrace();
            }
        };

        CalcTime.calcTime(runnable);
    }
}