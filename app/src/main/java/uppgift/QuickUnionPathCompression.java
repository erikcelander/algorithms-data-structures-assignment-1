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

      // after compressing the path for 'i', we then set 'i' to its parent (or previously grandparent)
      // which helps us traverse up the tree to find the root
      i = data[i];
    }

    // once the while loop is finished, 'i' will be the root of the original element
    // that we used as an argument for this method call, which is then returned
    return i;
  }

  public void union(int a, int b) {
    // store value of index 'b' of the 'data' array in variable 'a_id'
    int a_id = data[a];

    // store value of index 'b' of the 'data' array in variable 'b_id'
    int b_id = data[b];

    // loop through 'data' and find all elements belonging to the same group as 'a'
    for (int i = 0; i < data.length; i++) {

      // if value of data[i] is equal to 'a_id', data[i] belongs to the same group as 'a'
      if (data[i] == a_id) {

        // update group of data[i] to 'b_id'
        data[i] = b_id;
      }
    }

    // after every element has been iterated through, all elements of group 'a' will
    // now belong to group 'b'
  }

  public boolean connected(int a, int b) {
    // returns true if two elements belongs to the same group i.e they're connected
    // and false if they're not connected
    return root(a) == root(b);
  }

  public static void main(String[] args) {
    QuickFind qf = new QuickFind(8);

    qf.union(0, 1);
    qf.union(1, 2);
    qf.union(3, 4);
    qf.union(4, 5);
    qf.union(6, 7);

    System.out.println(qf.connected(0, 2));
    System.out.println(qf.connected(0, 7));
  }

}
