package dataaccess;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SchedulerProvider {
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
    public Scheduler io() {
        return Schedulers.io();
    }
}
