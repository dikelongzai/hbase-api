package com.howard.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class LeetCode {
    private static final Logger logger = LoggerFactory.getLogger(LeetCode.class);
    private LeetCode() {
    }

    /**
     * LetCode  https://leetcode.com/problems/first-missing-positive/}
     * Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
     * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
     *
     * @param numberArray
     * @return
     */
    public int getFirstMissing(int[] numberArray) {
        Preconditions.checkArrayNotEmpty("the input array should not be null", numberArray);
        int firstMessingNumber = 1;
        Arrays.sort(numberArray);

        if (numberArray.length == 1) {
            if (numberArray[0] == 1) firstMessingNumber = 2;
//            firstMessingNumber= numberArray[0]!=1?1:2;
        } else {
            if (numberArray[0] > 1) {
                return firstMessingNumber;
            } else {
                int lastValue = numberArray[0];
                for (int i = 1; i < numberArray[numberArray.length - 1]; i++) {
                    //prevent array out of  boundaries
                    if (i <= numberArray.length - 1) {
                        // when the current number<0 go on else go on
                        if (numberArray[i] > 1) {
                            if (numberArray[i] - lastValue > 1) {
                                firstMessingNumber = lastValue + 1;
                                return firstMessingNumber;
                            }
                        }
                    } else {

                    }

                    lastValue = numberArray[i];
                }
                firstMessingNumber = numberArray[numberArray.length - 1] + 1;
            }


        }

        return firstMessingNumber;

    }

    /**
     * Given an integer array nums where the elements are sorted in ascending order, convert it to a
     * height-balanced
     *  binary search tree.
     *LetCode  https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
     *
     *
     * Example 1:
     *
     *
     * Input: nums = [-10,-3,0,5,9]
     * Output: [0,-3,9,-10,null,5]
     * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
     *
     * Example 2:
     *
     *
     * Input: nums = [1,3]
     * Output: [3,1]
     * Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
     * Constraints:
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums is sorted in a strictly increasing order.
     * @param nums
     * @return
     */

    public BinaryTreeNode sortedArrayToBST(int[] nums) {
        Preconditions.checkArrayNotEmpty("the input array should not be null", nums);
        int n = nums.length;
        if (n == 0) return null;
        int end = nums.length - 1;
        BinaryTreeNode binaryTreeNode=TreeNodeHelper.helps(nums, 0, end);
        return binaryTreeNode;
    }


    private static class LeetCodeQustionInstance {
        private static final LeetCode INSTANCE = new LeetCode();

    }

    private enum LeetCodeInstance {
        INSTANCE;
    }

    public static LeetCode getLeetCodeInstance() {
        return LeetCodeQustionInstance.INSTANCE;
    }


}
