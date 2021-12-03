package aoc.day1;

import aoc.util.FileUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        final List<String> depths = FileUtil.readFileAsLines("day1Input1.txt");
        int count = 0;
        for (int i = 1; i < depths.size() - 2; i++) {
            sumFromIndex(i, depths);
            if (sumFromIndex(i - 1, depths) < sumFromIndex(i, depths)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static int sumFromIndex(int i, List<String> depths) {
        return Integer.parseInt(depths.get(i)) + Integer.parseInt(depths.get(i + 1)) + Integer.parseInt(depths.get(i + 2));
    }
}
