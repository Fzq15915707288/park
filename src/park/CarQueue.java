package park;


public class CarQueue {

    private CarNode front;
    private CarNode rear;

    public CarQueue() {
        front = rear = null;
    }

    //置空
    public void clear() {
        front = rear = null;
    }

    //判空
    public boolean isEmpty() {
        return front == null;
    }

    //入队
    public void offer(Car car) {
        CarNode p = new CarNode(car);
        if (front != null) {
            rear.next = p;
            rear = p;
        } else
            front = rear = p;

    }

    //求长度
    public int length() {
        CarNode p = front;
        int length = 0;
        while (p != null) {
            p = p.next;
            ++length;
        }
        return length;
    }

    //出队
    public Car poll() {
        if (front != null) {
            CarNode p = front;
            front = front.next;
            if (p == rear)
                rear = null;
            return p.data;
        } else
            return null;

    }

    //展示
    public void display() {
        if (!isEmpty()) {
            CarNode p = front;
            int i = 0;
            while (p != null) {
                System.out.println(p.data.CarNo + "在便道第" + i + "位置");
                i++;
                p = p.next;
            }
        } else {
            System.out.println("此队列为空!");

        }
    }

}
