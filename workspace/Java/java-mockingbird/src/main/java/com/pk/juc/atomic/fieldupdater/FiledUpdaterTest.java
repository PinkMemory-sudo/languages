package com.pk.juc.atomic.fieldupdater;

import java.util.concurrent.atomic.AtomicReference;

public class FiledUpdaterTest {
    public static void main(String[] args) throws InterruptedException {
        User user = new User();

        for (int i = 0; i < 100; i++) {
            UpgradeTask task = new UpgradeTask(user);
            task.start();
            task.join();
        }
        System.out.println(user.getGrade());
        new AtomicReference<>();
    }
}
