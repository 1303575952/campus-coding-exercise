package tree;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class SubTree {
    public boolean hasSubTree(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return false;
        }
        boolean flag = false;
        if (node1.val == node2.val) {
            flag = isSubTree(node1, node2);
        }
        if (!flag) {
            flag = hasSubTree(node1.left, node2);
            if (!flag) {
                flag = hasSubTree(node1.right, node2);
            }
        }
        return flag;
    }

    public boolean isSubTree(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            return true;
        }
        if (node1 == null && node2 != null) {
            return false;
        }
        if (node1.val == node2.val) {
            return isSubTree(node1.left, node2.left) && isSubTree(node1.right, node2.right);
        }
        return false;
    }
}
