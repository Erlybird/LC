//Time Complexity = O(N)
//Space Complexity = O(N)
//Method : put all in the stack and whenever an operator comes across, pop two elements and equate with the operator and push it back to the stack.
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        HashSet<String> set = new HashSet<>();

        set.add("+");set.add("-");set.add("*");set.add("/");

        for(int i =0; i< tokens.length; i++){
            String s = tokens[i];
            if(!set.contains(tokens[i])){
                int k = Integer.parseInt(tokens[i]);
                stk.push(k);
            }else{
                String z = tokens[i];
                int second = stk.pop();
                int first = stk.pop();

                if(z.equals("+"))stk.push(first + second);
                else if (z.equals("-"))stk.push(first - second);
                else if ( z.equals("/"))stk.push(first/second);
                else if(z.equals("*"))stk.push(first*second);
            }
        }

        return stk.pop();
    }
}