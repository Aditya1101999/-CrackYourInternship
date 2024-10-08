package Arrays;

class Solution {
    public int findDuplicate(int[] arr) {
         int i=0;
        while(i<arr.length){
            if(arr[i]!=i+1){
                int correctIndex=arr[i]-1;
                if(arr[i]!=arr[correctIndex]){
                    swap(arr,i,correctIndex);
                }
                else{
                    return arr[i];
                }
            }
            else{
                i++;
            }
        }
        return -1;
    }
    static void swap(int[] arr,int i,int correctIndex){
        int temp=arr[i];
        arr[i]=arr[correctIndex];
        arr[correctIndex]=temp;
    }
}