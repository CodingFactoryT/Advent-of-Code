package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {
    public static void main(String[] args) throws IOException {
        List<String> inputLines = Files.readAllLines(Path.of("./2024/src/Day3/input.txt"));
        Pattern pattern = Pattern.compile("mul\\(([0-9]+),([0-9]+)\\)|(do\\(\\))|(don't\\(\\))");
        int sum = 0;
        boolean isEnabled = true;
        for(int i = 0; i < inputLines.size(); i++) {
            Matcher matcher = pattern.matcher(inputLines.get(i));

            while(matcher.find()) {
                if(matcher.group(0).equals("do()")) {
                    isEnabled = true;
                } else if(matcher.group(0).equals("don't()")) {
                    isEnabled = false;
                } else if(isEnabled) {
                    int firstNumber = Integer.parseInt(matcher.group(1));
                    int secondNumber = Integer.parseInt(matcher.group(2));
                    sum += firstNumber * secondNumber;
                }
            }
        }

        System.out.println(sum);
    }

}
