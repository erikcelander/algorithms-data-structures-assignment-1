package uppgift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class ThreeSumCache {
  public static List<int[]> threeSum(int[] numbers) {
    List<int[]> res = new ArrayList<>();

    Arrays.sort(numbers); // sort to help find/avoid duplicates later

    // start outer loop, where numbers[i] is the first value of a potential
    // unique triplet of values equating to 0
    for (int i = 0; i < numbers.length; i++) {

      // if we aren't at index 0 (because then there would be no previous index)
      // and the value is the same as the previous index, skip to avoid duplicates
      if (i != 0 && numbers[i] == numbers[i - 1]) {
        continue;
      }

      int first = numbers[i]; // store the current number of the outer loop as 'first'
      int difference = -first; // the combined value of the two other numbers we need to sum the triplet to 0

      // create hashmap and iterate over the array to store each unique value and the count/frequency of that value
      Map<Integer, Integer> cache = new HashMap<>();
      for (int k = i + 1; k < numbers.length; k++) {

        // use getOrDefault() to check if numbers[k] exists in cache
        // if it doesn't, add it and set count to 1 (0 + 1)
        // if it does, increment count by 1
        cache.put(numbers[k], cache.getOrDefault(numbers[k], 0) + 1);
      }


      // loop through the remaining elements of the array to find potential combinations
      for (int j = i + 1; j < numbers.length; j++) {

        // 'j' > 'i' + 1 ensures that this inner loop always is one step ahead of the outer one
        // check if number is same as previous, then skip to avoid duplicates
        if (j > i + 1 && numbers[j] == numbers[j - 1]) {
          continue;
        }
      
        int second = numbers[j]; // store the current number of the inner loop as 'second'
        int third = difference - second; // calculate what the third number is that we need to sum all 3 to 0


        // check if 'third' exists in cache
        if (cache.getOrDefault(third, 0) > 0) {

          // check if 'third' and 'second' is
          // 1. different numbers
          // 2. same number but we know there is more then 1
          // if either of these scenarios are true, we have found a triplet
          if ((third != second) || (third == second && cache.get(third) > 1)) {
            res.add(new int[] {first, second, third });
          }
        }

        // decrement count of 'second' as we're now iterating past it
        cache.put(second, cache.get(second) - 1);
      }
    }

    return res;
  }


  public static void main(String[] args) {
    int[] nums = { -4, -2, -2, -1, 0, 1, 2, 2, 3, 4 };

    List<int[]> result = threeSum(nums);

    for (int[] triplet : result) {
      System.out.println(Arrays.toString(triplet));
    }
  }
}
