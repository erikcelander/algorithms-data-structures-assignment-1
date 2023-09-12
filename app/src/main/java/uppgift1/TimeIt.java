package uppgift1;

public class TimeIt {

  public static long timeIt(Runnable code, int repetitions) {
    long start = System.nanoTime();

    for (int i = 0; i < repetitions; i++) {
      code.run();
    }

    long end = System.nanoTime();
    return (end - start) / repetitions; // return avg per time
  }

  public static void main(String[] args) {
    Runnable code = () -> {
      int sum = 0;
      for (int i = 0; i < 100; i++) {
        sum += i;
      }
    };

    long avg = timeIt(code, 10000);


    System.out.println("Average execution time: " + avg + " nanoseconds");
  }
}
