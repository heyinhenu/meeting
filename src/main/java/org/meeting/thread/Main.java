package org.meeting.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class Main {

    public static void main(String[] args) {
        FileWriteUtil util = new FileWriteUtil();

        ExecutorService service = Executors.newCachedThreadPool();

        service.execute( new WriteRunnable(util, 1 , 'A' ));
        service.execute( new WriteRunnable(util, 2 , 'B' ));
        service.execute( new WriteRunnable(util, 3 , 'C' ));
        service.execute( new WriteRunnable(util, 4 , 'D' ));

        service.shutdown();
    }
}
