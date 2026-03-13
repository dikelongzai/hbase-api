package com.howard.leetcode;

import java.util.*;
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
     * “三数之和” (3Sum, LeetCode 15)。
     * <p>
     * 在标准的算法面试中，题目的输入通常是一个一维数组或列表（如 int[] 或 List<Integer>），而输出才是 List<List<Integer>>。如果你实际面对的是一个嵌套列表（二维列表）作为输入，你只需要先将它“展平 (Flatten)”成一维列表即可
     *
     * @param arrs
     * @return
     */
    public List<List<Integer>> getElementsSumZero(int[] arrs) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(arrs);
        for (int i = 0; i < arrs.length - 2; i++) {
            //当前数>0 后面不可能凑成0 直接结果
            if (arrs[i] > 0) break;
            if (i > 0 && arrs[i] == arrs[i - 1]) {
                continue;
            }
            int left = i + 1, right = arrs.length - 1;
            while (left < right) {
                int sum = arrs[i] + arrs[left] + arrs[right];
                if (sum == 0) {
                    list.add(Arrays.asList(arrs[i], arrs[left], arrs[right]));
                    while (arrs[left + 1] == arrs[left]) {
                        left++;
                    }
                    while (arrs[right - 1] == arrs[right]) {
                        right--;
                    }
                    // 指针继续往中间移动 (Move pointers inward)
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }

            }
        }
        return list;

    }

    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order.
     * <p>
     * Example:
     * <p>
     * Input: nums = [2,7,11,15], target = 9
     * <p>
     * Output: [0,1]
     * <p>
     * Explanation: nums[0] + nums[1] == 9, we return [0, 1].
     *
     * @param arrs
     * @param sumTarget
     * @return
     */
    public List<List<Integer>> getTwoSum(int[] arrs, int sumTarget) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(arrs);
        for (int i = 0; i < arrs.length - 1; i++) {
            if (arrs[i] > sumTarget) break;
            if (i > 0 && arrs[i] == arrs[i - 1]) continue;
            int right = arrs.length - 1;
            while (i < right) {
                int sumCurr = arrs[i] + arrs[right];
                if (sumCurr == sumTarget) {
                    list.add(Arrays.asList(arrs[i], arrs[right]));
                    break;
                } else if (sumCurr < sumTarget) {
                    break;
                } else if (sumCurr > sumTarget) {
                    right--;
                }
            }
        }
        return list;

    }

    /**
     * 复杂度: 时间复杂度为 $O(N \log N)$ (排序开销) + $O(N)$ (指针扫描)，整体 $O(N \log N)$。这是在给定数组未排序前提下的最优解。健壮性: 完美处理了重复元素（left++ 和 right-- 的 while 循环去重）。逻辑漏洞补救: 你添加了 if (arrs[left] > sumTarget) break;。这是一个非常好的优化，因为如果最小值都已经大于目标值，那么后续所有组合的和必然会更大，提前退出可以节省大量 CPU 时间。
     *
     * @param arrs
     * @param sumTarget
     * @return
     */
    public List<List<Integer>> getTwoSumV2(int[] arrs, int sumTarget) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(arrs);
        int left = 0, right = arrs.length - 1;
        while (left < right) {
            int sumCurr = arrs[left] + arrs[right];
            if (arrs[left] > sumTarget) break;
            if (sumCurr == sumTarget) {
                list.add(Arrays.asList(arrs[left], arrs[right]));
                while (left < right && arrs[left] == arrs[left + 1]) {
                    left++;
                }
                while (left < right && arrs[right] == arrs[right - 1]) {
                    right--;
                }
                left++;
                right--;
            } else if (sumCurr < sumTarget) {
                left++;
            } else {
                //sumCurr>sumTarget
                right--;
            }
        }
        return list;
    }

    public List<List<Integer>> getTwoSumV3HashMapVersion(int[] arrs, int sumTarget) {
        List<List<Integer>> list = new LinkedList<>();
        //Map 存储: <数值, 索引>
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arrs.length; i++) {
            int complement = sumTarget - arrs[i];
            if (map.containsKey(complement)) {
                list.add(Arrays.asList(arrs[i], complement));
            }
            map.put(arrs[i], i);
        }
        return list;
    }

    /**
     * 题目：Merge Intervals (合并区间)
     * 输入：[[1,3], [2,6], [8,10], [15,18]]
     * 思路提示：
     * <p>
     * 排序： 先按 startTime 对数组排序。
     * <p>
     * 合并： 创建一个 result 列表。遍历数组，如果当前区间的 start 小于等于上一个区间的 end，则说明有重叠，更新上一个区间的 end。
     *
     * @param arrs
     * @return
     */
    public List<List<Integer>> getMergeIntervalsV1False(int[][] arrs) {
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < arrs.length; i++) {
            int[] arrRow = arrs[i];
            Arrays.sort(arrRow);
            if (!stack.isEmpty()) {
                List<Integer> listPre = stack.peek();
                if (listPre.get(listPre.size() - 1) >= arrRow[0]) {
                    stack.pop();
                    stack.push(Arrays.asList(Math.min(listPre.get(0), arrRow[0]), Math.max(listPre.get(listPre.size() - 1), arrRow[arrRow.length - 1])));
                } else {
                    stack.push(Arrays.asList(arrRow[0], arrRow[arrRow.length - 1]));


                }
            } else {
                stack.push(Arrays.asList(arrRow[0], arrRow[arrRow.length - 1]));
            }


        }
        return stack;
    }

    /**
     * 漏洞 1：没有对 2D 数组进行全局排序 (The Fatal Flaw: Lack of Global Sorting)
     * 如果你不预先对整个 arrs 按起始时间排序，只对单个 arrRow 排序是没有用的。
     * <p>
     * 破坏性测试用例 (Destructive Test Case):
     * int[][] testMetrics = new int[][]{{15, 18}, {1, 3}};
     * <p>
     * 你的代码执行轨迹：
     * <p>
     * 栈压入 [15, 18]。
     * <p>
     * 下一个区间是 [1, 3]。
     * <p>
     * 你判断 listPre.end (18) > arrRow[0] (1)。结果为 True！
     * <p>
     * 执行合并：min(15, 1) 和 max(18, 3)。
     * <p>
     * 你的输出结果：[[1, 18]]
     * <p>
     * 现实中的正确结果： [[1, 3], [15, 18]]。因为 3 和 15 之间有巨大的断层，它们根本没有重叠，不应该被合并。你的代码错误地将它们吞并了。
     * <p>
     * 漏洞 2：临界点判断错误 (The Edge Case: Boundary Condition)
     * 边缘测试用例 (Edge Test Case):
     * int[][] testMetrics = new int[][]{{1, 4}, {4, 5}};
     * <p>
     * 你的代码执行轨迹：
     * <p>
     * 栈压入 [1, 4]。
     * <p>
     * 下一个区间是 [4, 5]。
     * <p>
     * 你判断 listPre.end (4) > arrRow[0] (4)。结果为 False！
     * <p>
     * 你的代码将 [4, 5] 单独压入栈。
     * <p>
     * 你的输出结果：[[1, 4], [4, 5]]
     * <p>
     * 现实中的正确结果： [[1, 5]]。因为它们在数字 4 处重叠，必须合并。你的判断条件应该是 >=（大于等于），而不是 >（严格大于）
     *
     * @param arrs
     * @return
     */
    public List<List<Integer>> getMergeIntervalsV2Fixed(int[][] arrs) {
//        if (arrs.length <= 1) return Arrays.asList(arrs);
        Stack<List<Integer>> stack = new Stack<>();
        Arrays.sort(arrs, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < arrs.length; i++) {
            int[] arrRow = arrs[i];
            // 注意：全局排序后，arrRow 本身无需再次排序
//            Arrays.sort(arrRow);
            if (!stack.isEmpty()) {
                List<Integer> listPre = stack.peek();
                if (listPre.get(listPre.size() - 1) >= arrRow[0]) {
                    stack.pop();
                    stack.push(Arrays.asList(Math.min(listPre.get(0), arrRow[0]), Math.max(listPre.get(listPre.size() - 1), arrRow[arrRow.length - 1])));
                } else {
                    stack.push(Arrays.asList(arrRow[0], arrRow[arrRow.length - 1]));


                }
            } else {
                stack.push(Arrays.asList(arrRow[0], arrRow[arrRow.length - 1]));
            }


        }
        return stack;
    }


    /**
     * 321 111->211->221-->321
     *
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
