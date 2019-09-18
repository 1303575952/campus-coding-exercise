package tree;

/**
 * 给定两棵二叉树，把它们合并成一个二叉树，合并规则如下：
 * 如果两棵树的对应节点不为空，把这两个节点的和作为新树的节点，
 * 如果有一个节点为空，则把非空的节点作为新树的节点。
 */
public class MergeTree {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        TreeNode newNode = new TreeNode(val);
        newNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        newNode.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return newNode;
    }
}
