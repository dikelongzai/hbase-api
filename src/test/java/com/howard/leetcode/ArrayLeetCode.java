package com.howard.leetcode;

import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class ArrayLeetCode {
    private ArrayLeetCode() {

    }

    /**
     * @param matrix
     * @return
     * @link <a href="https://leetcode.com/problems/maximal-rectangle/description/"></a>
     * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
     * Output: 6
     * Explanation: The maximal rectangle is shown in the above picture.
     * Example 2:
     * <p>
     * Input: matrix = [["0"]]
     * Output: 0
     * Example 3:
     * <p>
     * Input: matrix = [["1"]]
     * Output: 1
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxArea = 0;
        // Include an extra element for easier calculation
        int[] heights = new int[cols + 1];
        for (char[] rowArr : matrix) {
            for (int i = 0; i < cols; i++) {
                heights[i] = (rowArr[i] == '1') ? heights[i] + 1 : 0;
            }
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < heights.length; i++) {
                //peek-Looks at the object at the top of this stack without removing it from the stack.
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    //Removes the object at the top of this stack
                    int height = heights[stack.pop()];
                    int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, height * width);
                }
                stack.push(i);

            }

        }
        return maxArea;

    }

    /**
     * @param nums1
     * @param nums2
     * @return
     * @link <a helf="https://leetcode.com/problems/median-of-two-sorted-arrays/"></a>
     * @link <a helf="https://www.cnblogs.com/lonely-wolf/p/15674526.html/" >时间复杂度</a>
     * <p>
     * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
     * <p>
     * The overall run time complexity should be O(log (m+n)).
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums1 = [1,3], nums2 = [2]
     * Output: 2.00000
     * Explanation: merged array = [1,2,3] and median is 2.
     * Example 2:
     * <p>
     * Input: nums1 = [1,2], nums2 = [3,4]
     * Output: 2.50000
     * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * nums1.length == m
     * nums2.length == n
     * 0 <= m <= 1000
     * 0 <= n <= 1000
     * 1 <= m + n <= 2000
     * -106 <= nums1[i], nums2[i] <= 106
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sortArrLength = nums1.length + nums2.length;
        int[] sortArr = new int[sortArrLength];
        AtomicInteger index = new AtomicInteger(0);
        Arrays.stream(nums1).forEach(num -> {
            sortArr[index.getAndIncrement()] = num;
        });
        Arrays.stream(nums2).forEach(num -> {
            sortArr[index.getAndIncrement()] = num;
        });
        //This algorithm offers O(n log(n)) performance
        Arrays.sort(sortArr);
        if (sortArrLength % 2 == 1) {
            return sortArr[sortArrLength / 2];
        } else {
            return (double) (sortArr[sortArrLength / 2 - 1] + sortArr[sortArrLength / 2]) / 2;
        }


    }

    /**
     * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
     * <p>
     * You are giving candies to these children subjected to the following requirements:
     * <p>
     * Each child must have at least one candy.
     * Children with a higher rating get more candies than their neighbors.
     * Return the minimum number of candies you need to have to distribute the candies to the children.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: ratings = [1,0,2]
     * Output: 5
     * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
     * Example 2:
     * <p>
     * Input: ratings = [1,2,2]
     * Output: 4
     * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
     * The third child gets 1 candy because it satisfies the above two conditions.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * n == ratings.length
     * 1 <= n <= 2 * 104
     * 0 <= ratings[i] <= 2 * 104
     *
     * @param ratingArr
     * @return
     * @link <a helf="https://leetcode.com/problems/candy/description/"></a>
     */
    public int distributeMinCandy(int[] ratingArr) {
        Preconditions.checkArrayNotEmpty("ratingArr can not be null", ratingArr);
        int[] candyArr = new int[ratingArr.length];
        Arrays.fill(candyArr, 1);
        for (int i = 1; i < ratingArr.length; i++) {
            if (ratingArr[i] > ratingArr[i - 1] && candyArr[i] <= candyArr[i - 1]) {
                candyArr[i] = candyArr[i - 1] + 1;
            } else if (ratingArr[i] < ratingArr[i - 1]) {
                dealWithRating(i, ratingArr, candyArr);
            } else {
                //do nothing in accordance with the given rules
            }
        }
        return Arrays.stream(candyArr).sum();
    }

    /**
     * 321 111->211->221-->321
     * @param indexRating
     * @param ratingArr
     * @param distributeArr
     */
    private void dealWithRating(int indexRating, int[] ratingArr, int[] distributeArr) {
        if (ratingArr[indexRating] < ratingArr[indexRating - 1] && distributeArr[indexRating] >= distributeArr[indexRating - 1]) {
            distributeArr[indexRating - 1]++;
            if (indexRating > 1) {
                dealWithRating(indexRating - 1, ratingArr, distributeArr);
            }
        }


    }

    public int maxSubArray(int[] inputArr) {
        Preconditions.checkArrayNotEmpty("inputArr can not be null", inputArr);
        int sumMaxSubArray = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int currentNum : inputArr) {
            sumMaxSubArray += currentNum;
            maxSum = Math.max(maxSum, sumMaxSubArray);
            if (sumMaxSubArray < 0) sumMaxSubArray = 0;
        }

        return sumMaxSubArray;
    }

    public static class ArrayLeetCodeInstance {
        private static final ArrayLeetCode ARRAY_LEET_CODE = new ArrayLeetCode();

        public static ArrayLeetCode getArrayLeetCodeInstance() {
            return ARRAY_LEET_CODE;
        }
    }

}
