package uppgift;

public class QuickFind {
  private int[] data;

  public QuickFind(int N) {
    this.data = new int[N];
    for (int i = 0; i < N; i++) {
      data[i] = i;
    }
  }

  public void union() {
    
  }

  public boolean connected(int a, int b) {
    return data[a] == data[b];
  }


}