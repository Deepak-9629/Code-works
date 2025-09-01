package firstweektask;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;   
    TreeNode(int val) {
        this.val = val;
    }
}
class BinaryTreeSerializer {
    private static final String NULL_SYMBOL = "N";
    private static final String DELIMITER = ",";  
    public String serialize(TreeNode root) {
        if (root == null) return NULL_SYMBOL;
        return root.val + DELIMITER + serialize(root.left) + DELIMITER + serialize(root.right);
    }
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(DELIMITER)));
        return buildTree(nodes);
    }
    
    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.poll();
        if (val.equals(NULL_SYMBOL)) return null;
        
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }
}

public class Task8 {
    public static void main(String[] args) {
        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        
        String serialized = serializer.serialize(root);
        System.out.println("Serialized: " + serialized);
        
        TreeNode deserializedRoot = serializer.deserialize(serialized);
        System.out.println("Deserialization Complete!");
    }
}
