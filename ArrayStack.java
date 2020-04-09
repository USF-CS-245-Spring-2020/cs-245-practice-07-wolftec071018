
public class ArrayStack<T> implements Stack<T> {

    private T[] arr;//the array
    private int size;//size of the array

    public ArrayStack() {
        //set size to be 10
        arr = (T[]) new Object[10];
        size = 0;

    }

    private void growArray() {
        T[] tempArr = (T[]) new Object[2 * arr.length];//grows if needed
        for (int i = 0; i < arr.length; i++)//copy the items in the array over
            tempArr[i] = arr[i];
        arr = tempArr;//set the new array
    }
    //check if its full, if not add item into stack
    public void push(T item) {
        if (isFull()) {
            growArray();
            arr[size++] = item;
        } else {
            arr[size++] = item;
        }

    }
    //check if empty, if not get rid of the last item
    public T pop() throws Exception {
        if (empty()) {
            throw new Exception("empty pop");
        } else {

            T result = arr[--size];

            return result;

        }
    }
    //check if empty, than return array
    public T peek() throws Exception {
        if (empty()) {
            throw new Exception("empty peek");
        } else {
            T x = arr[size--];
            return x;
        }
    }
    //check if the size==array length
    public boolean isFull() {
        if (size == arr.length)
            return true;

        return false;
    }
    //when size is 0 than its empty.
    public boolean empty() {
        return (size == 0);
    }

}