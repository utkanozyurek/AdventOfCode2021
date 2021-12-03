package aoc.day3;

import aoc.util.FileUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution2 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> lines = FileUtil.readFileAsLines("day3Input1.txt");
        List<Integer> sumsOfDigits = new ArrayList<>(lines.get(0).length());
        for (int i = 0; i < lines.get(0).length(); i++) {
            sumsOfDigits.add(0);
        }
        final int length = lines.get(0).length();
        List<String> oxygen = new ArrayList<>(lines);
        List<String> co2 = new ArrayList<>(lines);

        oxygen = getValue(length, oxygen, false);
        co2 = getValue(length, co2, true);

        System.out.println("Results");
        System.out.println(Integer.parseInt(oxygen.get(0), 2));
        System.out.println(Integer.parseInt(co2.get(0), 2));
        System.out.println(Integer.parseInt(oxygen.get(0), 2)*Integer.parseInt(co2.get(0), 2));
    }

    private static List<String> getValue(int length, List<String> oxygen, boolean reverse) {
        for (int i = 0; i < length; i++) {
            final char mostCommonBit = getWantedBit(oxygen, i, reverse);
            int finalI = i;
            oxygen = oxygen.stream()
                .filter(l -> l.charAt(finalI) == mostCommonBit)
                .collect(Collectors.toList());
//            System.out.println(oxygen);
            if (oxygen.size() == 1) {
                break;
            }
        }
        return oxygen;
    }

    private static char getWantedBit(List<String> lines, Integer position, boolean reverse) {
        int count = 0;
        for (String line : lines) {
            count += line.charAt(position) == '1' ? 1 : 0;
        }
        int integer = count/(int) (Math.ceil(lines.size()*1.0/2));
        if (reverse) {
            integer = (integer + 1)%2;
        }
        return ("" + integer).charAt(0);
    }
}
