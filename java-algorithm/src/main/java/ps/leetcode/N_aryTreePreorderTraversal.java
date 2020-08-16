package ps.leetcode;

import java.util.ArrayList;
import java.util.List;

public class N_aryTreePreorderTraversal {

    private List<Integer> result = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        traversal(root, result);
        return result;
    }

    private void traversal(Node root, List<Integer> result) {
        if(root == null) {
            return;
        }

        result.add(root.val);
        for(Node child : root.children) {
            traversal(child, result);
        }
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}


