package uppgift;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumBruteForce {

  public static List<int[]> threeSum(int[] numbers) {
    List<int[]> res = new ArrayList<>();

    for (int i = 0; i < numbers.length; i++) {
      for (int j = 0; j < numbers.length; j++) {
        for (int k = 0; k < numbers.length; k++) {
          if (i == j || i == k || j == k) {
            continue;

          } 
          
          if ((numbers[i] + numbers[j] + numbers[k]) == 0) {
            res.add(new int[] { numbers[i], numbers[k], numbers[j] });
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
