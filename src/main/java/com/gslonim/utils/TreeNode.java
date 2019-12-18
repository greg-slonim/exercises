package com.gslonim.utils;

public class TreeNode<T> {
    public final T value;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
    }
}
