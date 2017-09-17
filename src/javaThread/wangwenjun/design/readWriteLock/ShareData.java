package javaThread.wangwenjun.design.readWriteLock;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/8/28 0028 16:58
 */
public class ShareData {

    private final char[] buffer;
    
    private final ReadWriteLock lock = new ReadWriteLock();

    public ShareData(int size) {
        this.buffer = new char[size];

        for (int i = 0; i < size; i++) {
            buffer[i] = '*';
        }
    }

    public char[] read() throws InterruptedException {

        try {
            lock.readLock();
            return doRead();
        } finally {

            lock.readUnlock();
        }
    }

    public void write(char c) throws InterruptedException {

        try {
            lock.writeLock();
            this.doWrite(c);
        } finally {
            lock.writeUnlock();
        }

    }

    private void doWrite(char c) {

        for (int i = 0; i < buffer.length; i++) {

            buffer[i] = c;
        }
    }

    private char[] doRead() throws InterruptedException {

        char[] newBuffer = new char[buffer.length];

        for (int i = 0; i < newBuffer.length; i++) {

            newBuffer[i] = buffer[i];
        }

        slowly(50);
        return  newBuffer;
    }

    private void slowly(int i) throws InterruptedException {

        Thread.sleep(i);
    }
}
