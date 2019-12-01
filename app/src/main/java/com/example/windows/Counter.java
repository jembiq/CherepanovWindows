package com.example.windows;

public class Counter {
    private static int count = 1;

    public Counter(int count) {
        this.count = count;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int c) {
        count = c;
    }

    public static void raiseCount() {
        count += 1;
    }

    public static void reduceCount() {
        count -= 1;
    }
}
