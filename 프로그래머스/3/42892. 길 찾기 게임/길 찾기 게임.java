import java.util.*;
class Solution {
    // 이진 트리
    private static class Node {
        int x;
        int y;
        int id;
        Node left;
        Node right;
        
        public Node(int x, int y, int id) {
            this.x = x;
            this.y = y;
            this.id = id;
        }
    }
    
    private static Node formTree(int[][] nodeinfo) {
        int countNodes = nodeinfo.length;
        Node[] nodes = new Node[countNodes];
        for (int i = 0; i < countNodes; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
        }
        // y에 대한 내림차순 -> x에 대한 오름차순
        Arrays.sort(nodes, Comparator.comparingInt( (Node node) -> -node.y)
                  .thenComparing(node -> node.x));
        
        Node root = nodes[0];
        
        for (int i = 1; i < countNodes; i++) {
            insertNode(root, nodes[i]);
        }
        
        return nodes[0];
    }
    
    private static void insertNode(Node parent, Node newNode) {
        // x가 작으면 왼쪽에 삽입
        if (newNode.x < parent.x) {
            if (parent.left == null) {
                parent.left = newNode;
            } else {
                insertNode(parent.left, newNode);
            }
        }
        if (newNode.x >= parent.x) {
            if (parent.right == null) {
                parent.right = newNode;
            } else {
                insertNode(parent.right, newNode);
            }
        }
    }
    
    private static List<Integer> preorder(Node currentNode, List<Integer> result) {
        if (currentNode == null) {
            return new ArrayList<>();
        }
        result.add(currentNode.id);
        preorder(currentNode.left, result);
        preorder(currentNode.right, result);
        return result;
    }
    
    private static List<Integer> postorder(Node currentNode, List<Integer> result) {
        if (currentNode == null) {
            return new ArrayList<>();
        }
        
        postorder(currentNode.left, result);
        postorder(currentNode.right, result);
        result.add(currentNode.id);
        return result;
    }
    
    public int[][] solution(int[][] nodeinfo) {
        Node root = formTree(nodeinfo);
        List<Integer> preorderHistory = preorder(root, new ArrayList<>());
        List<Integer> postorderHistory = postorder(root, new ArrayList<>());
        
        int[][] result = new int[2][nodeinfo.length];        
        result[0] = preorderHistory.stream().mapToInt(x -> x).toArray();
        result[1] = postorderHistory.stream().mapToInt(x -> x).toArray();
        return result;
    }
}