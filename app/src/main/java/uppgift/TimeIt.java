package uppgift;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class TimeIt {

  public static class TimingResult {
    public final int repetitions;
    public final long min;
    public final long median;
    public final long avg;
    public final long max;

    public TimingResult(long min, long median, long avg, long max, int repetitions) {
      this.repetitions = repetitions;
      this.min = min;
      this.median = median;
      this.avg = avg;
      this.max = max;
    }

    @Override
    public String toString() {
      return "Min: " + min + " ns, Median: " + median + " ns, Avg: " + avg + " ns, Max: " + max + " ns." +
          " This was calculated by executing the code " + repetitions + " times."; // Updated string to include reps
    }
  }

  public static <T> TimingResult timeIt(Callable<T> code, int repetitions) throws Exception {
    long[] times = new long[repetitions];

    for (int i = 0; i < repetitions; i++) {
      long start = System.nanoTime();
      code.call();
      long end = System.nanoTime();
      times[i] = end - start;
    }

    Arrays.sort(times);
    long total = Arrays.stream(times).sum();
    long avg = total / repetitions;
    long min = times[0];
    long median = times[repetitions / 2];
    long max = times[repetitions - 1];

    return new TimingResult(min, median, avg, max, repetitions);
  }

  public static void main(String[] args) {

    // Example function to test the functionality
    Callable<Void> code = () -> {
      int sum = 0;
      for (int i = 0; i < 100; i++) {
        sum += i;
      }
      return null; // returning null here in this example lambda/anonymous function because I used Callable<Void>
    };

    try {
      TimingResult res = timeIt(code, 10000);
      System.out.println(res.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
