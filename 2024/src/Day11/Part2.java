package Day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Part2 {
    public static void main(String[] args) throws IOException {
        LinkedList<Integer> list  = Arrays.stream(Arrays.stream(Files.readAllLines(Path.of("./2024/src/Day11/input.txt")).getFirst().split(" ")).mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toCollection(LinkedList::new));

    }
}
