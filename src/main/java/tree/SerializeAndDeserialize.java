package tree;

/**
 * 序列化二叉树
 */
public class SerializeAndDeserialize {
    private static String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        serialize2(root, sb);
        return sb.toString();
    }

    private static void serialize2(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        sb.append(',');
        serialize2(root.left, sb);
        serialize2(root.right, sb);
    }

    private static int index = -1;

    private static TreeNode deserialize(String str) {
        if (str.length() == 0)
            return null;
        String[] strs = str.split(",");
        return deserialize2(strs);
    }

    private static TreeNode deserialize2(String[] strs) {
        index++;
        if (!strs[index].equals("#")) {
            TreeNode root = new TreeNode(0);
            root.val = Integer.parseInt(strs[index]);
            root.left = deserialize2(strs);
            root.right = deserialize2(strs);
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(11);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(17);
        System.out.println(serialize(root));
    }
}
