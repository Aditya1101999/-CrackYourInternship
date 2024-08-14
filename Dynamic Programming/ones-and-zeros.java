class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] freq=new int[strs.length][2];
        for(int i=0;i<strs.length;i++){
            freq[i]=getFreq(strs[i]);
        }
        int[][][] dp=new int[strs.length][m+1][n+1];
        for(int[][] row : dp){
            for(int[] col : row){
                Arrays.fill(col,-1);
            }
        }
        return solve(freq,0,m,n,dp);
    }
    private int solve(int[][] freq,int index,int m,int n,int[][][] dp){
        if(index==freq.length) return 0;
        
        if(dp[index][m][n]!=-1) return dp[index][m][n];
        
        int include=0;
        if(m>=freq[index][0] && n>=freq[index][1]){
            include=1+solve(freq,index+1,m-freq[index][0], n-freq[index][1],dp);
        }
        int exclude=solve(freq,index+1,m,n,dp);
        return dp[index][m][n]=Math.max(include,exclude);
    }
    private int[] getFreq(String str){
        int[] freq=new int[2];
        for(char c : str.toCharArray()){
            if(c=='0') freq[0]++;
            else freq[1]++;
        }
        return freq;
    }
}