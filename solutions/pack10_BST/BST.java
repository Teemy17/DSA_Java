package solutions.pack10_BST;

import com.sun.source.tree.Tree;

public class BST {
    TreeNode root;

    public BST() {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void insert(int d) {
        if(root == null) {
            root = new TreeNode(d);
            return;
        }
        TreeNode current = root;
        while (current != null) {
            if (d < current.data) {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new TreeNode(d);
                    current.left.parent = current;
                    return;
                }
            } else {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = new TreeNode(d);
                    current.right.parent = current;
                    return;
                }
            }
        }
    }

    public TreeNode search(int d) {
        TreeNode current = root;
        while (current != null) {
            if (d == current.data) {
                return current;
            } else if (d < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    public void delete(int d) {

    }
}
