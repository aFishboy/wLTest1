import java.util.*;

public class KeyCounter {
    public static void main(String[] args) {
        List<String> keys = Arrays.asList("apple", "banana", "apple", "orange", "banana", "banana", "apple", "pear", "pear", "pear", "apple");
        
        Map<String, Integer> countMap = new HashMap<>();
        for (String key : keys) {
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
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
        
        for (String line : output) {
            System.out.println(line);
        }
    }
}