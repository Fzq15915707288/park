package park;

public class CarStack {
    public static int MAXSIZE = 3;
    Car CarStack[] = new Car[MAXSIZE + 1];
    int top;
    int base;

    public CarStack(int i) {
        top = 0;
        CarStack = new Car[MAXSIZE];
    }

    //置空
    public void clear() {
        top = 0;
    }

    //判断是否为空
    public boolean isEmpty() {

        return top == 0;
    }

    //求个数
    public int length() {

        return top;
    }

    //进栈
    public void push(Car car) throws Exception {
        if (top == CarStack.length) {
            throw new Exception("栈已满");
        } else {
            CarStack[top++] = car;
        }
    }

    //出栈
    public Car pop() {
        if (isEmpty()) {
            return null;
        } else {
            return CarStack[--top];
        }
    }

    //显示
    public void display() {
        for(int i=top-1;i>=0;i--){
            System.out.println(CarStack[i].CarNo+"在停车场第"+i+"位置");
        }

    }
}

