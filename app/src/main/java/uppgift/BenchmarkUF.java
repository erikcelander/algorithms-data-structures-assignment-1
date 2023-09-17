package uppgift;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.concurrent.Callable;

public class BenchmarkUF {

  private static final int[] sizes = { 200, 400, 800, 1600 };
  private static final int iterations = 7;
  private static final int repetitions = 10000;
  private static final DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
  private static final DecimalFormat df = new DecimalFormat("0.000000", symbols);
  

  public static void main(String[] args) throws Exception {

    for (int size : sizes) {

      int unions = size / 2;
      int finds = size / 2;

      long totalQuickFindUnionTime = 0;
      long totalQuickFindConnectedTime = 0;
      long totalQUPCUnionTime = 0;
      long totalQUPCConnectedTime = 0;

      for (int iteration = 0; iteration < iterations; iteration++) {

        // QuickFind Union Timing
        Callable<Void> quickFindUnionCode = () -> {
          QuickFind qf = new QuickFind(size);
          for (int i = 0; i < unions; i++) {
            qf.union(i, i + 1);
          }
          return null;
        };
        TimeIt.TimingResult quickFindUnionResult = TimeIt.timeIt(quickFindUnionCode, repetitions);
        totalQuickFindUnionTime += quickFindUnionResult.avg;

        // QuickFind Connected Timing
        Callable<Void> quickFindConnectedCode = () -> {
          QuickFind qf = new QuickFind(size);
          for (int i = 0; i < finds; i++) {
            qf.connected(i, i + 1);
          }
          return null;
        };
        TimeIt.TimingResult quickFindConnectedResult = TimeIt.timeIt(quickFindConnectedCode, repetitions);
        totalQuickFindConnectedTime += quickFindConnectedResult.avg;


        // QuickUnionPathCompression Union Timing
        Callable<Void> qupcUnionCode = () -> {
          QuickUnionPathCompression qupc = new QuickUnionPathCompression(size);
          for (int i = 0; i < unions; i++) {
            qupc.union(i, i + 1);
          }
          return null;
        };
        TimeIt.TimingResult qupcUnionResult = TimeIt.timeIt(qupcUnionCode, repetitions);
        totalQUPCUnionTime += qupcUnionResult.avg;

        // QuickUnionPathCompression Connected Timing
        Callable<Void> qupcConnectedCode = () -> {
          QuickUnionPathCompression qupc = new QuickUnionPathCompression(size);
          for (int i = 0; i < finds; i++) {
            qupc.connected(i, i + 1);
          }
          return null;
        };
        TimeIt.TimingResult qupcConnectedResult = TimeIt.timeIt(qupcConnectedCode, repetitions);
        totalQUPCConnectedTime += qupcConnectedResult.avg;
      }

      long averageQuickFindUnionTime = totalQuickFindUnionTime / iterations;
      long averageQuickFindConnectedTime = totalQuickFindConnectedTime / iterations;
      long averageQUPCUnionTime = totalQUPCUnionTime / iterations;
      long averageQUPCConnectedTime = totalQUPCConnectedTime / iterations;

      System.out.println("Size: " + size + ", Unions: " + unions + ", Finds: " + finds);
      System.out.println("QuickFind Union Average Time: " + df.format(averageQuickFindUnionTime / 1_000_000.0) + " ms");
      System.out.println("QuickFind Connected Average Time: " + df.format(averageQuickFindConnectedTime / 1_000_000.0) + " ms");
      System.out.println("QuickUnionPathCompression Union Average Time: " + df.format(averageQUPCUnionTime / 1_000_000.0) + " ms");
      System.out.println("QuickUnionPathCompression Connected Average Time: " + df.format(averageQUPCConnectedTime / 1_000_000.0) + " ms");
      
      System.out.println("-------------------------------------------------");
    }
  }
}
