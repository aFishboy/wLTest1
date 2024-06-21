import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static List<String> groupTransactions(List<String> transactions) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String transaction : transactions) {
            countMap.put(transaction, countMap.getOrDefault(transaction, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(countMap.entrySet());

        Collections.sort(entryList, (entry1, entry2) -> {
            int countComparison = entry2.getValue().compareTo(entry1.getValue());
            if (countComparison != 0) {
                return countComparison;
            } else {
                return entry1.getKey().compareTo(entry2.getKey());
            }
        });

        List<String> output = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            output.add(entry.getKey() + " " + entry.getValue());
        }
        return output;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int transactionsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> transactions = IntStream.range(0, transactionsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<String> result = Result.groupTransactions(transactions);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
