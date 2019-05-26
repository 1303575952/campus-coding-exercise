package tree;

/**
 * 两个节点的公共祖先
 */
public class CommonAncestor {
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        boolean existA = isNodeInTree(root, A);
        boolean existB = isNodeInTree(root, B);
        if (!existA || !existB) {
            return null;
        }

        return getLowestAncestor(root, A, B);
    }

    private static TreeNode getLowestAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || A == null || B == null) return null;
        if (root == A || root == B) return root;
        TreeNode left = getLowestAncestor(root.left, A, B);
        TreeNode right = getLowestAncestor(root.right, A, B);
        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;

    }

    private static boolean isNodeInTree(TreeNode root, TreeNode node) {
        if (root == null || node == null) return false;
        if (root == node) return true;
        boolean left = isNodeInTree(root.left, node);
        boolean right = isNodeInTree(root.right, node);
        return left || right;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(7);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(6);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        System.out.println(lowestCommonAncestor(a, d, e).val);
    }
}
