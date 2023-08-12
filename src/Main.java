import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎使用“吃货联盟系统”");
        /////////////////////////订餐
        String[] Name = new String[5];
        Name[0] = "张庆";
        Name[1] = "老李";

        ////////订单
        String[] dishmegs = new String[5];
        dishmegs[0] = "红烧带鱼";
        dishmegs[1] = "鱼香肉丝";
        dishmegs[2] = "红烧茄子";
        //菜品编号
        int dishnum = 0;
        //单价
        double[] Prices = new double[5];
        Prices[0] = 20.0;
        Prices[1] = 30.0;
        Prices[2] = 40.0;
        //点赞
        int[] thumbsUp = new int[5];
        thumbsUp[0] = 110;
        thumbsUp[1] = 220;
        thumbsUp[2] = 0;
        thumbsUp[3] = 0;
        thumbsUp[4] = 0;
        //份数
        int[] copies = new int[5];
        copies[0] = 2;
        copies[1] = 3;

        //times
        int[] times = new int[5];
        times[0] = 12;
        times[1] = 10;

        //送餐费
        double meal_delivery_charge = 5;
        //addressses
        String[] addresses = new String[5];
        addresses[0] = "天成路207号";
        addresses[1] = "天成路208号";

        //sum
        double[] sumPrices = new double[5];
        sumPrices[0] = 76.0;
        sumPrices[1] = 88.0;
        //是否预定
        int[] states = new int[5];
        states[0] = 0;
        states[1] = 0;
        ///////////////订单信息
        int index = 1;

        for (; ; ) {
            System.out.println("************************************");
            System.out.println("1.我要订餐");
            System.out.println("2.查看菜单");
            System.out.println("3.签收菜单");
            System.out.println("4.删除菜单");
            System.out.println("5.我要点赞");
            System.out.println("6.退出系统");
            System.out.println("************************************");
            System.out.print("请输入");
            int num = scanner.nextInt();
            ///////////////////////////////////选择
            if (num == 1) {
                System.out.println("***我要订餐***");

                for (int j = 0; j < Name.length; j++) {
                    if (Name[j] == null) {
                        System.out.print("请输入订餐名字");
                        String newName = scanner.next();
                        Name[j] = newName;


                        System.out.println("序号   " + "菜名      " + "单价      " + "点赞数");
                        for (int a = 0; a < dishmegs.length; a++) {
                            if (dishmegs[a] == null) {
                                break;
                            }
                            System.out.println((a + 1) + "    " + dishmegs[a] + " " + Prices[a] + "元        " + thumbsUp[a]);
                        }
                        System.out.print("请输入您要点的菜品编号");
                        dishnum = scanner.nextInt();
                        dishnum--;
                        System.out.print("请输入您要点的份数");
                        copies[j] = scanner.nextInt();


                        System.out.print("请输入送餐时间（送餐时间是10点至20点之间送餐）");
                        times[j] = scanner.nextInt();
                        for (; ; ) {
                            if (times[j] >= 10 && times[j] <= 20) {
                                break;
                            } else {
                                System.out.println("输入错误，重新输入");
                                continue;
                            }
                        }


                        System.out.print("请输入送餐地址");
                        addresses[j] = scanner.next();
                        System.out.println("订餐成功！");
                        System.out.println("您订的是：" + dishmegs[j ] + copies[j] + "份");
                        System.out.println("送餐时间：" + times[j] + "点");
                        sumPrices[j] = (Prices[dishnum - 1] * copies[j]);
                        double delicharge = (sumPrices[j] >= 50) ? 0 : 5;
                        System.out.println("餐费：" + String.format("%.2f", sumPrices[j]) + "元   " + "送餐费 " + delicharge + "总计: " + String.format("%.2f", (sumPrices[j] + delicharge)) + "  折扣 " + String.format("%.2f", delicharge));
                        if (j>5){
                            System.out.println("订单已满");
                            break;
                        }

                        //////////把数据存入orders


                        System.out.print("是否继续：1.继续，2.结束");
                        int ret = scanner.nextInt();
                        if (ret == 1) {
                            continue;
                        } else {
                            break;
                        }
                    }
                }


                System.out.print("输入0返回主界面：");
                int ret = scanner.nextInt();
                if (ret == 0) {
                    continue;
                }

            }
            if (num == 2) {
                System.out.println("***查看菜袋***");
                System.out.println("序号  " + "订餐人   " + "菜品信息    " + "送餐时间  " + "送餐地址    " + "总金额   " + "订单状态");

                for (int b = 0; b < Name.length; b++) {
                    if (Name[b] != null) {
                        String state = (states[b] == 0) ? "已预定" : "已签收";
                        System.out.println((b + 1) + " \t " + Name[b] + "\t  " + dishmegs[b] + copies[b] + "份" + "\t" + times[b] + "点 \t" + addresses[b] + "\t" + sumPrices[b] + "元 \t " + state);
                        if (Name[b] == null) {
                            System.out.print("输入0返回：");
                            int ret = scanner.nextInt();
                            if (ret == 0) {
                                continue;
                            }
                        }
                    }

                }
                System.out.print("输入0返回主界面：");
                int ret = scanner.nextInt();
                if (ret == 0) {
                    continue;
                }

            }
            if (num == 3) {
                System.out.println("***请签收***");


                for (int b = 0; b < Name.length; b++) {
                    if (Name[b] != null) {
                        String state = (states[b] == 0) ? "已预定" : "已签收";
                        System.out.println((b + 1) + " \t " + Name[b] + "\t  " + dishmegs[b] + copies[b] + "\t" + times[b] + "点 \t" + addresses[b] + "\t" + sumPrices[b] + "元 \t " + state);
                        if (Name[b] == null) {
                            break;
                        }
                    }

                }

                for (int c = 0; c < states.length; c++) {
                    System.out.println("请选择签收的订单序号");
                    int singorder = scanner.nextInt();
                    if (singorder != 0) {
                        states[singorder - 1] = 1;
                        System.out.println("订单签收成功");
                        String state = (states[singorder - 1] == 0) ? "已预定" : "已签收";
                        System.out.println((singorder) + " \t " + Name[singorder - 1] + "\t  " + dishmegs[singorder - 1] + "份" + copies[singorder - 1] + "\t" + times[singorder - 1] + "点 \t" + addresses[singorder - 1] + "\t" + sumPrices[singorder - 1] + "元 \t " + state);

                        System.out.print("是否继续：1。继续2.退出");
                        int ret = scanner.nextInt();
                        if (ret == 1) {
                            continue;
                        } else break;
                    }
                }
                System.out.print("输入0返回：");
                int ret = scanner.nextInt();
                if (ret == 0) {
                    continue;
                }
            }
            if (num == 4) {
                System.out.println("***我要删除***");
                System.out.println("名字   菜名    单价  ");
                for (int d = 0; d < Name.length; d++) {
                    if (dishmegs[d] == null) {
                        break;
                    }
                    String state = (states[d] == 0) ? "已预定" : "已签收";
                    System.out.println((d + 1) + "   " + dishmegs[d] + Prices[d] + "元   " + thumbsUp[d] + "  赞     " + state);
                }
                System.out.println("请选择您要删除的订单");
                int serialNumber = scanner.nextInt();
                if (states[serialNumber] >= 0) {
//                    states[serialNumber - 1]++;
                    System.out.println((serialNumber) + "   " + dishmegs[serialNumber - 1] + Prices[serialNumber - 1] + "元   " + thumbsUp[serialNumber - 1] + "  赞");
                    System.out.println("可以删除");
                    Name[serialNumber - 1] = null;
                }


                System.out.print("输入0返回：");
                int ret = scanner.nextInt();
                if (ret == 0) {
                    continue;
                }

            }
            if (num == 5) {
                System.out.println("***我要点赞***");
                System.out.println("序号   菜名    单价  ");
                for (int d = 0; d < Name.length; d++) {
                    if (dishmegs[d] == null) {
                        break;
                    }
                    System.out.println((d + 1) + "   " + dishmegs[d] + Prices[d] + "元   " + thumbsUp[d] + "  赞");

                }
                for (; ; ) {
                    System.out.println("请选择您要点赞的菜品序号");
                    int serialNumber = scanner.nextInt();
                    thumbsUp[serialNumber - 1]++;
                    System.out.println((serialNumber) + "   " + dishmegs[serialNumber - 1] + Prices[serialNumber - 1] + "元   " + thumbsUp[serialNumber - 1] + "  赞");
                    System.out.println("点赞成功");
                    System.out.print("输入0继续1.返回主菜单");
                    int ret = scanner.nextInt();
                    if (ret == 0) {

                        continue;
                    } else break;
                }
            }
            if (num == 6) {
                System.out.println("谢谢使用，欢迎下次光临");
                break;
            }
        }
    }
}