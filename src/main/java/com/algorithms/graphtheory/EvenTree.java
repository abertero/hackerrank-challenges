package com.algorithms.graphtheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvenTree {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int t = scn.nextInt();
        TreeFactory factory = new TreeFactory(n);
        for (int i = 0; i < t; i++) {
            int a = scn.nextInt();
            int b = scn.nextInt();
            factory.addNode(a, b);
        }
        Tree root = factory.getRoot();
        System.out.println(findMaxEvenTree(root));
        scn.close();
    }

    private static int findMaxEvenTree(Tree root) {
        int cuts = 0;
        for (Tree child : root.childs) {
            int nodeCount = child.nodeCount();
            if (nodeCount == 2) {
                ++cuts;
            } else if (nodeCount % 2 == 0) {
                cuts += 1 + findMaxEvenTree(child);
            } else {
                cuts += findMaxEvenTree(child);
            }
        }
        return cuts;
    }

    static class TreeFactory {
        Tree[] trees;

        TreeFactory(int n) {
            trees = new Tree[n];
            for (int i = 0; i < n; i++) {
                trees[i] = new Tree(i + 1);
            }
        }

        void addNode(int a, int b) {
            int parentIdx = Math.min(a, b) - 1;
            int childIdx = Math.max(a, b) - 1;
            trees[parentIdx].childs.add(trees[childIdx]);
        }

        Tree getRoot() {
            return trees[0];
        }
    }

    static class Tree {
        int id;
        List<Tree> childs = new ArrayList<>();

        Tree(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return String.format("Tree {id: %s, nodeCount: %s, childs: %s}", id, nodeCount(), childs);
        }

        int nodeCount() {
            int result = 1;
            for (Tree child : childs) {
                result += child.nodeCount();
            }
            return result;
        }
    }
}
