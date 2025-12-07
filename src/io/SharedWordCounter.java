package io;

public class SharedWordCounter {
    private int count = 0;

    public synchronized void increment(int value) {
        count += value;
    }

    public synchronized int getCount() {
        return count;
    }
}
