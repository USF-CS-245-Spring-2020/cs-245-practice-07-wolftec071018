
public class ArrayStack<T> implements Stack<T> {

    private T[] arr;
    private int size;

    public ArrayStack() {

        arr = (T[]) new Object[10];
        size = 0;

    }

    private void growArray() {
        T[] tempArr = (T[]) new Object[2 * arr.length];
        for (int i = 0; i < arr.length; i++)
            tempArr[i] = arr[i];
        arr = tempArr;
    }

    public void push(T item) {
        if (isFull()) {
            growArray();
            arr[size++] = item;
        } else {
            arr[size++] = item;
        }

    }

    public T pop() throws Exception {
        if (empty()) {
            throw new Exception("empty pop");
        } else {

            T result = arr[--size];

            return result;

        }
    }

    public T peek() throws Exception {
        if (empty()) {
            throw new Exception("empty peek");
        } else {
            T x = arr[size--];
            return x;
        }
    }

    public boolean isFull() {
        if (size == arr.length)
            return true;

        return false;
    }

    public boolean empty() {
        return (size == 0);
    }

}