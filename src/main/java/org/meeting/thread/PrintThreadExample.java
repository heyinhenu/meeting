package org.meeting.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintThreadExample {

    public static void main(String[] args) {
        LetterPrinter letterPrinter = new LetterPrinter();
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(new PrintRunnable(letterPrinter, 'A'));
        service.execute(new PrintRunnable(letterPrinter, 'B'));
        service.execute(new PrintRunnable(letterPrinter, 'C'));
        service.shutdown();
    }
}

class LetterPrinter {
    private char letter = 'A';

    public void print() {
        System.out.println(letter);
        if ('C' == letter) {
            System.out.println();
        }
    }

    public void nextLetter() {
        switch (letter) {
            case 'A':
                letter = 'B';
                break;
            case 'B':
                letter = 'C';
                break;
            case 'C':
                letter = 'A';
                break;
        }
    }

    public char getLetter() {
        return letter;
    }
}


class PrintRunnable implements Runnable {
    private LetterPrinter letterPrinter = null;
    private char letter = ' ';

    public PrintRunnable(LetterPrinter letterPrinter, char letter) {
        super();
        this.letterPrinter = letterPrinter;
        this.letter = letter;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (letterPrinter) {
                while (letter != letterPrinter.getLetter()) {
                    try {
                        letterPrinter.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                letterPrinter.print();
                letterPrinter.nextLetter();
                letterPrinter.notifyAll();
            }
        }
    }
}