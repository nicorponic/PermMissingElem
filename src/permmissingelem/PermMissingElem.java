/*
A zero-indexed array A consisting of N different integers is given. The array 
contains integers in the range [1..(N + 1)], which means that exactly one 
element is missing.

Your goal is to find that missing element.

Write a function:

class Solution { public int solution(int[] A); }
that, given a zero-indexed array A, returns the value of the missing element.

For example, given array A such that:

  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
the function should return 4, as it is the missing element.

Assume that:

N is an integer within the range [0..100,000];
the elements of A are all distinct;
each element of array A is an integer within the range [1..(N + 1)].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1), beyond input storage (not 
counting the storage required for input arguments).
Elements of input arrays can be modified.
Copyright 2009–2016 by Codility Limited. 
All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
package permmissingelem;

import java.util.stream.IntStream;

public class PermMissingElem {

    public static void main(String[] args) {
        int A[] = {2, 1, 3, 5};

        long N = A.length + 1;
        //This problem has a mathematical solution, based on the fact that 
        //the sum of consecutive integers from 1 to n is equal to n(n+1)/2
        long total = N * (N + 1) / 2;

        for (int i : A) {

            total -= i;
        }

        System.out.println((int) total);
    }

    public int solution1(int[] data) {

        long N = data.length + 1;
        long total = (N * (N + 1)) / 2;

        long sum = 0L;

        for (int i : data) {

            sum += i;
        }

        return (int) (total - sum);
    }

    public int solution2(int[] A) {
        long N = A.length + 1;
        return (int) (((N * (N + 1)) / 2) - IntStream.of(A).sum());
    }
}
