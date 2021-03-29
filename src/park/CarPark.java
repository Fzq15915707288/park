package park;

import sun.util.resources.CalendarData_nl;

import java.text.DecimalFormat;
import java.util.GregorianCalendar;
import java.util.Random;
import static java.lang.Math.abs;

/**
 * 功能： 将carNo车牌的汽车驶入，如果停车场有车位则进入停车场，设定入场时间，否则在便道等待进入
 * 参数：
 * carNo -- 车牌信息
 * 返回值：
 */
public class CarPark {

    private CarStack s = new CarStack(3);
    private CarQueue q = new CarQueue();
    private double fee = 2;
    public final static int departure = 0;
    public final static int arrival = 1;

    public void arrival(String carNo) throws Exception {
        Random random=new Random();
        // 参考相关业务流程，完成该函数模块的编码任务。
        Car car = new Car();
        car.CarNo = carNo;
        if (s.length() < 3) {
            car.arriTime = random.nextInt(24);
            car.state = arrival;
            s.push(car);
            System.out.println(car.CarNo + "停在停车场第" + s.length() + "个位置!");
        } else {
            q.offer(car);
            System.out.println(car.CarNo + "停在便道第" + q.length());
        }
    }

    /**
     * 功能： 将carNo车牌的汽车驶离停车场，设定离开时间，同时便道汽车进入停车场
     * 参数：
     * carNo -- 车牌信息
     * 返回值：离开汽车
     */
    public Car leave(String carNo) throws Exception {
        Random random=new Random();
        if (s.length() == 0) {//如果按错了2就报错
            throw new Exception("停车场内无车，输入有误!");
        }

        Car car = null;
//        int location = 0;
        CarStack s2 = new CarStack(s.length());
        for (int i = s.length(); i > 0; i--) {
            car = (Car) s.pop();
            if (car.CarNo.equals(carNo)) {
                car.depTime = random.nextInt(24);
                car.state = departure;
//                location = i;
                break;
            } else {
                s2.push(car);
            }
        }
        while (!s2.isEmpty()) {
            s.push(s2.pop());
        }

        //便道离开
        CarQueue q2 = new CarQueue();//辅助队列
        while (!q.isEmpty()) {
            car = (Car) q.poll();//从便道中推出进行检验

            if (car.CarNo.equals(carNo)) {//如果输入的车牌号码是便道上的。
                System.out.println(car.CarNo + "出队列，不收费" + " ");
            } else {//不是目标车辆，放在辅助队列中。
                q2.offer(car);
            }
        }
        while (!q2.isEmpty()) {
            car = q2.poll();
            q.offer(car);
        }


        return car;
    }

    /**
     * 功能： 根据车辆的出入时间，计算费用及停车时长
     * 参数：
     * car -- 车辆信息
     * 返回值：停车费用
     */
    public double charging(Car car) {
        int offset = abs(car.depTime - car.arriTime);
        long price = 10;
        return offset * price;
    }

    // 显示所有入库车辆信息
    public void showPark() {
        s.display();
    }

    // 显示所有在便道上等待信息
    public void showWaiting() {
        q.display();
    }
}