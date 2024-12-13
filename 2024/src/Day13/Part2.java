
package Day13;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {
    public static void main(String[] args) throws Exception {
        List<String> input  = Files.readAllLines(Path.of("./2024/src/Day13/input.txt"));
        double[][] solvedGauss = parseAndSolveGauss(input);

        long sum = 0;
        int i = 0;
        for(double[] l : solvedGauss) {
            if(l[0] > 0 && isEffectivelyLong(l[0]) && l[1] > 0 && isEffectivelyLong(l[1])) {
                sum += 3 * l[0] + l[1];
            }
            i++;
        }
        System.out.println(sum);
    }

    private static double[][] parseAndSolveGauss(List<String> input) throws Exception {
        Iterator<String> inputIterator = input.iterator();
        double[][] solvedGauss = new double[input.size() / 4 + 1][2];
        ArrayList<Long> localGaussList = new ArrayList<>();
        Pattern pattern = Pattern.compile("X[+=](\\d+), Y[+=](\\d+)");
        int index = 0;
        while(inputIterator.hasNext()) {
            String currentLine = inputIterator.next();
            if(currentLine.isBlank()) {
                computeGauss(localGaussList, solvedGauss, index);
                index++;
                localGaussList.clear();
                continue;
            }

            for(int i = 0; i < 3; i++) {
                Matcher matcher = pattern.matcher(currentLine);
                if(matcher.find()) {
                    long firstNum = Integer.parseInt(matcher.group(1));
                    long secondNum = Integer.parseInt(matcher.group(2));
                    if(i == 2) {
                        firstNum += 10000000000000L;
                        secondNum += 10000000000000L;
                    }
                    localGaussList.add(firstNum);
                    localGaussList.add(secondNum);
                } else {
                    throw new Exception("Matcher didn't find anything but should have found something!");
                }
                if(i != 2) {
                    currentLine = inputIterator.next();
                }
            }
        }

        computeGauss(localGaussList, solvedGauss, index);

        return solvedGauss;
    }

    private static boolean isEffectivelyLong(double number) {
        double tolerance = 1e-2;
        return Math.abs(number - Math.round(number)) < tolerance;
    }


    private static void computeGauss(ArrayList<Long> localGaussList, double[][] solvedGauss, int index) {
        double[][] A = new double[][]{{localGaussList.get(0), localGaussList.get(2)}, {localGaussList.get(1), localGaussList.get(3)}};
        double[] x = new double[]{localGaussList.get(4), localGaussList.get(5)};
        double[] gaussSolution = GaussianElimination.lsolve(A, x);
        solvedGauss[index][0] = gaussSolution[0];
        solvedGauss[index][1] = gaussSolution[1];
    }

}
