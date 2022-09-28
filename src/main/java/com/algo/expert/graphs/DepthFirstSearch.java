package com.algo.expert.graphs;

import java.util.ArrayList;
import java.util.List;

public interface DepthFirstSearch {

    List<String> depthFirstSearch(Node node, List<String> array);

    class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }
    }

    class Solution1 implements DepthFirstSearch {

        @Override
        public List<String> depthFirstSearch(Node node, List<String> array) {
            array.add(node.name);
            for (Node child : node.children) {
                depthFirstSearch(child, array);
            }
            return array;
        }
    }
}
