package aoc.day2;

import aoc.util.FileUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Solution1 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> lines = FileUtil.readFileAsLines("day2Input1.txt");
        AtomicLong position = new AtomicLong(0);
        AtomicLong depth = new AtomicLong(0);
        lines.forEach(line -> {
            if (line.startsWith("forward")) {
                position.addAndGet(Long.parseLong(line.split(" ")[1]));
            } else if (line.startsWith("up")) {
                depth.addAndGet(-1*Long.parseLong(line.split(" ")[1]));
            }
            if (line.startsWith("down")) {
                depth.addAndGet(Long.parseLong(line.split(" ")[1]));
            }
        });
        System.out.println(position.get()*depth.get());
    }
}
