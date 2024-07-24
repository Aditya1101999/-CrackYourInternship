package Arrays;

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int initialPoints=0;
        for(int i=0;i<k;i++){
            initialPoints+=cardPoints[i];
        }
        int n=cardPoints.length;
        int maxPoints=initialPoints;
        int right=n-1;
        for(int i=k-1;i>=0;i--){
            initialPoints+=cardPoints[right]-cardPoints[i];
            maxPoints=Math.max(maxPoints,initialPoints);
            right--;
        }
        return maxPoints;
    }
}