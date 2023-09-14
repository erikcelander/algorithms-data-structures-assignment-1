package uppgift;

public class QuickUnionPathCompression {
  private int[] data;

  public QuickUnionPathCompression(int N) {
    this.data = new int[N];
    for (int i = 0; i < N; i++) {
      data[i] = i;
    }
  }

  private int root(int i) {
    // loop will run as long as 'i' doesn't point to itself, which if it did, means
    // it's the root of its group.
    while (i != data[i]) {

      // when we find an element that isn't the root of its group
      // we set data[i] to point to its grandparent, so that the next
      // time we try to find the root of 'i', it's faster,
      // i.e we have compressed the path
      data[i] = data[data[i]];

      // after compressing the path for 'i', we then set 'i' to its parent (or
      // previously grandparent)
      // which helps us traverse up the tree to find the root
      i = data[i];
    }

    // once the while loop is finished, 'i' will be the root of the original element
    // that we used as an argument for this method call, which is then returned
    return i;
  }

  public void union(int a, int b) {

    // find root of element 'a'
    int rootA = root(a);

    // find root of element 'b'
    int rootB = root(b);

    // if they do not belong to the same group
    if (rootA != rootB) {
      // then we set the root of 'a' to the root of 'b', i.e merging the two groups
      data[rootA] = rootB;
    }
  }

  public boolean connected(int a, int b) {
    // returns true if two elements belongs to the same group i.e they're connected
    // and false if they're not connected
    return root(a) == root(b);
  }

  public static void main(String[] args) {
    QuickUnionPathCompression qu = new QuickUnionPathCompression(8);

    qu.union(0, 1);
    qu.union(1, 2);
    qu.union(3, 4);
    qu.union(4, 5);
    qu.union(6, 7);

    System.out.println(qu.connected(0, 2));
    System.out.println(qu.connected(0, 7));
  }

}
