package com.howard.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BinaryTreeNode<T> {
    private static final Logger logger = LoggerFactory.getLogger(BinaryTreeNode.class);

    public BinaryTreeNode(T val, BinaryTreeNode leftNode, BinaryTreeNode rightNode, BinaryTreeNode fatherNode) {
        this.val = val;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.fatherNode = fatherNode;
    }

    public BinaryTreeNode(T val) {
        this.val = val;
    }

    protected T val;

    public BinaryTreeNode getFatherNode() {
        return fatherNode;
    }

    public void setFatherNode(BinaryTreeNode fatherNode) {
        this.fatherNode = fatherNode;
    }

    private BinaryTreeNode fatherNode;
    private BinaryTreeNode leftNode;
    private BinaryTreeNode rightNode;

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public BinaryTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTreeNode rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryTreeNode that = (BinaryTreeNode) o;
        return val.equals(that.val) && Objects.equals(fatherNode, that.fatherNode) && Objects.equals(leftNode, that.leftNode) && Objects.equals(rightNode, that.rightNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, fatherNode, leftNode, rightNode);
    }

    /**
     * find the rootTreeNode
     *
     * @param randomGivenNode
     * @return
     */
    public static BinaryTreeNode findRootNode(BinaryTreeNode randomGivenNode) {
        while (randomGivenNode.getFatherNode() != null) {
            randomGivenNode = randomGivenNode.getFatherNode();
        }
        return randomGivenNode;
    }

    /**
     * whether the given Node is the root result
     *
     * @param binaryTreeNode
     * @return
     */
    public static boolean isRootNode(BinaryTreeNode binaryTreeNode) {
        return binaryTreeNode.getFatherNode() == null;
    }




}
