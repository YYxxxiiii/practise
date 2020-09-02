package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
* 863. 二叉树中所有距离为 K 的结点

给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。

返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。



示例 1：

输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
输出：[7,4,1]
解释：
所求结点为与目标结点（值为 5）距离为 2 的结点，
值分别为 7，4，以及 1
* */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class DistanceK {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        Map< TreeNode,  TreeNode> familyMap = new HashMap<>();
        map(root,familyMap);
        boolean[] visited = new boolean[500];
        search(target,k,res,visited,familyMap);
        return res;
    }

    private void search( TreeNode target, int k, List<Integer> res, boolean[] visited, Map< TreeNode,  TreeNode> familyMap) {
        if(target == null || k < 0 || visited[target.val]) {
            return;
        }
        if(k == 0 && !visited[target.val]) {
            res.add(target.val);
            visited[target.val] = true;
            return;
        }
        visited[target.val] = true;
        search(target.left,k - 1, res, visited, familyMap);
        search(target.right,k - 1,res,visited,familyMap);
        search(familyMap.get(target),k - 1,res,visited,familyMap);
    }

    private void map( TreeNode root, Map< TreeNode,  TreeNode> familyMap) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            familyMap.put(root.left, root);
        }
        if (root.right != null) {
            familyMap.put(root.right,root);
        }
        map(root.left,familyMap);
        map(root.right,familyMap);

    }

}

