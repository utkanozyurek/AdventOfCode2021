package aoc.day4;

import aoc.util.FileUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Solution2 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> lines = FileUtil.readFileAndSplit("\n\n", "day4Input1.txt");
        final String numbers = lines.get(0);
        lines = lines.subList(1, lines.size());
        List<String> boards = lines.stream().map(l -> (" " + l + " ").replace("\n", " ").replace("  ", " ").replace("  ", " ")).collect(Collectors.toList());

        final String[] numbersToMatch = numbers.split(",");
        Optional<String> latest = null;
        String latestToMatch = null;
        for (String toMatch : numbersToMatch) {
            boards = boards.stream().map(board -> board.replace(" " + toMatch + " ", " x ")).collect(Collectors.toList());
            Optional<String> winner;
            do {
                winner = boards.stream().filter(board -> board.matches("^( \\w+ \\w+ \\w+ \\w+ \\w+)* x x x x x.*") || board.matches(".* x( \\w+ \\w+ \\w+ \\w+) x( \\w+ \\w+ \\w+ \\w+) x( \\w+ \\w+ \\w+ \\w+) x( \\w+ \\w+ \\w+ \\w+) x.*"))
                    .findAny();

                if (winner.isPresent()) {
                    latest = winner;
                    latestToMatch = toMatch;
                    boards.remove(winner.get());
                }
            }while (winner.isPresent());
        }

        final Integer result = latest.map(m -> Arrays.stream(m.split(" "))
                .map(s -> s.equals("x") || s.equals("") ? 0 : Integer.parseInt(s))
                .reduce(Integer::sum)
                .orElse(0)).orElse(0);
        System.out.println(latest);
        System.out.println(result);
        System.out.println(latestToMatch);
        System.out.println(result*Integer.parseInt(latestToMatch));
    }
}
