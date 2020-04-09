public class ArrayQueue<T> implements Queue<T> {
    private static final int DEFAULT_CAPACITY = 10;// starting size
    private int cap, cur, front, back;// to keep track
    private T[] arr;// the array

    public ArrayQueue() {
        cap = DEFAULT_CAPACITY;//to keep track on when to grow
        arr = (T[]) new Object[DEFAULT_CAPACITY];//the array
        back = -1;//the tail
        front = 0;//the head 
    }
    //if the pointer is 0 than its empty
    public boolean empty() {

        return (cur == 0);

    }
    // update the 1st in line after to keep array a good size
    public T getFront() {
        if(empty()){
            return null;
        }else{
        return arr[front % cap];}
    }
    //makes sure that its not empty than saves the 1st in line makes it empty and moves the front up one index than the pointer back one index
    public T dequeue() throws Exception {
        if (empty())
            throw new Exception("dequeue error");
        T result = getFront();
        arr[front % cap] = null;
        front++;
        cur--;
        return result;
    }
    //
    public void enqueue(T item) {
        if (isFull()) {
            doubleSize();
        }
        back++;
        arr[back % cap] = item;
        cur++;
    }
    //makes a temp array 2x size, copy, old array into the new one. than set the old to be the new array
    private void doubleSize() {
        T[] newArray = (T[]) new Object[2 * cap];

        for (int i = front; i <= back; i++) {
            newArray[i - front] = arr[i % cap];
        }
        arr = newArray;
        front = 0;
        back = cur - 1;
        cap *= 2;
    }

    public boolean isFull() {
        return cur == cap;
    }

}