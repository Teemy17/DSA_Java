package solutions.pack10_BST;

public class TreeNode {
    int data;
    TreeNode left, right, parent;

    public TreeNode(int d) {
        data = d;
    }

    @Override
    public String toString() {
        String leftData = left == null ? "null" : String.valueOf(left.data);
        String rightData = right == null ? "null" : String.valueOf(right.data);
        return leftData + " <- " + data + " -> " + rightData;
    }
}
