package etc;

public class MyBinaryTree {

    TreeNode search(int value, TreeNode root) {
        if (root == null || value == root.data) {
            return root;
        }
        if (value < root.data) {
            return search(value, root.leftChild);
        }
        return search(value, root.rightChild);
    }

    TreeNode insert(int value, TreeNode root) {
        if(value < root.data) {
            if(root.leftChild == null) {
                root.leftChild = new TreeNode(value);
            } else {
                insert(value, root.leftChild);
            }
        } else {
            if(root.rightChild == null) {
                root.rightChild = new TreeNode(value);
            } else {
                insert(value, root.rightChild);
            }
        }
        throw new IllegalArgumentException();
    }

    private static class TreeNode {

        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        public TreeNode(int data) {
            this.data = data;
        }
    }

}
