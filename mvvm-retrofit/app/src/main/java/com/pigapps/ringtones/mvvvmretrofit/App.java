package com.pigapps.ringtones.mvvvmretrofit;

import android.app.Application;

import com.pigapps.ringtones.mvvvmretrofit.di.ApiModule;
import com.pigapps.ringtones.mvvvmretrofit.di.ApplicationComponent;
import com.pigapps.ringtones.mvvvmretrofit.di.ApplicationModule;
import com.pigapps.ringtones.mvvvmretrofit.di.DaggerApplicationComponent;

public class App extends Application {

    public static App instance;
    public static ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        component =
                DaggerApplicationComponent
                        .builder()
                        .apiModule(new ApiModule())
                        .applicationModule(new ApplicationModule(this))
                        //.databaseModule(DatabaseModule(this))
                        .build();

        component.inject(this);
    }
}
