package uppgift1;

import java.util.concurrent.Callable;

public class TimeIt {

  public static <T> long timeIt(Callable<T> code, int repetitions) throws Exception {
    long start = System.nanoTime();

    for (int i = 0; i < repetitions; i++) {
      code.call();
    }

    long end = System.nanoTime();
    return (end - start) / repetitions; // return avg per time in ns
  }

  public static void main(String[] args) {

    // Example function to test 
    Callable<Void> code = () -> {
        int sum = 0;
        for (int i = 0; i < 10000; i++) {
            sum += i;
        }
        return null;  // returning null here in example function because I used Callable<Void>
    };

    try {
        long avg = timeIt(code, 10000);
        System.out.println("Average execution time of the 10000 times the code was executed is:  " + avg + " nanoseconds.");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
