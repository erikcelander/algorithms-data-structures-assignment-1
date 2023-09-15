package uppgift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class ThreeSumCache {
  public static List<int[]> threeSum(int[] numbers) {
    List<int[]> res = new ArrayList<>();

    for (int i = 0; i < numbers.length; i++) {

      int target = -numbers[i]; // the sum we want to find using the other two numbers

      Map<Integer, Integer> cache = new HashMap<>();

      for (int j = 0; j < numbers.length; j++) {
        if (i == j) {
          continue; // skip the same number
        }

        int complement = target - numbers[j];

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
    int[] nums = { -2, -1, 0, 1, 2 };
    List<int[]> result = threeSum(nums);

    for (int[] triplet : result) {
      System.out.println(Arrays.toString(triplet));
    }
  }
}
