package com.pk.juc.atomic.fieldupdater;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class UpgradeTask extends Thread {
    private User user;
    private AtomicIntegerFieldUpdater<User> gradeUpdater = AtomicIntegerFieldUpdater.newUpdater(User.class, "grade");

    UpgradeTask(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        gradeUpdater.getAndIncrement(user);
    }
}
