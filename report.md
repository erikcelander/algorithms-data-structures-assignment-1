# Report

## Union Find 

#### QuickFind union()
| Size  | Time (ms) |  Ratio | log2 Ratio |
|-------|-----------|--------|------------|
| 200   | 0.008652  | -      | -          |
| 400   | 0.027329  | 3.1587 | 1.6593     |
| 800   | 0.101684  | 3.7207 | 1.8956     |
| 1600  | 0.394157  | 3.8763 | 1.9547     |

#### QuickUnionPathCompression union()
| Size  | Time (ms) |  Ratio | log2 Ratio |
|-------|-----------|--------|------------|
| 200   | 0.000604  | -      | -          |
| 400   | 0.000513  | 0.8493 | -0.2356    |
| 800   | 0.000644  | 1.2554 | 0.3281     |
| 1600  | 0.001259  | 1.9550 | 0.9671     |

#### QuickFind connected()
| Size  | Time (ms) |  Ratio | log2 Ratio |
|-------|-----------|--------|------------|
| 200   | 0.000591  | -      | -          |
| 400   | 0.000434  | 0.7343 | -0.4455    |
| 800   | 0.000514  | 1.1843 | 0.2441     |
| 1600  | 0.000892  | 1.7354 | 0.7953     |

#### QuickUnionPathCompression connected()
| Size  | Time (ms) |  Ratio | log2 Ratio |
|-------|-----------|--------|------------|
| 200   | 0.000527  | -      | -          |
| 400   | 0.000523  | 0.9924 | -0.0110    |
| 800   | 0.000578  | 1.1052 | 0.1443     |
| 1600  | 0.000966  | 1.6713 | 0.7410     |

### QuickFind Algorithm:

**constructor**: Initializes an array of size N with values from 0 to N-1. This operation takes O(N) time.

**union(a, b)**: This operation merges the groups of elements a and b. It iterates through the entire array to update the group values, taking O(N) time.

**connected(a, b)**: Checks if two elements are in the same group. This is a constant-time operation, O(1), as it involves direct array access.

### QuickUnionPathCompression Algorithm:

**constructor**: Similar to QuickFind, it initializes an array of size N with values from 0 to N−1. This operation takes O(N) time.

**root(i)**: Finds the root of an element while compressing the path. Due to path compression, the tree height is logarithmic, making this operation O(log N) time.

**union(a, b)**: Merges the groups of elements a and b by linking their roots. This operation takes O(log N) time as it involves finding the roots.

**connected(a, b)**: Checks if two elements are in the same group by comparing their roots. This operation takes O(log N) time.

The empirical data gives insights into the actual performance of the algorithms for different input sizes. By analyzing the growth rate, we can infer the behavior of the algorithms as the input size increases. 

### QuickFind:

**Union**:
The union operation of QuickFind shows a growth rate that is approximately quadratic. This is evident from the log2 ratio values which are close to 2. This matches our theoretical analysis where the union operation is O(N). 

**Connected**:
The connected operation remains constant across different input sizes, which is consistent with its O(1) time complexity.

### QuickUnionPathCompression:

**Union**:
Both the union and connected operations of QuickUnionPathCompression exhibit logarithmic growth, as indicated by the log2 ratio values being less than 1. This is in line with our theoretical analysis where both operations are O(log N) due to path compression.

**Connected**:
Similarly, the connected operation also shows a logarithmic growth rate, consistent with its O(log N) time complexity due to path compression.

### Comparative analysis:
When comparing the two algorithms, QuickUnionPathCompression consistently outperforms QuickFind. This is evident both theoretically, where QuickUnionPathCompression has a better time complexity, and empirically, where it executes faster for the same input sizes.

QuickFind union(): The growth rate is O(N^2) as indicated by the log2 ratio.
QuickUnionPathCompression union(): The growth rate is O(log N).
QuickFind connected(): The growth rate is O(N).
QuickUnionPathCompression connected(): The growth rate is O(log N).

For small inputs, the difference might not be very noticeable, but as the input size grows, the efficiency of QuickUnionPathCompression becomes more pronounced. This is especially true for the union operation, where QuickFind's time increases quadratically, while QuickUnionPathCompression's time increases logarithmically.

## Three Sum

### Brute Force
| Size  | Time (ms) | Ratio  | log2 Ratio |
|-------|-----------|--------|------------|
| 200   | 0.32      | -      | -          |
| 400   | 2.49      | 7.78   | 2.96       |
| 800   | 19.62     | 7.88   | 2.978      |
| 1600  | 148.79    | 7.584  | 2.923      |

ThreeSumBruteForce Algorithm: The time complexity of this method is O(N^3) due to the three nested loops. This cubic complexity implies that as the input size grows, the execution time will increase at a cubic rate.

Observing the data, as the input size doubles from 400 to 800, the execution time multiplies by approximately 7.88. Similarly, from 800 to 1600, it multiplies by around 7.584. The log2 ratio values, being close to 3, further corroborate the cubic growth rate. This empirical observation aligns well with my expectation of O(N^3) time complexity.

### Cache
| Size  | Time (ms) | Ratio  | log2 Ratio |
|-------|-----------|--------|------------|
| 200   | 0.27      | -      | -          |
| 400   | 1.33      | 4.93   | 2.300      |
| 800   | 6.50      | 4.887  | 2.289      |
| 1600  | 27.75     | 4.269  | 2.094      |

ThreeSumCache Algorithm: The dominant factors determining the time complexity are the sorting operation, O(NlogN), and the two nested loops, O(N^2). Given that O(N^2) is the higher order term, the overall complexity is O(N^2).

For the input size growth from 400 to 800, the execution time multiplies by roughly 4.887. From 800 to 1600, it multiplies by about 4.269. The log2 ratio values hover around 2, indicating a quadratic growth rate. This empirical observation is consistent with the expected O(N^2) time complexity.

### Comparative analysis:
The ThreeSumBruteForce algorithm, characterized by its three nested loops, exhibits a cubic time complexity of O(N^3). In practice, as the input size doubles, its execution time multiplies by values close to 8, reinforcing this cubic growth. On the other hand, the ThreeSumCache algorithm, which employs a combination of sorting and caching, operates at a quadratic time complexity of O(N^2). Empirical data supports this, showing that its execution time multiplies by values around 4 to 5 as input size doubles. In conclusion, ThreeSumCache demonstrates superior efficiency and scalability compared to ThreeSumBruteForce, making it a more optimal choice for larger datasets.
