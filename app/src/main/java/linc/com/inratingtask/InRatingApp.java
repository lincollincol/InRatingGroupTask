package linc.com.inratingtask;

import android.app.Application;

import linc.com.inratingtask.di.AppComponent;
import linc.com.inratingtask.di.DaggerAppComponent;

public class InRatingApp extends Application {

    private static InRatingApp instance;
    public AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initDaggerAppComponent();
    }

    public static InRatingApp getInstance() {
        return instance;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    private void initDaggerAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .build();
    }

}
