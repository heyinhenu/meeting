package org.meeting.thread;


/**
 * 题目：有三个线程分别打印A、B、C,请用多线程编程实现，在屏幕上循环打印10次ABCABC…
 *
 * 当然还有其他好多种实现，例如：Lock、condition、Semaphore、等
 */
public class SleepExample extends Thread {

    private static int currentCount = 0;

    public SleepExample(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        while (currentCount < 30) {
            switch (currentCount % 3) {
                case 0:
                    if ("A".equals(getName())) {
                        printAndIncrease();
                    }
                    break;
                case 1:
                    if ("B".equals(getName())) {
                        printAndIncrease();
                    }
                    break;
                case 2:
                    if ("C".equals(getName())) {
                        printAndIncrease();
                    }
                    break;
            }
        }
    }

    private void printAndIncrease() {
        print();
        increase();
    }

    private void print() {
        System.out.println(getName());
        if ("C".equals(getName())) {
            System.out.println();
        }
    }

    private void increase() {
        currentCount++;
    }

    public static void main(String[] args) {
        new SleepExample("A").start();
        new SleepExample("B").start();
        new SleepExample("C").start();
    }
}

