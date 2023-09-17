package uppgift;

public class Application {

  public static void main(String[] args) {
    try {
      System.out.println("-------------------------------------------------");
      System.out.println("Union Find");
      System.out.println("-------------------------------------------------");
      BenchmarkUF.run();

      System.out.println("");

      System.out.println("-------------------------------------------------");
      System.out.println("Three Sum");
      System.out.println("-------------------------------------------------");
      BenchmarkThreeSum.run();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
