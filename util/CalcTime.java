package util;

public class CalcTime {
    public static void calcTime(Runnable runnable) {
        long start = System.nanoTime();
        runnable.run();
        long end = System.nanoTime();
        double elapsedTimeInSecond = (double) (end - start) / 1000000000;
        System.out.println(elapsedTimeInSecond + " seconds");
    }
}