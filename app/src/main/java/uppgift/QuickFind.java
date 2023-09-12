package uppgift;

public class QuickFind {
  private int[] data;

  public QuickFind(int N) {
    this.data = new int[N];
    for (int i = 0; i < N; i++) {
      data[i] = i;
    }
  }

  public void union(int a, int b) {
    // store value of index 'b' of the 'data' array in variable 'a_id'
    int a_id = data[a];
    
    // store value of index 'b' of the 'data' array in variable 'b_id'
    int b_id = data[b];

    // loop through 'data' and find all elements belonging to the same group as 'a'
    for (int i = 0; i < data.length; i++) {

    // if value of data[i] is equal to 'a_id', data[i] belongs to the same group as A
      if (data[i] == a_id) {

        // update group of data[i] to 'b_id'
        data[i] = b_id;
      }
    }

    // after every element has been iterated through, all elements of group 'a' will now belong to group 'b'
  }

  public boolean connected(int a, int b) {
    // returns true if two elements belongs to the same group i.e connected and false if they're not connected
    return data[a] == data[b];
  }

}
