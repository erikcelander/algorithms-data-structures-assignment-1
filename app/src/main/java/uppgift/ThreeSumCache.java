package uppgift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class ThreeSumCache {
  public static List<int[]> threeSum(int[] numbers) {
    List<int[]> res = new ArrayList<>();

    Arrays.sort(numbers);

    for (int i = 0; i < numbers.length; i++) {
      
      // if we aren't at index 0 and the value is the same 
      // as previous index, skip to avoid duplicates
      if (i != 0 && numbers[i] == numbers[i - 1]) {
        continue;
      }

      int target = -numbers[i]; // the sum we want to find using the other two numbers

      Map<Integer, Integer> cache = new HashMap<>();

      for (int j = i + 1; j < numbers.length; j++) {

        int complement = target - numbers[j]; // the value of the last number for the sum to be 0

        if (cache.containsKey(complement)) {
          res.add(new int[] { numbers[i], numbers[j], complement });
        } else {
          cache.put(numbers[j], j);
        }
      }
    }

    return res;
  }

  public static void main(String[] args) {
    int[] nums = {-1, -1, 0, 1, 1};

    List<int[]> result = threeSum(nums);

    for (int[] triplet : result) {
      System.out.println(Arrays.toString(triplet));
    }
  }
}
