class Solution {
    public int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) {
            return 0;
        }
        
        Stack<Integer> st = new Stack<Integer>();
        for (String op : ops) {
            if (op.equals("+")) {
                int top = st.pop();
                int newtop = top + st.peek();
                st.push(top);
                st.push(newtop);
            } else if (op.equals("D")) {
                st.push(2 * st.peek());
            } else if (op.equals("C")) {
                st.pop();
            } else {
                st.push(Integer.valueOf(op));
            }
        }
        
        int ans = 0;
        while (!st.isEmpty()) {
            ans += st.pop();
        }
        return ans;
    }
}
