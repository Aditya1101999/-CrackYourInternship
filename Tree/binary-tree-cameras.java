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
    //case 1-> my neighbours are not covered , so i need a camera
    //case 2-> my neighbours have a camera , so i am covered
    //case 3-> my neighbours are covered , so i need cover
    static int count;
    public enum Camera{
        HAS_CAMERA,
        PLEASE_COVER,
        COVERED
    };
    public int minCameraCover(TreeNode root) {
        count=0;
        return solve(root)==Camera.PLEASE_COVER ? count+1 : count;
    }
    private Camera solve(TreeNode root){
        if(root==null){
            return Camera.COVERED;
        }
        Camera left=solve(root.left);
        Camera right=solve(root.right);
        if(left==Camera.PLEASE_COVER || right==Camera.PLEASE_COVER){
            count++;
            return Camera.HAS_CAMERA;
        }
        if(left==Camera.HAS_CAMERA || right==Camera.HAS_CAMERA){
            return Camera.COVERED;
        }
        return Camera.PLEASE_COVER;//both left and right covered
    }
}