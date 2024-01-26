//boolean arrays, the default value is false, but the array itself is initialized to null until you explicitly create the array and assign it a reference.
// Time complexity = O(1)
// Space complexity = O(1)// constant 10^6
class MyHashSet {
    private boolean[][] arr;
    private static final int H1_Helper =1000;
    private static final int H2_Helper = 1000;

    public MyHashSet() {
        arr = new boolean[H1_Helper][];
        //initialzing with the number of rows
        // arr[i][j] represents an array with ith row and jth column
    }

    private int getHash1(int key){
        return key % H1_Helper;
    }
    private int getHash2(int key){
        return key / H2_Helper;
    }

    public void add(int key) {
        if(!contains(key)){
            int hash1 = getHash1(key);
            if(arr[hash1]==null){
                if(hash1 == 0){
                    arr[hash1] = new boolean [H1_Helper +1]; // initializes with 1001 columns for the 1st row
                }
                else arr[hash1] = new boolean[H1_Helper];// other rows are initialized with 1000 columns when need arises
            }
            int hash2 = getHash2(key);
            arr[hash1][hash2] =  true;
        }

    }

    public void remove(int key) {
        if(contains(key)){
            int hash1 = getHash1(key);
            int hash2 = getHash2(key);
            arr[hash1][hash2] = false;
        }

    }

    public boolean contains(int key) {
        int hash1 = getHash1(key);
        if(arr[hash1] == null){
            return false;
        }
        int hash2 = getHash2(key);
        return arr[hash1][hash2];

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */