package aoc.day3;

import aoc.util.FileUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> lines = FileUtil.readFileAsLines("day3Input1.txt");
        List<Integer> sumsOfDigits = new ArrayList<>(lines.get(0).length());
        for (int i = 0; i < lines.get(0).length(); i++) {
            sumsOfDigits.add(0);
        }
        for (String line : lines) {
            final char[] chars = line.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                sumsOfDigits.set(i, sumsOfDigits.get(i) + (chars[i] - '0'));
            }
        }
        String gama = "";
        String epsilon = "";
        for (Integer sumsOfDigit : sumsOfDigits) {
            gama += sumsOfDigit/(lines.size()/2);
            epsilon += (sumsOfDigit/(lines.size()/2) == 0) ? "1" : "0";
        }
        System.out.println(Integer.parseInt(gama, 2));
        System.out.println(Integer.parseInt(epsilon, 2));
        System.out.println(Integer.parseInt(gama, 2)*Integer.parseInt(epsilon, 2));
    }
}
