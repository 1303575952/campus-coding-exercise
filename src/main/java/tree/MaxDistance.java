package tree;

/**
 * 在二叉树中，求距离最远的两个节点的距离
 */
class Node {
    int value;
    Node left;
    Node right;
    int maxLeft;
    int maxRight;

    public Node(int value) {
        this.value = value;
    }
}

public class MaxDistance {
    static int maxLen = 0;

    public void findMaxLen(Node node) {
        if (node == null)
            return;

        // 如果该节点的左子树为空，则该从该节点向左走的最长距离为0
        if (node.left == null) {
            node.maxLeft = 0;
        }
        // 如果该节点的右子树为空，则该从该节点向右走的最长距离为0
        if (node.right == null) {
            node.maxRight = 0;
        }

        // 如果该节点的左子树不为空，递归的计算出该节点的左孩子节点的maxLeftLen和maxRightLen（并更新maxLen）
        if (node.left != null) {
            findMaxLen(node.left);
        }

        // 如果该节点的右子树不为空，递归的计算出该节点的右孩子节点的maxLeftLen和maxRightLen（并更新maxLen）
        if (node.right != null) {
            findMaxLen(node.right);
        }

        // 如果该节点的左子树不为空，那么该节点的maxLeftLen等于它的左孩子节点的maxLeftLen、maxRightLen中较大的那个 + 1
        if (node.left != null) {
            int maxLeftLenTemp = Math.max(node.left.maxLeft, node.left.maxRight) + 1;
            node.maxLeft = maxLeftLenTemp;
        }
        // 如果该节点的右子树不为空，那么该节点的maxRightLen等于它的右孩子节点的maxLeftLen、maxRightLen中较大的那个 + 1
        if (node.right != null) {
            int maxRightLenTemp = Math.max(node.right.maxLeft, node.right.maxRight) + 1;
            node.maxRight = maxRightLenTemp;
        }
        // 到这一步，当前处理的节点的maxLeftLen和maxLeftLen已经得到了，如果它的maxLeftLen+maxRightLen值比maxLen大，就可以更新maxLen
        if (maxLen < node.maxLeft + node.maxRight) {
            maxLen = node.maxLeft + node.maxRight;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(4);
        node.left = new Node(2);
        node.right = new Node(6);
        node.left.left = new Node(1);
        node.left.right = new Node(3);
        node.right.left = new Node(5);
        node.right.right = new Node(6);
        new MaxDistance().findMaxLen(node);
        System.out.println(maxLen);
    }
}
