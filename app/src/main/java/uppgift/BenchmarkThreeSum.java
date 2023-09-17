
package uppgift;

import java.util.concurrent.Callable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Random;

public class BenchmarkThreeSum {

  private static final int[] sizes = { 200, 400, 800, 1600 };
  private static final int iterations = 7;
  private static final int repetitions = 2000;
  private static final Random rand = new Random();
  private static final DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
  private static final DecimalFormat df = new DecimalFormat("0.00", symbols);

  public static void main(String[] args) throws Exception {

    for (int size : sizes) {
      int[] numbers = generateRandomIntegers(size);

      long totalBruteForceTime = 0;
      long totalCacheResult = 0;

      for (int iteration = 0; iteration < iterations; iteration++) {

        Callable<Void> bruteForceCode = () -> {
        ThreeSumBruteForce.threeSum(numbers);
        return null;
        };
        TimeIt.TimingResult bruteForceResult = TimeIt.timeIt(bruteForceCode,
        repetitions);
        totalBruteForceTime += bruteForceResult.avg;

        Callable<Void> cacheCode = () -> {
          ThreeSumCache.threeSum(numbers);
          return null;
        };
        TimeIt.TimingResult cacheResult = TimeIt.timeIt(cacheCode, repetitions);
        totalCacheResult += cacheResult.avg;

      }

      long averageBruteForceTime = totalBruteForceTime / iterations;
      long averageCacheTime = totalCacheResult / iterations;

      System.out.println("Size: " + size);
      System.out.println("ThreeSum Brute Force Average Time: " + df.format(averageBruteForceTime / 1_000_000.0) + " ms");
      System.out.println("ThreeSum Cache Average Time: " +df.format(averageCacheTime / 1_000_000.0) + " ms");
      System.out.println("-------------------------------------------------");
    }
  }

  private static int[] generateRandomIntegers(int size) {
    int[] numbers = new int[size];
    for (int i = 0; i < size; i++) {
      numbers[i] = rand.nextInt(size) - size;
    }
    return numbers;
  }
}
