package com.howard.leetcode.test;

import com.howard.leetcode.*;
import com.howard.leetcode.calculate.Calculate;
import com.howard.leetcode.calculate.bistack.BiStackCalculate;
import com.howard.util.LRUCache;
import com.howard.util.LRUCacheDoubleLink;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class LeetCodeTest {
    private static final Logger logger = LoggerFactory.getLogger(LeetCodeTest.class);

    @Test
    public void testLeetCodeTree() {
        int[] testArray1 = new int[]{3, 4, -1, 1};
        int[] testArray2 = new int[]{7, 8, 9, 11, 12};
        int[] testArray3 = new int[]{1, 2, 0};
        int[] testArray4 = new int[]{1};
        int[] testArray5 = new int[]{-3, 9, 16, 4, 5, 16, -4, 9, 26, 2, 1, 19, -1, 25, 7, 22, 2, -7, 14, 2, 5, -6, 1, 17, 3, 24, -4, 17, 15};
        int[] testArray6 = new int[]{1, 2, 2};
        int[] testArray7 = new int[]{1, 3, 5, 0};
        int[] testArray8 = new int[]{2, 2};
        Assert.assertEquals(LeetCode.getLeetCodeInstance().getFirstMissing(testArray1), 2);
        Assert.assertEquals(LeetCode.getLeetCodeInstance().getFirstMissing(testArray2), 1);
        Assert.assertEquals(LeetCode.getLeetCodeInstance().getFirstMissing(testArray3), 3);
        Assert.assertEquals(LeetCode.getLeetCodeInstance().getFirstMissing(testArray4), 2);
        Assert.assertEquals(LeetCode.getLeetCodeInstance().getFirstMissing(testArray5), 6);
        Assert.assertEquals(LeetCode.getLeetCodeInstance().getFirstMissing(testArray6), 3);
        Assert.assertEquals(LeetCode.getLeetCodeInstance().getFirstMissing(testArray7), 2);
        Assert.assertEquals(LeetCode.getLeetCodeInstance().getFirstMissing(testArray8), 1);
        //test108
        int[] test108InputArr1 = new int[]{-10, -3, 0, 5, 9};
        int[] test108InputArr2 = new int[]{1, 3};
        BinaryTreeNode binaryTreeNode = LeetCode.getLeetCodeInstance().sortedArrayToBST(test108InputArr1);
        LinkedList treeSet = new LinkedList<>();
        logger.info("levelOrder" + TreeNodeHelper.levelOrder(binaryTreeNode, true).toString());
        ;
        logger.info("preOrder" + String.valueOf(TreeNodeHelper.preOrder(binaryTreeNode, treeSet)));
        treeSet = new LinkedList<>();
        logger.info("inOrder" + String.valueOf(TreeNodeHelper.inOrder(binaryTreeNode, treeSet)));
        treeSet = new LinkedList<>();
        logger.info("postOrder" + String.valueOf(TreeNodeHelper.postOrder(binaryTreeNode, treeSet)));
        LeetCode.getLeetCodeInstance().sortedArrayToBST(test108InputArr2);

        String[] testMinimumDepth = new String[]{"3", "9", "20", null, null, "15", "7"};
        binaryTreeNode = TreeNodeHelper.buildBinaryTree(testMinimumDepth);
        Assert.assertEquals(TreeNodeHelper.minDepth(binaryTreeNode), 2);
        logger.info("levelOrder" + TreeNodeHelper.levelOrder(binaryTreeNode, true).toString());
        ;
        String[] testMinimumDepth2 = new String[]{"2", null, "3", null, "4", null, "5", null, "6"};
        binaryTreeNode = TreeNodeHelper.buildBinaryTree(testMinimumDepth2);
        Assert.assertEquals(TreeNodeHelper.minDepth(binaryTreeNode), 5);
        logger.info("levelOrder" + TreeNodeHelper.levelOrder(binaryTreeNode, true).toString());
        ;

    }

    @Test
    public void testStringLeetCode() {
        /*  https://leetcode.com/problems/minimum-window-substring/description/**/
        StringLeetCode stringLeetCode = StringLeetCode.StringLeetCodeInstance.getStringLeetCodeInstance();
        String beSubstring1 = "ADOBECODEBANC";
        String windowStr1 = "ABC";
        String beSubstring2 = "a";
        String windowStr2 = "a";
        String beSubstring3 = "a";
        String windowStr3 = "aa";

        Assert.assertEquals(StringLeetCode.StringLeetCodeInstance.getStringLeetCodeInstance().bestSolutionWindowSubstr(beSubstring1, windowStr1), "BANC");
        Assert.assertEquals(StringLeetCode.StringLeetCodeInstance.getStringLeetCodeInstance().bestSolutionWindowSubstr(beSubstring3, windowStr3), "");
        Assert.assertEquals(StringLeetCode.StringLeetCodeInstance.getStringLeetCodeInstance().bestSolutionWindowSubstr(beSubstring2, windowStr2), "a");
        /*  https://leetcode.com/problems/text-justification/description//
         */
//        logger.info("preOrder"+String.valueOf(StringLeetCode.StringLeetCodeInstance.getStringLeetCodeInstance().minWindowSubstr("ADOBECODEBANC","ABC")));
        String[] words1 = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        String[] words2 = new String[]{"What", "must", "be", "acknowledgment", "shall", "be"};
        String[] words3 = new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        String[] words4 = new String[]{"ask", "not", "what", "your", "country", "can", "do", "for", "you", "ask", "what", "you", "can", "do", "for", "your", "country"};
        String[] words5 = new String[]{"Listen", "to", "many,", "speak", "to", "a", "few."};
        logger.info("text-justification words1 result:" + String.valueOf(StringLeetCode.StringLeetCodeInstance.getStringLeetCodeInstance().fullJustify(words1, 16)));
        logger.info("text-justification words2 result:" + String.valueOf(StringLeetCode.StringLeetCodeInstance.getStringLeetCodeInstance().fullJustify(words2, 16)));
        logger.info("text-justification words3 result:" + String.valueOf(StringLeetCode.StringLeetCodeInstance.getStringLeetCodeInstance().fullJustify(words3, 20)));
        logger.info("text-justification words4 result:" + String.valueOf(StringLeetCode.StringLeetCodeInstance.getStringLeetCodeInstance().fullJustify(words4, 16)));
        logger.info("text-justification words5 result:" + String.valueOf(StringLeetCode.StringLeetCodeInstance.getStringLeetCodeInstance().fullJustify(words5, 6)));
        /** {@link <a helf="https://leetcode.com/problems/wildcard-matching/"></a>}*/
        Assert.assertEquals(StringLeetCode.StringLeetCodeInstance.getStringLeetCodeInstance().isMatch("aa", "a"), false);
        Assert.assertEquals(StringLeetCode.StringLeetCodeInstance.getStringLeetCodeInstance().isMatch("aa", "*"), true);
        Assert.assertEquals(StringLeetCode.StringLeetCodeInstance.getStringLeetCodeInstance().isMatch("cb", "?a"), false);

    }

    @Test
    public void testArrayLeetCode() {
        /**{@link <a href="https://leetcode.com/problems/maximum-subarray/"></a>}*/
        int[] testArray1 = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        Assert.assertEquals(ArrayLeetCode.ArrayLeetCodeInstance.getArrayLeetCodeInstance().maxSubArray(testArray1), 6);
        int[] testArray2 = new int[]{1};
//        Assert.assertEquals(ArrayLeetCode.ArrayLeetCodeInstance.getArrayLeetCodeInstance().maxSubArray(testArray2), 1);

        int[] testArray3 = new int[]{5, 4, -1, 7, 8};
//        Assert.assertEquals(ArrayLeetCode.ArrayLeetCodeInstance.getArrayLeetCodeInstance().maxSubArray(testArray3), 23);
        int[] testCandyDistribute = new int[]{1, 0, 2};
        Assert.assertEquals(5, ArrayLeetCode.ArrayLeetCodeInstance.getArrayLeetCodeInstance().distributeMinCandy(testCandyDistribute));
        int[] testCandyDistribute2 = new int[]{1, 2, 2};
        Assert.assertEquals(4, ArrayLeetCode.ArrayLeetCodeInstance.getArrayLeetCodeInstance().distributeMinCandy(testCandyDistribute2));
        int[] testCandyDistribute3 = new int[]{1, 2, 3, 3, 1, 1}; //sum(1,2,3,2,1,1 )
        Assert.assertEquals(10, ArrayLeetCode.ArrayLeetCodeInstance.getArrayLeetCodeInstance().distributeMinCandy(testCandyDistribute3));
        char[][] testMetric = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        Assert.assertEquals(6, ArrayLeetCode.ArrayLeetCodeInstance.getArrayLeetCodeInstance().maximalRectangle(testMetric));
        int[] testSum=new int[] {-5,-2,-3,-2,-1,-1,-3,4,6,0,2,3};
        List<List<Integer>> list=ArrayLeetCode.ArrayLeetCodeInstance.getArrayLeetCodeInstance().getElementsSumZero(testSum);
        for(List<Integer> tmp:list){
            tmp.forEach(integer -> System.out.print(integer));
            System.out.println();

        }
        testSum=new int[] {1, 2, 3, 4, 5};
        List<List<Integer>> listSum2=ArrayLeetCode.ArrayLeetCodeInstance.getArrayLeetCodeInstance().getTwoSum(testSum,6);
        for(List<Integer> tmp:listSum2){
            tmp.forEach(integer -> System.out.print(integer));
            System.out.println();

        }
        listSum2=ArrayLeetCode.ArrayLeetCodeInstance.getArrayLeetCodeInstance().getTwoSumV2(testSum,6);
        for(List<Integer> tmp:listSum2){
            tmp.forEach(integer -> System.out.print(integer));
            System.out.println();

        }
        listSum2=ArrayLeetCode.ArrayLeetCodeInstance.getArrayLeetCodeInstance().getTwoSumV3HashMapVersion(testSum,6);
        for(List<Integer> tmp:listSum2){
            tmp.forEach(integer -> System.out.print(integer));
            System.out.println();

        }
        int[] []testMetrics=new int[] []{{1,3},{2,6},{8,10},{15,18}};
        System.out.println("--------------getMergeIntervals---------------------");
        listSum2=ArrayLeetCode.ArrayLeetCodeInstance.getArrayLeetCodeInstance().getMergeIntervalsV1False(testMetrics);
        for(List<Integer> tmp:listSum2){
            tmp.forEach(integer -> System.out.print(integer));
            System.out.println();

        }
        testMetrics = new int[][]{{15, 18}, {1, 3}};
        listSum2=ArrayLeetCode.ArrayLeetCodeInstance.getArrayLeetCodeInstance().getMergeIntervalsV1False(testMetrics);
        for(List<Integer> tmp:listSum2){
            tmp.forEach(integer -> System.out.print(integer));
            System.out.println();

        }
        listSum2=ArrayLeetCode.ArrayLeetCodeInstance.getArrayLeetCodeInstance().getMergeIntervalsV2Fixed(testMetrics);
        for(List<Integer> tmp:listSum2){
            tmp.forEach(integer -> System.out.print(integer));
            System.out.println();

        }

    }

    @Test
    public void testCommonFuntion() {
        Collection<Number[]> collection = new LinkedList<>();
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5};
        int[] arr3 = {6};
        Integer[] integerArr1 = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        Integer[] integerArr2 = Arrays.stream(arr2).boxed().toArray(Integer[]::new);
        Integer[] integerArr3 = Arrays.stream(arr3).boxed().toArray(Integer[]::new);
        collection.add(integerArr1);
        collection.add(integerArr2);
        collection.add(integerArr3);
        int i = 0;
        logger.info(String.valueOf(i++));
        logger.info(String.valueOf(i));


    }

    @Test
    public void testCalculate() throws Exception {
//        Calculate.Opeate opeate = new Calculate.Opeate<Integer, Integer>(12, 5, '-');
//        Assert.assertEquals(7.0, opeate.execute(opeate));
//        Calculate.Opeate opeateDiv = new Calculate.Opeate<Integer, Integer>(12, 6, '/');
//        Assert.assertEquals(2.0, opeateDiv.execute(opeateDiv));
        Calculate calculate = new Calculate();
//        calculate.getOpeator(0,4,"(5+4)");
//        calculate.getOpeator(0, 4, "(5+4)*(3+1)");
        Assert.assertEquals(51, calculate.calculate("(51+4)-(3+1)"));
        Assert.assertEquals(6, calculate.calculate("3*2"));
        Assert.assertEquals(2, calculate.calculate("4/2"));
        Assert.assertEquals(12, calculate.calculate("(4/2)*(3*2)"));
        Assert.assertEquals(10, calculate.calculate("(4/2)*(3+2)"));
        Assert.assertEquals(7, calculate.calculate("3+2*2"));

    }

    @Test
    public void testLRUCache() {
        LRUCache<Integer, Integer> lruCache = new LRUCache<>(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        Assert.assertEquals(1, lruCache.get(1).intValue());
        lruCache.put(3, 3);
        Assert.assertNull(lruCache.get(2));
        Assert.assertEquals(1, lruCache.get(1).intValue());
        Assert.assertEquals(3, lruCache.get(3).intValue());
        lruCache.get(1);
        lruCache.put(4, 4);
        Assert.assertNull(lruCache.get(3));
        Assert.assertEquals(1, lruCache.get(1).intValue());
        Assert.assertEquals(4, lruCache.get(4).intValue());
        lruCache.put(5, 5);
        Assert.assertNull(lruCache.get(1));


    }

    @Test
    public void testLRUCacheDoubleLink() {
        LRUCacheDoubleLink<Integer, Integer> lruCache = new LRUCacheDoubleLink<>(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        Assert.assertEquals(1, lruCache.get(1).intValue());
        lruCache.put(3, 3);
        Assert.assertNull(lruCache.get(2));
        Assert.assertEquals(1, lruCache.get(1).intValue());
        Assert.assertEquals(3, lruCache.get(3).intValue());
        lruCache.get(1);
        lruCache.put(4, 4);
        Assert.assertNull(lruCache.get(3));
        Assert.assertEquals(1, lruCache.get(1).intValue());
        Assert.assertEquals(4, lruCache.get(4).intValue());
        lruCache.put(5, 5);
        Assert.assertNull(lruCache.get(1));


    }

    @Test
    public void testLRUCacheDoubleLinkOneCapacity() {
        /**["LRUCache","put","get","put","get","get"]
         [[1],[2,1],[2],[3,2],[2],[3]]
         * Output
         [null,null,1,null,1,2]
         Expected
         [null,null,1,null,-1,2]*/
        LRUCacheDoubleLink<Integer, Integer> lruCache = new LRUCacheDoubleLink<Integer, Integer>(1);
        lruCache.put(2, 1);
        Assert.assertEquals(1, lruCache.get(2).intValue());
        lruCache.put(3, 2);
        Assert.assertNull(lruCache.get(2));
        Assert.assertEquals(2, lruCache.get(3).intValue());
        /**Input
         ["LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]
         [[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]

         Use Testcase
         Output
         [null,null,null,null,null,4,3,2,-1,null,-1,2,-1,4,5]
         Expected
         [null,null,null,null,null,4,3,2,-1,null,-1,2,3,-1,5]*/
        lruCache = new LRUCacheDoubleLink<Integer, Integer>(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        Assert.assertEquals(4, lruCache.get(4).intValue());
        Assert.assertEquals(3, lruCache.get(3).intValue());
        Assert.assertEquals(2, lruCache.get(2).intValue());
        Assert.assertNull(lruCache.get(1));
        lruCache.put(5, 5);
        Assert.assertNull(lruCache.get(1));
        Assert.assertEquals(2, lruCache.get(2).intValue());
        Assert.assertEquals(3, lruCache.get(3).intValue());
        Assert.assertEquals(4, lruCache.get(4).intValue());
        Assert.assertEquals(5, lruCache.get(5).intValue());
    }

    @Test
    public void testReverseBetween() {
        ListLeetCode listLeetCode = ListLeetCode.ListLeetCodeInstance.getInstance();
        ListLeetCode.ListNode listNode1 = new ListLeetCode.ListNode(1);
        ListLeetCode.ListNode listNode2 = new ListLeetCode.ListNode(2);
        ListLeetCode.ListNode listNode3 = new ListLeetCode.ListNode(3);
        ListLeetCode.ListNode listNode4 = new ListLeetCode.ListNode(4);
        ListLeetCode.ListNode listNode5 = new ListLeetCode.ListNode(5);
        listNode4.setNext(listNode5);
        listNode3.setNext(listNode4);
        listNode2.setNext(listNode3);
        listNode1.setNext(listNode2);
        ListLeetCode.ListNode node = listLeetCode.reverseBetween(listNode1, 2, 4);
        while (node != null) {
            logger.info(String.valueOf(node.getVal()));
            node = node.getNext();
        }
        node = listLeetCode.reverseBetween(listNode5, 1, 1);
        while (node != null) {
            logger.info(String.valueOf(node.getVal()));
            node = node.getNext();
        }
        listNode3.setNext(listNode5);
        node = listLeetCode.reverseBetween(listNode3, 1, 2);
        while (node != null) {
            logger.info(String.valueOf(node.getVal()));
            node = node.getNext();
        }
    }

    @Test
    public void testListleetCode() {
        ListLeetCode listLeetCode = ListLeetCode.ListLeetCodeInstance.getInstance();
        //lists = [[1,4,5],[1,3,4],[2,6]]
        ListLeetCode.ListNode listNode = new ListLeetCode.ListNode(1);
        ListLeetCode.ListNode listNode4 = new ListLeetCode.ListNode(4);
        listNode4.setNext(new ListLeetCode.ListNode(5));
        listNode.setNext(listNode4);
        ListLeetCode.ListNode listNode20 = new ListLeetCode.ListNode(1);
        ListLeetCode.ListNode listNode23 = new ListLeetCode.ListNode(3);
        listNode23.setNext(new ListLeetCode.ListNode(4));
        listNode20.setNext(listNode23);
        ListLeetCode.ListNode listNode30 = new ListLeetCode.ListNode(2);
        listNode30.setNext(new ListLeetCode.ListNode(6));
        ListLeetCode.ListNode[] list = new ListLeetCode.ListNode[]{listNode, listNode20, listNode30};
        ListLeetCode.ListNode node = listLeetCode.mergeKLists(list);
        while (node != null) {
            logger.info(String.valueOf(node.getVal()));
            node = node.getNext();
        }
        //lists = [[1,4,5],[1,3,4],[2,6]]
        ListLeetCode.ListNode listNodeRecursion = new ListLeetCode.ListNode(1);
        ListLeetCode.ListNode listNode4Recursion = new ListLeetCode.ListNode(4);
        listNode4Recursion.setNext(new ListLeetCode.ListNode(5));
        listNodeRecursion.setNext(listNode4Recursion);
        ListLeetCode.ListNode listNode20Recursion = new ListLeetCode.ListNode(1);
        ListLeetCode.ListNode listNode23Recursion = new ListLeetCode.ListNode(3);
        listNode23Recursion.setNext(new ListLeetCode.ListNode(4));
        listNode20Recursion.setNext(listNode23Recursion);
        ListLeetCode.ListNode listNode30Recursion = new ListLeetCode.ListNode(2);
        listNode30Recursion.setNext(new ListLeetCode.ListNode(6));
        ListLeetCode.ListNode[] list1 = new ListLeetCode.ListNode[]{listNodeRecursion, listNode20Recursion, listNode30Recursion};
        ListLeetCode.ListNode nodeRecursion = listLeetCode.mergeKListsRecursion(list1);
        while (nodeRecursion != null) {
            logger.info("nodeRecursion:" + String.valueOf(nodeRecursion.getVal()));
            nodeRecursion = nodeRecursion.getNext();
        }
        int[][] arr = {{1, 4, 5}, {3, 4, 5}, {2, 2, 2}, {4, 5, 6}};
        ArrayList<Integer> arrayList = listLeetCode.mergeKArrays(arr, 4);
        for (Integer tmp : arrayList) {
            logger.info("mergeKArrays:" + String.valueOf(tmp));
        }

    }
    @Test
    public void testBiStackCalculate(){
        Stack<Character> ops=new Stack<>();
        Stack<Integer> numbers=new Stack<>();
        BiStackCalculate biStackCalculate=new BiStackCalculate();
        ops.push('/');
        numbers.push(2);numbers.push(6);
        Assert.assertEquals(2,numbers.size());
        Assert.assertEquals(1,ops.size());
//        Assert.assertEquals(3,biStackCalculate.calculateSingleBiStack(ops,numbers).intValue());
//        ops.push('+');   numbers.push(6); numbers.push(2);
//        Assert.assertEquals(2,numbers.size());
//        Assert.assertEquals(1,ops.size());
//        Assert.assertEquals(8,biStackCalculate.calculateSingleBiStack(ops,numbers).intValue());

        String express="5*3+5";
        int result=biStackCalculate.calculate(express);
        Assert.assertEquals(20,result);
        express="5*(35+5)+2";
        result=biStackCalculate.calculate(express);
        Assert.assertEquals(202,result);
        express="5*(35+5*3)+2";

        result=biStackCalculate.calculate(express);
        Assert.assertEquals(252,result);
    }

}
