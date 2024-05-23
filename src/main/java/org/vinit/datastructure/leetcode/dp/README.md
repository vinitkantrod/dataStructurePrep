### Dynamic Programming

Two Approach:
1. Top-down also known as Memoization.
2. Botton-up also known as Tabulation.

Botton-up starts with the base case
Top-down is implemented with recursion

#### Which is better?

1. Any DP algorithm can be implemented with either method, and there are reasons for choosing either over the other. However, each method has one main advantage that stands out:
2. A bottom-up implementation's runtime is usually faster, as iteration does not have the overhead that recursion does.
3. A top-down implementation is usually much easier to write. This is because with recursion, the ordering of subproblems does not matter, whereas with tabulation, we need to go through a logical ordering of solving subproblems.