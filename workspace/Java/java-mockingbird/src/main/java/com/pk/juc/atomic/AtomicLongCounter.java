package com.pk.juc.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 统计请求中成功的，失败的和总的数量
 * 设计为单例
 */
public class AtomicLongCounter {

    // 请求总数
    private final AtomicLong requestCount = new AtomicLong();
    // 成功总数
    private final AtomicLong successCount = new AtomicLong();
    // 失败总数
    private final AtomicLong failCount = new AtomicLong();

    // 构造方法私有化
    private AtomicLongCounter() {
    }

    // 定义一个私有的本类的静态对象
    private static final AtomicLongCounter INSTANCE = new AtomicLongCounter();

    // 提供一个静态方法来获得该类的唯一实例
    public static AtomicLongCounter getInstance() {
        return INSTANCE;
    }

    // 新请求
    public void newRequest() {
        requestCount.incrementAndGet();
    }

    // 处理成功后
    public void successRequest() {
        successCount.incrementAndGet();
    }

    // 处理失败后
    public void failRequest() {
        failCount.incrementAndGet();
    }

    // 获得总的数量
    public long getTotalCount() {
        return requestCount.get();
    }

    // 获得成功的数量
    public long getSuccessCount() {
        return successCount.get();
    }

    // 获得失败的数量
    public long getFailCount() {
        return failCount.get();
    }
}
