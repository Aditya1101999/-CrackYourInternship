class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st=new Stack<>();
        for(String el:tokens){
            if(el.equals("+")||el.equals("-")||el.equals("*")||el.equals("/")){
                int ans=0;
                int el2=Integer.parseInt(st.pop());
                int el1=Integer.parseInt(st.pop());
                if(el.equals("+")){
                    ans=el1+el2;
                }
                else if(el.equals("-")){
                    ans=el1-el2;
                }
                 else if(el.equals("*")){
                    ans=el1*el2;
                 }
                 else if(el.equals("/")){
                    ans=el1/el2;
                 }
                st.push(ans+"");
            }
            else{
                st.push(el);
            }
        }
        return Integer.parseInt(st.peek());
    }
}