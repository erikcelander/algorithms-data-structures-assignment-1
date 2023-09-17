package uppgift;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

import uppgift.TimeIt.TimingResult;

public class Application {

  public static void main(String[] args) {
    try {

      BenchmarkThreeSum threeSum = new BenchmarkThreeSum();
      BenchmarkUF unionFind = new BenchmarkUF();

      threeSum.main(args);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
