/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return null;
        Map<Integer,UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node.label,newNode);
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode n = queue.poll();
            for(UndirectedGraphNode neighbor : n.neighbors){
                if(!map.containsKey(neighbor.label)){
                    map.put(neighbor.label,new UndirectedGraphNode(neighbor.label));
                    queue.offer(neighbor);
                }
                map.get(n.label).neighbors.add(map.get(neighbor.label));
            }
        }
        return newNode;
    }
}