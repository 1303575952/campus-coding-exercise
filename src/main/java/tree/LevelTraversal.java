package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 树的层次遍历
 */
public class LevelTraversal {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        Deque<TreeNode> deque = new LinkedList<TreeNode>();

        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode t = deque.pop();
            list.add(t.val);
            if (t.left != null) deque.add(t.left);
            if (t.right != null) deque.add(t.right);
        }
        return list;
    }
}
