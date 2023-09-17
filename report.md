# Report

## Union Find 

#### QuickFind union()
| Size  | Time (ms) |  Ratio | log2 Ratio |
|-------|-----------|------------|------------|
| 200   | 0.007246  | -          | -          |
| 400   | 0.025560  | 3.53       | 1.81       |
| 800   | 0.096352  | 3.77       | 1.91       |
| 1600  | 0.375885  | 3.90       | 1.96       |

#### QuickUnionPathCompression union()
| Size  | Time (ms) |  Ratio | log2 Ratio |
|-------|-----------|------------|------------|
| 200   | 0.000277  | -          | -          |
| 400   | 0.000238  | 0.86       | -0.22      |
| 800   | 0.000391  | 1.64       | 0.71       |
| 1600  | 0.000763  | 1.95       | 0.97       |


#### QuickFind connected()
| Size  | Time (ms) |  Ratio | log2 Ratio |
|-------|-----------|------------|------------|
| 200   | 0.000186  | -          | -          |
| 400   | 0.000149  | 0.80       | -0.32      |
| 800   | 0.000276  | 1.85       | 0.88       |
| 1600  | 0.000510  | 1.85       | 0.88       |

#### QuickUnionPathCompression connected()
| Size  | Time (ms) |  Ratio | log2 Ratio |
|-------|-----------|------------|------------|
| 200   | 0.000277  | -          | -          |
| 400   | 0.000238  | 0.86       | -0.22      |
| 800   | 0.000391  | 1.64       | 0.71       |
| 1600  | 0.000763  | 1.95       | 0.97       |


## Three Sum
### Brute Force
| Size  | Time (ms) | Ratio  | log2 Ratio |
|-------|-----------|--------|------------|
| 200   | 0.32      | -      | -          |
| 400   | 2.49      | 7.78   | 2.96       |
| 800   | 19.62     | 7.88   | 2.978      |
| 1600  | 148.79    | 7.584  | 2.923      |


### Cache
| Size  | Time (ms) | Ratio  | log2 Ratio |
|-------|-----------|--------|------------|
| 200   | 0.27      | -      | -          |
| 400   | 1.33      | 4.93   | 2.300      |
| 800   | 6.50      | 4.887  | 2.289      |
| 1600  | 27.75     | 4.269  | 2.094      |

## Union Find

* QuickFind union(): In the QuickFind method, as we doubled the input size, the time taken for the union operation increased notably. This growth pattern is in line with its O(n) time complexity.
* QuickUnionPathCompression union(): For the QuickUnionPathCompression method, the time taken for the union operation also increased when the size doubled. However, this increase was less pronounced than in QuickFind. This more gradual increase is consistent with its O(log n) time complexity.
* QuickFind connected(): The time taken for the connected operation in QuickFind remained relatively constant across different sizes, which is characteristic of its O(1) time complexity.
* QuickUnionPathCompression connected(): In the QuickUnionPathCompression method, the time for the connected operation saw a slight increase as the size doubled, reflecting its O(log n) time complexity.


## Three Sum:
* Brute Force: The time taken by the Brute Force method for ThreeSum increased almost eightfold as the size doubled. This behavior is consistent with the expected cubic time complexity of O(n^3) for the brute force approach.
* Cache: The time taken by the Cache method for ThreeSum increased approximately fivefold as the size doubled. This suggests a quadratic growth rate, which is consistent with the expected time complexity of O(n^2) for the cache approach.
