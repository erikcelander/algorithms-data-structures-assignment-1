package uppgift;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

import uppgift.TimeIt.TimingResult;

public class Application {

  private static int[] generateRandomArray(int length) {
    Random rand = new Random();
    int[] result = new int[length];

    for (int i = 0; i < length; i++) {
      result[i] = rand.nextInt(100) - 50; // Random numbers between -50 and 49, for example
    }

    return result;
  }

  public static void main(String[] args) {
    try {
      for (int length = 334; length < 1001; length += 333) { // Increase the length by 100 each iteration
        int[] nums = generateRandomArray(length);

        System.out.println("Testing with array size: " + length);

        Callable<List<int[]>> bruteForceCallable = () -> ThreeSumBruteForce.threeSum(nums);
        TimingResult bruteForceResult = TimeIt.timeIt(bruteForceCallable, 100);
        System.out.println("Brute Force: " + bruteForceResult.toString());

        Callable<List<int[]>> cacheCallable = () -> ThreeSumCache.threeSum(nums);
        TimingResult cacheResult = TimeIt.timeIt(cacheCallable, 100);
        System.out.println("Cache Method: " + cacheResult.toString());

        System.out.println("----------------------------------");

        
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
