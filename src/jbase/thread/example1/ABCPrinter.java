package jbase.thread.example1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/6/7 0007 15:23
 */
public class ABCPrinter {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Aprinter aprinter = new Aprinter(printer);
        Bprinter bprinter = new Bprinter(printer);
        Cprinter cprinter = new Cprinter(printer);
        aprinter.start();
        bprinter.start();
        cprinter.start();
    }
}

class Printer {
    int a = 5, b = 0, c = 0;
    Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();

    public void printA() throws InterruptedException {
        for (int i = 0; i < 5; i++) Aprinter();
    }

    public void Aprinter() throws InterruptedException {
        lock.lock();
        if (a == 0) {
            conditionA.await();
        }
        System.out.print("A");
        a--;
        if (a == 0) b += 10;
        if (a == 0) {
            conditionB.signal();
        }
        lock.unlock();
    }

    public void printB() throws InterruptedException {
        for (int i = 0; i < 10; i++) Bprinter();
    }

    public void Bprinter() throws InterruptedException {
        lock.lock();
        if (b == 0) {
            conditionB.await();
        }
        System.out.print("B");
        b--;
        if (b == 0) c += 15;
        if (b == 0) {
            conditionC.signal();
        }
        lock.unlock();
    }

    public void printC() throws InterruptedException {
        for (int i = 0; i < 15; i++) Cprinter();
    }

    public void Cprinter() throws InterruptedException {
        lock.lock();
        if (c == 0) {
            conditionC.await();
        }
        System.out.print("C");
        c--;
        if (c == 0) a += 5;
        if (c == 0) {
            conditionA.signal();
        }
        lock.unlock();
    }
}

class Aprinter extends Thread {
    Printer printer = new Printer();

    public Aprinter(Printer printer) {
        this.printer = printer;
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                printer.printA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" ");
        }
    }
}

class Bprinter extends Thread {
    Printer printer = new Printer();

    public Bprinter(Printer printer) {
        this.printer = printer;
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                printer.printB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" ");
        }
    }
}

class Cprinter extends Thread {
    Printer printer = new Printer();

    public Cprinter(Printer printer) {
        this.printer = printer;
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                printer.printC();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" ");
        }
    }
}
