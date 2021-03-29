package park;

import java.text.DecimalFormat;
import java.util.Scanner;
import static java.lang.Math.abs;

public class main {
    public static void menu() {
        System.out.println("\n    §※§※§※§※§※§ 欢迎使用停车场系统.§※§※§※§※§※§\t\n");
        System.out.println("\t※◎※◎※◎※◎  1. 车辆到达登记.※◎※◎※◎※◎\t");
        System.out.println("\t※◎※◎※◎※◎  2. 车辆离开登记.※◎※◎※◎※◎\t");
        System.out.println("\t※◎※◎※◎※◎  3. 显示车辆信息.※◎※◎※◎※◎\t");
        System.out.println("\t※◎※◎※◎※◎  4. 退出系统.※◎※◎※◎※◎\t");
        System.out.println("\n\t请选择：\t");
    }

    public static void main(String[] args) throws Exception {
        CarPark carPark = new CarPark();
        Scanner scanner = new Scanner(System.in);
        String carNo;
        while(true) {
            menu();
            int item = -1;
            while (true) {
                item = scanner.nextInt();
                if(item>0 && item <5)
                    break;
                System.out.println("\n 输入有误，请重新选择： 1~4: ");
            }
            switch(item) {
                case 1:
                    System.out.println("请输入车牌号：");
                    carNo = scanner.next();
                    carPark.arrival(carNo);
                    break;
                case 2:
                    System.out.println("请输入车牌号：");
                    carNo = scanner.next();
                    Car car = carPark.leave(carNo);
//                    try {
                        int time = abs(car.depTime-car.arriTime);
                        DecimalFormat df = new DecimalFormat("#.00");
                        Double fee = carPark.charging(car);
                        System.out.println("车辆"+carNo+"停车时长"+time+"分钟，共收费"+fee+"元。");
//                    }catch (NullPointerException e){
//                        System.out.println("便道车辆！");
//                    }

                    break;
                case 3:
                    carPark.showPark();
                    carPark.showWaiting();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

}
