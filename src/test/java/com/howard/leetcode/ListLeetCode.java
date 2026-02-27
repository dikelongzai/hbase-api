package com.howard.leetcode;

import java.util.*;

public class ListLeetCode {
    private ListLeetCode() {
    }

    public static class ListLeetCodeInstance {
        protected static final ListLeetCode listLeetCode = new ListLeetCode();

        public static ListLeetCode getInstance() {
            return listLeetCode;
        }
    }

    /**
     * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
     * <p>
     * Merge all the linked-lists into one sorted linked-list and return it.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: lists = [[1,4,5],[1,3,4],[2,6]]
     * Output: [1,1,2,3,4,4,5,6]
     * Explanation: The linked-lists are:
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * merging them into one sorted list:
     * 1->1->2->3->4->4->5->6
     * Example 2:
     * <p>
     * Input: lists = []
     * Output: []
     * Example 3:
     * <p>
     * Input: lists = [[]]
     * Output: []
     * <p>
     * <p>
     * Constraints:
     * <p>
     * k == lists.length
     * 0 <= k <= 104
     * 0 <= lists[i].length <= 500
     * -104 <= lists[i][j] <= 104
     * lists[i] is sorted in ascending order.
     * The sum of lists[i].length will not exceed 104.
     * each linked-list is sorted in ascending order.
     * <p>
     * method of recursion to combine the list, the node of merged list which is sorted in ascending order,
     *
     * @param lists
     * @return
     * @link <a herf="https://leetcode.com/problems/merge-k-sorted-lists/description/"></>
     */
    public ListNode mergeKListsRecursion(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKListsHelper(lists, 0, lists.length - 1);
    }

    private ListNode mergeKListsHelper(ListNode[] lists, int startIndex, int endIndex) {

        if (startIndex == endIndex) {
            return lists[startIndex];
        }
        if (startIndex + 1 == endIndex) {
            return merge(lists[startIndex], lists[endIndex]);
        }
        int mid = startIndex + (endIndex - startIndex) / 2;
        ListNode left = mergeKListsHelper(lists, startIndex, mid);
        ListNode right = mergeKListsHelper(lists, mid + 1, endIndex);
        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    /**
     * Function to merge k sorted arrays.
     *
     * @param arr
     * @param K
     * @return
     * @link <a herf="https://leetcode.com/problems/merge-k-sorted-lists/description/"></>
     */
    public ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        // Define a min-heap
        Queue<Element> minHeap = new PriorityQueue<Element>((a, b) -> a.value - b.value);
        // Initialize the heap with the first element of each array
        for (int i = 0; i < K; i++) {
            if (arr[i].length > 0) {
                minHeap.add(new Element(i, 0, arr[i][0]));
            }

        }
        // Extract elements from the heap and add the next element from the respective array
        while (!minHeap.isEmpty()) {
            Element current = minHeap.poll();
            arrayList.add(current.value);
            if (current.col + 1 < arr[current.row].length) {
                minHeap.add(new Element(current.row, current.col + 1, arr[current.row][current.col + 1]));
            }
        }
        return arrayList;


    }

    /**
     * @param head
     * @param left
     * @param right
     * @return
     * @link <a herf="https://leetcode.com/problems/reverse-linked-list-ii/solutions/"></>
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode listNode = new ListNode(-1);
        ListNode curr = listNode;
        int index = 1;
        Stack<ListNode> list = new Stack<>();
        if (left == right) return head;
        while (head != null) {
            if (left <= index && index <= right) {
                list.push(head);
            } else {
                if (index > right) {
                    if (index == right + 1) {
                        curr = combinationListNode(curr, list);
                    }
                }
                curr.next = head;
                curr = curr.getNext();

            }
            head = head.getNext();

            index++;
        }
        if (!list.isEmpty()) {
            combinationListNode(curr, list);
        }
        return listNode.next;
    }

    protected ListNode combinationListNode(ListNode listNode, Stack<ListNode> list) {
        while (!list.isEmpty() && list.peek() != null) {
            ListNode pollNode = list.pop();
            pollNode.next = null;
            listNode.setNext(pollNode);
            listNode = pollNode;
        }
        return listNode;
    }

    /**
     * 23. Merge k Sorted Lists
     *
     * @param lists
     * @return
     * @link <a herf="https://leetcode.com/problems/merge-k-sorted-lists/description/"></>
     */
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.add(listNode);
            }
        }
        ListNode head = new ListNode(-1);
        ListNode point = head;
        while (!queue.isEmpty()) {
            point.next = queue.poll();
            point = point.next;
            if (point.next != null) {
                // add next of current smallest
                queue.add(point.next);
            }
        }
        return head.next;
    }

    public static class ListNode {
        public int getVal() {
            return val;
        }

        int val;

        public void setNext(ListNode next) {
            this.next = next;
        }

        public ListNode getNext() {
            return next;
        }

        ListNode next;

        ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Helper class to store elements in the min-heap
    public static class Element {
        final int row;
        final int col;

        final int value;

        public Element(int row, int col, int value) {

            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
}
