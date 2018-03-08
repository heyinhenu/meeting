package org.meeting.radix;

public class RadixConvert {

    public static void toBinary() {
        int a = 123;//定义一个变量并赋给他一个十进制的值
        int remainder;//定义一个变量用于存储余数
        int sum = 0;//定义一个变量用于存放和
        int k = 1;//定义一个变量控制位数
        while (a != 0) {
            remainder = a % 2;//对目标数字求余
            a /= 2;//对目标数字求商
            sum = sum + remainder * k;//求和
            k *= 10;//改变位数

        }
        System.out.println("10进制的123转换为2进制结果为：" + sum);
    }


    //递归函数
    public static void toBinary(int num) {
        int r;
        r = num % 2;//最后一位要输出的，即使参数=1，还是要计算到这里结束，只取出余数就ok了。然后顺次返回上一级主调函数，继续执行剩下的……
        //如果商 1 / 2 = 0，计算就可以终止了，不需要再算
        if (num >= 2) {

            //精华，联系10进制转2进制的算法，每次除以2，取出余数，然后用新的商继续除以2，取出新余数……直到商为0，余数逆序输出即可

            toBinary(num / 2);//把新的商作为参数递归调用
        }
        //在递归语句之后输出，这样就是倒叙输出
        System.out.print(r);

    }
}
