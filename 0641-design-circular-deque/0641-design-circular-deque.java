class MyCircularDeque 
{
    int[] dq;
    int front, rear, size, cap;
    public MyCircularDeque(int k) 
    {
        cap = k;
        dq = new int[k];
        front = 0;
        rear = -1;
        size = 0;
    }
    public boolean insertFront(int value) 
    {
        if (isFull())
        {
            return false;
        }
        front = (front - 1 + cap) % cap;
        dq[front] = value;
        size++;
        if (size == 1)
        {
            rear = front;
        }
        return true;
    }
    public boolean insertLast(int value) 
    {
        if (isFull())
        {
            return false;
        }
        rear = (rear + 1) % cap;
        dq[rear] = value;
        size++;
        if (size == 1)
        {
            front = rear;
        }
        return true;
    }
    public boolean deleteFront() 
    {
        if (isEmpty())
        {
            return false;
        }
        front = (front + 1) % cap;
        size--;
        return true;
    }
    public boolean deleteLast() 
    {
        if (isEmpty())
        {
            return false;
        }
        rear = (rear - 1 + cap) % cap;
        size--;
        return true;
    }
    public int getFront() 
    {
        if (isEmpty())
        {
            return -1;
        }
        return dq[front];
    }
    public int getRear() 
    {
        if (isEmpty())
        {
            return -1;
        }
        return dq[rear];
    }
    public boolean isEmpty() 
    {
        return size == 0;
    }
    public boolean isFull() 
    {
        return size == cap;
    }
}