package juc.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class MainT {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ActionTest actionTest = new ActionTest(0, 10);
        long start = System.currentTimeMillis();
        ForkJoinTask<Integer> submit = forkJoinPool.submit(actionTest);
        System.out.println(submit.invoke());
        System.out.println("cost: "+(System.currentTimeMillis()-start));

    }
}
