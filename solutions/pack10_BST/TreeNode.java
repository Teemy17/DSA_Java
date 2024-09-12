package solutions.pack10_BST;

public class TreeNode {
    int data;
    TreeNode left, right, parent;

    public TreeNode(int d) {
        data = d;
    }

    public String to_String() {
        return "null<-" + data + "->null";
    }
}
