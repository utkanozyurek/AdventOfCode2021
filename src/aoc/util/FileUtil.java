package aoc.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileUtil {
    public static List<String> readFileAsLines(String filename) throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(FileUtil.class.getClassLoader().getResource(filename).toURI()));
    }

    public static List<String> readFileAndSplit(String delimeter, String fileName) throws IOException, URISyntaxException {
        return Arrays.asList(new String(Files.readAllBytes(Paths.get(FileUtil.class.getClassLoader().getResource(fileName).toURI())))
            .split(delimeter));
    }
}
