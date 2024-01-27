// push all the values in 1st Stack and maintain the queue in 2nd stack, once the 2nd stack is empty, make it queue by pushing all the elements from stack1 to stack 2
//Time Complexity = O(1) amortized
//Space Complexity = O(2N)
class MyQueue {
    Stack<Integer> stk1 = new Stack<>();
    Stack<Integer> stk2 = new Stack<>();
    public MyQueue() {

    }

    public void push(int x) {
        stk1.push(x);

    }

    public int pop() {
        if(stk2.isEmpty()){
            while(!stk1.isEmpty()){
                stk2.push(stk1.pop());

            }
        }
        return stk2.pop();
    }

    public int peek() {
        if(stk2.isEmpty()){
            while(!stk1.isEmpty()){
                stk2.push(stk1.pop());

            }
        }
        return stk2.peek();
    }

    public boolean empty() {
        return (stk1.isEmpty() && stk2.isEmpty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */