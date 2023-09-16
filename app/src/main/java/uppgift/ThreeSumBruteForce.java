package uppgift;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumBruteForce {

  public static List<int[]> threeSum(int[] numbers) {
    List<int[]> res = new ArrayList<>();

    int n = numbers.length;

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {

          if (numbers[i] + numbers[j] + numbers[k] == 0) {
            res.add(new int[] { numbers[i], numbers[j], numbers[k] });
          }

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
