package solutions.pack10_BST;

import java.util.List;

public class BST {
    TreeNode root;

    public BST() {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void insert(int d) {
        if (root == null) {
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
        return searchRecursive(d, root);
    }

    public TreeNode searchRecursive(int d, TreeNode node) {
        if (node == null)
            return null;
        if (d == node.data)
            return node;
        if (d < node.data)
            return searchRecursive(d, node.left);
        return searchRecursive(d, node.right);
    }

    public void delete(int d) {
        deleteRecursive(d, root);
    }

    public void deleteRecursive(int d, TreeNode node) {
        if (node == null) return;
        if (d < node.data)
            deleteRecursive(d, node.left);
        else if (d > node.data)
            deleteRecursive(d, node.right);
        else {
            if ((node.left == null) || (node.right == null)) {
                TreeNode q = (node.left == null) ? node.right : node.left;
                if ((node.parent.left == node))
                    node.parent.left = q;
                else
                    node.parent.right = q;
                if (q != null) q.parent = node.parent;
            } else {
                TreeNode q = findMaxFrom(node.left);
                deleteRecursive(q.data, node.left);
                if (node.parent.left == node)
                    node.parent.left = q;
                else
                    node.parent.right = q;
                q.left = node.left;
                q.right = node.right;
            }
        }
    }

    private TreeNode findMaxFrom(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public void printInOrder() {
        printInOrderRecursive(root);
        System.out.println();
    }

    public void printInOrderRecursive(TreeNode node) {
        if (node == null) return;
        printInOrderRecursive(node.left);
        System.out.print(node.data + " ");
        System.out.println();
        printInOrderRecursive(node.right);
    }

    public void printPreOrder() {
        printPreOrderRecursive(root);
        System.out.println();
    }

    public void printPreOrderRecursive(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        printPreOrderRecursive(node.left);
        printPreOrderRecursive(node.right);
    }

    public void printPostOrder() {
        printPostOrderRecursive(root);
        System.out.println();
    }

    public void printPostOrderRecursive(TreeNode node) {
        if (node == null)
            return;
        printPostOrderRecursive(node.left);
        printPostOrderRecursive(node.right);
        System.out.print(node.data + " ");
    }

    public TreeNode findMax() {
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    public TreeNode findMin() {
        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public int height() {
        return heightRecursive(root);
    }

    public int heightRecursive(TreeNode node) {
        if (node == null)
            return -1;
        return 1 + Math.max(heightRecursive(node.left), heightRecursive(node.right));
    }

    public int count() {
        return countRecursive(root);
    }

    public int countRecursive(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + countRecursive(node.left) + countRecursive(node.right);
    }

    public int findRank(int d) {
        return findRankRecursive(root, d);
    }

    public int findRankRecursive(TreeNode node, int d) {
        if (node == null)
            return -1;

        if (d == node.data) {
            return countRecursive(node.left) + 1;
        } else if (d < node.data) {
            return findRankRecursive(node.left, d);
        } else {
            int leftCount = countRecursive(node.left);
            int rightRank = findRankRecursive(node.right, d);
            return rightRank == -1 ? -1 : leftCount + 1 + rightRank;
        }
   }

    public int findMedian() {
        List<Integer> list = new java.util.ArrayList<>();
        findMedianRecursive(root, list);
        int size = list.size();
        if (size % 2 == 0) {
            return (list.get(size / 2 - 1) + list.get(size / 2)) / 2;
        }
        return list.get(size / 2);
    }

    private void findMedianRecursive(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        findMedianRecursive(node.left, list);
        list.add(node.data);
        findMedianRecursive(node.right, list);
    }
}