package Arrays;

class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        if(n==0||n==1){
            return n;
        }
        int j=1;
        for(int i=1;i<n;i++){
            if(nums[i-1]!=nums[i]){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }
}
