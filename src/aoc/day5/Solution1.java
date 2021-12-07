package aoc.day5;

import aoc.util.FileUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution1 {
    static int numberOfMoreThan1s = 0;
    public static void main(String[] args) throws IOException, URISyntaxException {
        Map<Integer, Map<Integer, Integer>> coordinateSystem = new HashMap<>();
        final List<List<Integer>> input = FileUtil.readFileAsLines("day5Input1.txt")
            .stream().map(c -> Arrays.stream(c.split("( -> |,)")).map(Integer::valueOf).collect(Collectors.toList()))
            .collect(Collectors.toList());
        input.forEach(coordinate -> {
            if (coordinate.get(0).equals(coordinate.get(2)) || coordinate.get(1).equals(coordinate.get(3))) {
                int x = Math.min(coordinate.get(0), coordinate.get(2));
                int y = Math.min(coordinate.get(1), coordinate.get(3));
                for (int i = 0; i <= Math.abs(coordinate.get(0) - coordinate.get(2)); i++) {
                    int currentX = x+i;
                    for (int j = 0; j <= Math.abs(coordinate.get(1) - coordinate.get(3)); j++) {
                        int currentY = y+j;
                        coordinateSystem.putIfAbsent(currentX, new HashMap<>());
                        increase(coordinateSystem.get(currentX), currentY, currentX);
                    }
                }
            } else {
                int x = coordinate.get(0);
                int y = coordinate.get(1);
                int xDirection = (int) Math.signum((coordinate.get(0)-coordinate.get(2)))*-1;
                int yDirection = (int) Math.signum((coordinate.get(1)-coordinate.get(3)))*-1;
                for (int i = 0; i <= Math.abs(coordinate.get(0) - coordinate.get(2)); i++) {
                    int currentX = x+(i*xDirection);
                    int currentY = y+(i*yDirection);
                    coordinateSystem.putIfAbsent(currentX, new HashMap<>());
                    increase(coordinateSystem.get(currentX), currentY, currentX);

                }
            }
        });
        System.out.println(numberOfMoreThan1s);

    }

    private static void increase(Map<Integer, Integer> yMap, int y, int x) {
        yMap.putIfAbsent(y, 0);
        yMap.compute(y, (k, v) -> v == null ? 1 : v + 1);
        if(yMap.get(y) == 2){
            System.out.println("x:"+x+"y:"+y);
            numberOfMoreThan1s++;
        }
    }
}
