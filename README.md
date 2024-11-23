This is a simple imperative program which calculates highly precise square roots.

The algorithm is based on binary search when searching for the nearest integer root,
then deriving high precision approximations by using Newton's method repeatedly.

The algorithm runs in O(log(n) + m):
  - n - the steps it takes to run the binary search
  - m - the iterations of repeatedly applying Newton's method

The program also works for complex roots.
