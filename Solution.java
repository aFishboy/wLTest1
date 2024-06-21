import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static List<String> aPlusB(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            // Split the line into two parts
            String[] parts = line.split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            int sum = a + b;
            result.add(String.valueOf(sum));
        }
        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int linesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> lines = IntStream.range(0, linesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<String> result = Result.aPlusB(lines);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
