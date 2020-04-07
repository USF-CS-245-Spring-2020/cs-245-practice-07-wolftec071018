public class ArrayQueue<T> implements Queue<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int cap, cur, front, back;
    private T[] arr;

    public ArrayQueue() {
        cap = DEFAULT_CAPACITY;//to keep track on when to grow
        arr = (T[]) new Object[DEFAULT_CAPACITY];//the array
        back = -1;//the tail
        front = 0;//the head 
    }

    public boolean empty() {

        return (cur == 0);

    }

    public T getFront() {
        if(empty()){
            return null;
        }else{
        return arr[front % cap];}
    }

    public T dequeue() throws Exception {
        if (empty())
            throw new Exception("dequeue error");
        T result = getFront();
        arr[front % cap] = null;
        front++;
        cur--;
        return result;
    }

    public void enqueue(T item) {
        if (isFull()) {
            doubleSize();
        }
        back++;
        arr[back % cap] = item;
        cur++;
    }

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