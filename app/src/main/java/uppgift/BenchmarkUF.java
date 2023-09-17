package uppgift;

import java.util.concurrent.Callable;

public class BenchmarkUF {

    private static final int[] sizes = {200, 400, 800, 1600};
    private static final int iterations = 7;
    private static final int repetitions = 1337;

    public static void main(String[] args) throws Exception {

        for (int size : sizes) {

            int unions = size / 2;
            int finds = size / 2;

            long totalQuickFindTime = 0;
            long totalQUPCTime = 0;

            for (int iteration = 0; iteration < iterations; iteration++) {

                // Benchmarking QuickFind
                Callable<Void> quickFindCode = () -> {
                    QuickFind qf = new QuickFind(size);
                      for (int i = 0; i < unions; i++) {
                        qf.union(i, i + 1);
                    }
                    for (int i = 0; i < finds; i++) {
                        qf.connected(i, i + 1);
                    }
                    return null;
                };
                TimeIt.TimingResult quickFindResult = TimeIt.timeIt(quickFindCode, repetitions);
                totalQuickFindTime += quickFindResult.avg;

                // Benchmarking QuickUnionPathCompression
                Callable<Void> qupcCode = () -> {
                    QuickUnionPathCompression qupc = new QuickUnionPathCompression(size);
                    for (int i = 0; i < unions; i++) {
                        qupc.union(i, i + 1);
                    }
                    for (int i = 0; i < finds; i++) {
                        qupc.connected(i, i + 1);
                    }
                    return null;
                };
                TimeIt.TimingResult qupcResult = TimeIt.timeIt(qupcCode, repetitions);
                totalQUPCTime += qupcResult.avg;
            }

            long averageQuickFindTime = totalQuickFindTime / iterations;
            long averageQUPCTime = totalQUPCTime / iterations;

            System.out.println("Size: " + size + ", Unions: " + unions + ", Finds: " + finds);
            System.out.println("QuickFind Average Time: " + averageQuickFindTime + " ns");
            System.out.println("QuickUnionPathCompression Average Time: " + averageQUPCTime + " ns");
            System.out.println("-------------------------------------------------");
        }
    }
}
