package com.howard.leetcode;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeHelper {
    /**
     * foreach a TreeNode in sort order with level 层级遍历
     *
     * @param
     */
    public static <T> Collection<T> levelOrder(BinaryTreeNode rootNode, boolean containEmptyNode) {
        Queue<T> list = new LinkedList<>();
        if (rootNode == null) return null;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(rootNode);
        while (!queue.isEmpty()) {
            //Ensure hierarchical order with the queue FIFO feature,
            BinaryTreeNode binaryTreeNode = queue.poll();
            list.add((T) binaryTreeNode.getVal());
            // Fill the empty left node with null
            if (binaryTreeNode.getRightNode() != null && binaryTreeNode.getLeftNode() == null && containEmptyNode) {
                queue.add(new BinaryTreeNode(null));
            }
            if (binaryTreeNode.getLeftNode() != null) {
                queue.add(binaryTreeNode.getLeftNode());
            }
            if (binaryTreeNode.getRightNode() != null) {
                queue.add(binaryTreeNode.getRightNode());

            }

        }
        return list;

    }

    /**
     * preorder traversal sequence 二叉树先序遍历 root->left->right
     *
     * @param rootNode
     * @param collectionTree
     * @return
     */
    public static <T> Collection<T> preOrder(BinaryTreeNode rootNode, Queue<T> collectionTree) {
        if (rootNode == null) return collectionTree;
        collectionTree.add((T) rootNode.getVal());
        preOrder(rootNode.getLeftNode(), collectionTree);
        preOrder(rootNode.getRightNode(), collectionTree);
        return collectionTree;
    }

    /**
     * inOrder 二叉树中序遍历 (左-根-右)
     *
     * @param rootNode
     * @param collectionTree
     * @return
     */
    public static <T> Collection<T> inOrder(BinaryTreeNode rootNode, Queue<T> collectionTree) {
        if (rootNode == null) return collectionTree;
        inOrder(rootNode.getLeftNode(), collectionTree);
        collectionTree.add((T) rootNode.getVal());
        inOrder(rootNode.getRightNode(), collectionTree);
        return collectionTree;
    }

    /**
     * inOrder 二叉树右序遍历 (右-根-左)
     *
     * @param rootNode
     * @param collectionTree
     * @return
     */
    public static <T> Collection<T> postOrder(BinaryTreeNode rootNode, Queue<T> collectionTree) {
        if (rootNode == null) return collectionTree;
        postOrder(rootNode.getRightNode(), collectionTree);
        collectionTree.add((T) rootNode);
        postOrder(rootNode.getLeftNode(), collectionTree);
        return collectionTree;
    }

    /**
     * build a binaryTree based on the given array
     *
     * @param numbers
     * @return
     */
    public static BinaryTreeNode buildBinaryTree(String[] numbers) {
        Preconditions.checkArrayNotEmpty("the numbersArr can't be null", numbers);
//        Preconditions.checkElementIndex(0,1);
//        BinaryTreeNode binaryTreeNode=new BinaryTreeNode(n)
        BinaryTreeNode rootTreeNode = new BinaryTreeNode(Integer.valueOf(numbers[0]));
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(rootTreeNode);
        for (int i = 1; i < numbers.length; i = i + 2) {
            if (numbers[i] == null && numbers[i + 1] == null) {
                //if head of queue have no children the head node need be removed
                queue.remove();
            } else {
                if (numbers[i] != null) {
                    BinaryTreeNode leftTreeNode = new BinaryTreeNode(numbers[i]);
                    queue.peek().setLeftNode(leftTreeNode);
                    queue.add(leftTreeNode);
                }
                if (numbers[i + 1] != null) {
                    BinaryTreeNode rightTreeNode = new BinaryTreeNode(numbers[i + 1]);
                    queue.peek().setRightNode(rightTreeNode);
                    queue.add(rightTreeNode);
                }
                queue.poll();


            }


        }
        return rootTreeNode;
    }

    /**
     * @param numbers build balanced binary tree
     * @param start   startIndex
     * @param end     endIndex
     * @return
     */
    public static BinaryTreeNode helps(int[] numbers, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode(numbers[mid]);
        binaryTreeNode.setLeftNode(helps(numbers, start, mid - 1));
        binaryTreeNode.setRightNode(helps(numbers, mid + 1, end));
        return binaryTreeNode;
    }

    /**
     * {@code https://leetcode.com/problems/minimum-depth-of-binary-tree/description/} 111
     * Input: root = [3,9,20,null,null,15,7]
     * Output: 2
     * Example 2:
     * <p>
     * Input: root = [2,null,3,null,4,null,5,null,6]
     * Output: 5
     * <p>
     * Queue<BinaryTreeNode> queue = new LinkedList<>();
     * queue.add(root);
     * boolean hasAnotherChild=false;
     * <p>
     * while (!queue.isEmpty()) {
     * BinaryTreeNode currentTreeNode =queue.poll(),nextTreeNode=null;
     * if(hasAnotherChild){
     * nextTreeNode=queue.poll();
     * }
     * minDepth++;
     * if(currentTreeNode.getLeftNode() == null && currentTreeNode.getRightNode() == null){
     * break;
     * }
     * if(nextTreeNode!=null&&nextTreeNode.getLeftNode()==null&&nextTreeNode.getRightNode()==null){
     * break;
     * }
     * if(!currentTreeNode.equals(root)){
     * nextTreeNode = queue.peek();
     * <p>
     * minDepth++;
     * //a leaf with no children the number depth is the minDepth
     * if (currentTreeNode.getLeftNode() == null && currentTreeNode.getRightNode() == null) {
     * break;
     * }
     * //            if(lastRightChild){
     * //
     * //            }
     * if(currentTreeNode.getLeftNode() != null&&currentTreeNode.getRightNode() != null){
     * hasAnotherChild=true;
     * }
     * if (currentTreeNode.getLeftNode() != null) {
     * //add firstNode first then firstNode poll first
     * BinaryTreeNode leftTreeNode = currentTreeNode.getLeftNode();
     * queue.add(leftTreeNode);
     * }
     * if (currentTreeNode.getRightNode() != null) {
     * BinaryTreeNode rightTreeNode = currentTreeNode.getRightNode();
     * queue.add(rightTreeNode);
     * }
     * //                lastNode=currentTreeNode;
     * }
     * <p>
     * <p>
     * }
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the tree is in the range [0, 105].
     * -1000 <= Node.val <= 1000
     *
     * @param root
     * @return
     */
    public static int minDepth(BinaryTreeNode root) {
        if (root == null) return 0;

        int leftDepth = minDepth(root.getLeftNode());
        int rightDepth = minDepth(root.getRightNode());
        if (root.getLeftNode() == null && root.getRightNode() == null) {
            return 1;
        }
        //If the left subtree is empty, return the depth of right subtree after adding 1 to it...
        if (root.getLeftNode() == null) return 1 + rightDepth;
        if (root.getRightNode() == null) return 1 + leftDepth;
        //Pick the minimum out of these two subtrees and return this value after adding 1 to it...
        return Math.min(leftDepth, rightDepth) + 1;

    }


}
