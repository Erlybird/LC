// Time complexity
// for enque: O(1), dequeue: O(1), front,rear ,isEmpty, isFull all are O(1)
// space complesity : O(N)
class MyCircularQueue {

    int[] queue;
    int capacity;
    int head =0;
    int count =0;

    public MyCircularQueue(int k) {
        capacity = k;
        queue = new int[k];
    }

    public boolean enQueue(int value) {
        if(count != capacity){
            queue[((head % capacity) + count) % capacity] = value;
            // head++;
            count++;
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if(count == 0) return false;
        else{
            head = (head % capacity) + 1;
            count--;
            return true;
        }

    }

    public int Front() {
        if(count != 0) return queue[head % capacity];
        else return -1;
    }

    public int Rear() {
        if(count != 0) return queue[((head % capacity) + count -1) % capacity];
        else return -1;

    }

    public boolean isEmpty() {
        if(count ==0) return true;
        else return false;

    }

    public boolean isFull() {
        if(count == capacity) return true;
        else return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */