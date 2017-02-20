package com.thirtydaysofcodding.day23.bstlevelordertransversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by abertero on 2/20/17.
 */
public class Solution {

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        levelOrder(root);
    }

    public static void levelOrder(final Node root) {
        Map<Integer, List<Integer>> dataByLevel = new HashMap<Integer, List<Integer>>();
        fillDataByLevel(dataByLevel, root, 0);
        int level = 0;
        List<Integer> datas = new ArrayList<Integer>();
        while (dataByLevel.get(level) != null) {
            datas.addAll(dataByLevel.get(level));
            ++level;
        }
        if (!datas.isEmpty()) {
            System.out.print(datas.get(0));
            for (int i = 1; i < datas.size(); i++) {
                System.out.print(" " + datas.get(i));
            }
        }
    }

    public static void fillDataByLevel(final Map<Integer, List<Integer>> dataByLevel, final Node root, final int currentLevel) {
        if (root != null) {
            if (dataByLevel.get(currentLevel) == null) {
                dataByLevel.put(currentLevel, new ArrayList<Integer>());
            }
            dataByLevel.get(currentLevel).add(root.data);
            if (root.left != null) {
                fillDataByLevel(dataByLevel, root.left, currentLevel + 1);
            }
            if (root.right != null) {
                fillDataByLevel(dataByLevel, root.right, currentLevel + 1);
            }
        }
    }
}
