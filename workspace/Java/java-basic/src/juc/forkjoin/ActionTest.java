package juc.forkjoin;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * 求start-end的和
 */
public class ActionTest extends RecursiveTask<Integer> {

    private int start;
    private int end;
    private int taskSize;

    public ActionTest(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /**
     * compute实现两个功能：任务的切分和计算
     */
    @Override
    protected Integer compute() {
        if ((end - start) > 1) {
            int mid = (end + start) / 2;
            ActionTest left = new ActionTest(start, mid);
            ActionTest right = new ActionTest(mid + 1, end);
            left.fork();
            right.fork();
            return left.join() + right.join();
        } else {
            // 计算时注意start==end的情况
            return getSum();
        }
    }

    private int getSum() {
        if (start == end) {
            return start;
        } else {
            return start + end;
        }
    }
}
