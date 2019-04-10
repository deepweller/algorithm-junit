package codingtest.kakaoej;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Solution2 {
    /*
     * Complete the 'customSort' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static void customSort(List<Integer> arr) {
        // Write your code here
        arr.sort(Comparator.naturalOrder());
        Map<Integer, Integer> map = new HashMap<>();

        IntStream.range(0, arr.size())
                .forEach(i -> {
                    int key = arr.get(i);
                    int count = Optional.ofNullable(map.get(key)).orElse(0);
                    map.put(key, count + 1);
                });

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Comparator<Map.Entry<Integer, Integer>> keyComparator = Comparator.comparing(Map.Entry::getKey);
        Collections.sort(list, keyComparator);

        Comparator<Map.Entry<Integer, Integer>> valueComparator = Comparator.comparing(Map.Entry::getValue);
        Collections.sort(list, valueComparator);

        Iterator<Map.Entry<Integer, Integer>> iter = list.iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer, Integer> entry = iter.next();
            IntStream.range(0, entry.getValue())
                    .forEach(n -> System.out.println(entry.getKey()));
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        Solution2.customSort(arr);

        bufferedReader.close();
    }

}
