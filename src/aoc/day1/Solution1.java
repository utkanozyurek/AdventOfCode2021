package aoc.day1;

import aoc.util.FileUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Solution1 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        final List<String> depths = FileUtil.readFileAsLines("day1Input1.txt");
        int count = 0;
        for (int i = 1; i < depths.size(); i++) {
            if (Integer.parseInt(depths.get(i - 1)) < Integer.parseInt(depths.get(i))) {
                count++;
            }
        }
        System.out.println(count);
    }
}
