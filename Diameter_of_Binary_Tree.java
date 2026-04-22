/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int Diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxHeight(root);
        return Diameter;
    }
    public int maxHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int ld=maxHeight(root.left);
        int rd=maxHeight(root.right);
        Diameter=Math.max(Diameter,ld+rd);
        return 1+Math.max(ld,rd);
    }
}
