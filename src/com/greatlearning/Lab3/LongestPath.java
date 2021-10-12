package com.greatlearning.Lab3;

import java.util.ArrayList;

public class LongestPath {
	
	static class Node {
		Node left;
		Node right;
		int data;
	};

	
	static Node newNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	
	public static ArrayList<Integer> longestPath(Node root) {

		
		if (root == null) {
			ArrayList<Integer> output = new ArrayList<>();
			return output;
		}

		
		ArrayList<Integer> rightArrayList = longestPath(root.right);

		
		ArrayList<Integer> leftArrayList = longestPath(root.left);

		
		if (rightArrayList.size() < leftArrayList.size()) {
			leftArrayList.add(root.data);
		} else {
			rightArrayList.add(root.data);
		}

		
		return (leftArrayList.size() > rightArrayList.size() ? leftArrayList : rightArrayList);
	}

	
	public static void main(String[] args) {
		Node root = newNode(100);
		root.left = newNode(20);
		root.right = newNode(130);
		root.left.left = newNode(10);
		root.left.right = newNode(50);
		root.right.left = newNode(110);
		root.right.right = newNode(140);
		root.left.left.left = newNode(5);

		ArrayList<Integer> outputList = longestPath(root);
		int lengthOfOutput = outputList.size();

		System.out.print("The longest path of the tree is :  ");
		System.out.print(outputList.get(lengthOfOutput - 1));
		for (int i = lengthOfOutput - 2; i >= 0; i--) {
			System.out.print(" -> " + outputList.get(i));
		}
	}
}
