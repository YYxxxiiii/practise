package interviewTree;


/*
*
* 572. 另一个树的子树
给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。

示例 1:
给定的树 s:

     3
    / \
   4   5
  / \
 1   2
给定的树 t：

   4
  / \
 1   2
返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。

示例 2:
给定的树 s：

     3
    / \
   4   5
  / \
 1   2
    /
   0
给定的树 t：

   4
  / \
 1   2
返回 false。*/
public class IsSubTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        boolean ret = false;
        if (s.val == t.val) {
            ret = isSameTree(s,t);
        }
        return ret || isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 可以分成四种情况:
        // 1. p q 都为 null
        // 2. p 为 null, q 不为 null
        // 3. p 不为 null, q 为 null
        // 4. p q 都不为 null
        if (q == null && p == null) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        //情况四
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
