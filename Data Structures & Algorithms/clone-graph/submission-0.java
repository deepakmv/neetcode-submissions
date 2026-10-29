/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        if(node == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();

        Map<Node, Node> oldToNew = new HashMap<>();
        oldToNew.put(node, new Node(node.val));

        queue.add(node);

        while(!queue.isEmpty()) {
            Node cur = queue.remove();

            for(Node n : cur.neighbors) {
                if(!oldToNew.containsKey(n)) {
                    oldToNew.put(n, new Node(n.val));
                    queue.add(n);
                }
                oldToNew.get(cur).neighbors.add(oldToNew.get(n));
            }

        }

        return oldToNew.get(node);
    }
}