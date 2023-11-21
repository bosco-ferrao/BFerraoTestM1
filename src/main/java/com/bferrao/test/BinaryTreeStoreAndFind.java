package com.bferrao.test;

class Node {
    public Integer value;
    public Node left;
    public Node right;
    public static Node root;
    
    public Node() {
    	
    }

    public Node(int[] numbers)
    {
    	root = new Node();
    	root.value = numbers[0];
        // YOUR SOLUTION HERE
    	for (int i=1; i<numbers.length; i++) {
    		setValue(numbers[i], root);
    	}
    }

    private void setValue(int curVal, Node curNode) {
		if (curVal < curNode.value) {
			if (curNode.left == null) {
				Node node = new Node();
				node.value = curVal;
				curNode.left = node;
			} else {
				setValue(curVal, curNode.left);
			}
		}
		if (curVal > curNode.value) {
			if (curNode.right == null) {
				Node node = new Node();
				node.value = curVal;
				curNode.right = node;
			} else {
				setValue(curVal, curNode.right);
			}
		}
	}



	public boolean find(int nrToFind)
    {
        // YOUR SOLUTION HERE
    	return find(nrToFind, root);
    }
    
	public boolean find(int nrToFind, Node curNode) {
		if (curNode == null) {
			return false;
		}
		if (nrToFind == curNode.value) {
			return true;
		}
		if (nrToFind < curNode.value) {
			return find(nrToFind, curNode.left);
		} else {
			return find(nrToFind, curNode.right);
		}
	}
}


class BinaryTreeStoreAndFind {
    public boolean solution(int[] numbers, int nrToFind) {
        return new Node(numbers).find(nrToFind);
    }
    
    public static void main(String[] args) {
    	int[] numbers = { 5, 3, 10, 1, 9, 20 };
    	
    	System.out.println(new BinaryTreeStoreAndFind().solution(numbers, 20));
    	
    }
}
