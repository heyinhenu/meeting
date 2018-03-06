package org.meeting.thread;

public class FileWriteUtil {

    private int currentThreadNum = 1;

    /**
     * 记录将字符写入文件的次数
     */
    private int count = 0;

    private int currentFileNum = 1;

    public void write(char value, int threadNum) {
        generateNextFileNum();
        System.out.printf("ThreadNum=%d is executing. %c is written into file file%d.txt \n",
                          currentThreadNum, value, currentFileNum);
        count++;
        currentThreadNum = threadNum;
        generateNextThreadNum();

    }

    public int getCurrentThreadNum() {
        return currentThreadNum;
    }

    public void setCurrentThreadNum(int currentThreadNum) {
        this.currentThreadNum = currentThreadNum;
    }

    private void generateNextFileNum() {
        if (count % 4 == 0) {
            currentFileNum = 1;
        } else {
            currentFileNum++;
        }
    }

    private void generateNextThreadNum() {
        if (count % 4 == 0) {
            if (currentThreadNum < 3) {
                currentThreadNum += 2;
            } else {
                currentThreadNum = (currentThreadNum + 2) % 4;
            }
        } else {
            if (currentThreadNum == 4) {
                currentThreadNum = 1;
            } else {
                currentThreadNum++;
            }
        }
    }

}