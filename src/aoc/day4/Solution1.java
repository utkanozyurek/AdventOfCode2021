package aoc.day4;

import aoc.util.FileUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Solution1 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> lines = FileUtil.readFileAndSplit("\n\n", "day4Input1.txt");
        final String numbers = lines.get(0);
        lines = lines.subList(1, lines.size());
        List<String> boards = lines.stream().map(l -> (" " + l + " ").replace("\n", " ").replace("  ", " ").replace("  ", " ")).collect(Collectors.toList());

        final String[] numbersToMatch = numbers.split(",");
        for (String toMatch : numbersToMatch) {
            boards = boards.stream().map(board -> board.replace(" " + toMatch + " ", " x ")).collect(Collectors.toList());
            final Optional<String> winner = boards.stream().filter(board -> board.matches("^( \\w+ \\w+ \\w+ \\w+ \\w+)* x x x x x.*") || board.matches(".* x( \\w+ \\w+ \\w+ \\w+) x( \\w+ \\w+ \\w+ \\w+) x( \\w+ \\w+ \\w+ \\w+) x( \\w+ \\w+ \\w+ \\w+) x.*"))
                .findAny();

            if (winner.isPresent()) {
                final Integer result = winner
                    .map(m -> Arrays.stream(m.split(" "))
                    .map(s -> s.equals("x") || s.equals("") ? 0 : Integer.parseInt(s))
                    .reduce(Integer::sum)
                    .orElse(0)).orElse(0);
                System.out.println(winner);
                System.out.println(result);
                System.out.println(toMatch);
                System.out.println(result*Integer.parseInt(toMatch));
                break;
            }
        }
    }
}
