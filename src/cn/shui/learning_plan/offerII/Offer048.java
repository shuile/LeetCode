package cn.shui.learning_plan.offerII;

import cn.shui.learning_plan.offerII.model.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author shui.
 * @date 2021/12/19.
 * @time 20:48.
 * 序列化与反序列化二叉树
 */
public class Offer048 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        Codec test = new Codec();
        String serializeData = test.serialize(root);
        System.out.println(serializeData);
        TreeNode deserializeRoot = test.deserialize(serializeData);
        System.out.println(deserializeRoot);
    }

    private static class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "[null]";
            }
            StringBuilder sb = new StringBuilder("[");
            boolean isRoot = true;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append(isRoot ? "null" : ",null");
                } else {
                    sb.append(isRoot ? "" + node.val : "," + node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                isRoot = false;
            }
            return sb.append("]").toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String realData = data.substring(1, data.length() - 1);
            String[] splits = realData.split(",");
            TreeNode root = splits[0].equals("null") ? null : new TreeNode(Integer.parseInt(splits[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int index = 1;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                if (!splits[index].equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(splits[index]));
                    queue.offer(node.left);
                }
                index++;
                if (!splits[index].equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(splits[index]));
                    queue.offer(node.right);
                }
                index++;
            }
            return root;
        }
    }

    private class Codec2 {
        public String serialize(TreeNode root) {
            return rserialize(root, "");
        }

        public TreeNode deserialize(String data) {
            String[] dataArray = data.split(",");
            List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
            return rdeserialize(dataList);
        }

        private String rserialize(TreeNode root, String str) {
            if (root == null) {
                str += "None,";
            } else {
                str += str.valueOf(root.val) + ",";
                str = rserialize(root.left, str);
                str = rserialize(root.right, str);
            }
            return str;
        }

        private TreeNode rdeserialize(List<String> dataList) {
            if (dataList.get(0).equals("None")) {
                dataList.remove(0);
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
            dataList.remove(0);
            root.left = rdeserialize(dataList);
            root.right = rdeserialize(dataList);
            return root;
        }
    }

    private class Codec3 {
        public String serialize(TreeNode root) {
            if (root == null) {
                return "X";
            }
            String left = "(" + serialize(root.left) + ")";
            String right = "(" + serialize(root.right) + ")";
            return left + root.val + right;
        }

        public TreeNode deserialize(String data) {
            int[] ptr = {0};
            return parse(data, ptr);
        }

        private TreeNode parse(String data, int[] ptr) {
            if (data.charAt(ptr[0]) == 'X') {
                ++ptr[0];
                return null;
            }
            TreeNode cur = new TreeNode(0);
            cur.left = parseSubtree(data, ptr);
            cur.val = parseInt(data, ptr);
            cur.right = parseSubtree(data, ptr);
            return cur;
        }

        private TreeNode parseSubtree(String data, int[] ptr) {
            ++ptr[0]; // 跳过左括号
            TreeNode subtree = parse(data, ptr);
            ++ptr[0]; // 跳过右括号
            return subtree;
        }

        private int parseInt(String data, int[] ptr) {
            int x = 0, sgn = 1;
            if (!Character.isDigit(data.charAt(ptr[0]))) {
                sgn = -1;
                ++ptr[0];
            }
            while (Character.isDigit(data.charAt(ptr[0]))) {
                x = x * 10 + data.charAt(ptr[0]++) - '0';
            }
            return x * sgn;
        }
    }
}
