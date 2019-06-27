package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找树中第i大的节点值
 */
public class IthNode {
    static List<Integer> list = new ArrayList<>();

    private static void inOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        list.add(head.val);
        inOrderRecur(head.right);
    }

    private int getIthNode(TreeNode head, int i) {
        inOrderRecur(head);
        return list.get(i - 1);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        node.right = new TreeNode(6);
        node.right.left = new TreeNode(5);
        node.right.right = new TreeNode(7);
        System.out.println(new IthNode().getIthNode(node, 3));
    }
}
