package aoc.day2;

import aoc.util.FileUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Solution2 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> lines = FileUtil.readFileAsLines("day2Input1.txt");
        AtomicLong position = new AtomicLong(0);
        AtomicLong aim = new AtomicLong(0);
        AtomicLong depth = new AtomicLong(0);
        for (String line : lines) {
            if (line.startsWith("forward")) {
                position.addAndGet(Long.parseLong(line.split(" ")[1]));
                depth.addAndGet(Long.parseLong(line.split(" ")[1])*aim.get());
            } else if (line.startsWith("up")) {
                aim.addAndGet(-1*Long.parseLong(line.split(" ")[1]));
            }
            if (line.startsWith("down")) {
                aim.addAndGet(Long.parseLong(line.split(" ")[1]));
            }
        }
        System.out.println(position.get()*depth.get());
    }
}
