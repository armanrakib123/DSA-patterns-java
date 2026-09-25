import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() { val = 0; neighbors = new ArrayList<Node>(); }
    public Node(int _val) { val = _val; neighbors = new ArrayList<Node>(); }
}

public class CloneGraph {
    private Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // যদি নোডটি অলরেডি ক্লোন করা হয়ে থাকে, তবে সেটিই রিটার্ন করো
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // নতুন নোড তৈরি করো
        Node cloneNode = new Node(node.val);
        map.put(node, cloneNode);

        // প্রতিবেশীদের ওপর DFS চালিয়ে তাদের ক্লোন করো
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }

    // টাইম কমপ্লেক্সিটি: O(V + E)
    // স্পেস কমপ্লেক্সিটি: O(V)
}















/**
 * 🎯 Problem: Clone Graph (LeetCode 133)
 * লেভেল: Medium (Graph DFS)
 * 
 * প্রশ্ন: একটি কানেক্টেড আনডিরেক্টেড গ্রাফের একটি নোড দেওয়া আছে। গ্রাফটির একটি 
 * ডিপ কপি (Deep Copy) রিটার্ন করো।
 * 
 * 💡 DFS ইন্টুইশন:
 * আমরা গ্রাফ ট্রাভার্স করব এবং প্রতিটি নোডকে একটি HashMap এ সেভ করে রাখব। 
 * HashMap এর key হবে অরিজিনাল নোড এবং value হবে ক্লোন করা নোড।
 */