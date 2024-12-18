package Day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Part1 {
    public static void main(String[] args) throws IOException {
        ArrayList<Long> list  = Arrays.stream(Arrays.stream(Files.readAllLines(Path.of("./2024/src/Day11/input.txt")).getFirst().split(" ")).mapToLong(Integer::parseInt).toArray()).boxed().collect(Collectors.toCollection(ArrayList::new));
        for(int i = 0; i < 25; i++) {
            System.out.println(i);
            for(int j = 0; j < list.size(); j++) {
                long number = list.get(j);
                String stringNumber = String.valueOf(number);
                if(number == 0) {
                    list.set(j, 1L);
                } else if(stringNumber.length() % 2 == 0) {
                    int middle = stringNumber.length() / 2;
                    String firstNumber = stringNumber.substring(middle);
                    String secondNumber = stringNumber.substring(0, middle);
                    list.set(j, Long.parseLong(firstNumber));
                    list.add(j + 1, Long.parseLong(secondNumber));
                    j++;
                } else {
                    list.set(j, number * 2024);
                }
            }
        }
        System.out.println(list.size());
    }
}
