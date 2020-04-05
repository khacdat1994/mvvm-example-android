package com.pigapps.ringtones.mvvvmretrofit.di;

import android.app.Application;
import android.content.Context;

import com.pigapps.ringtones.mvvvmretrofit.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private App app;

    public ApplicationModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Application provideApp() {
        return app;
    }

    @Provides
    @Singleton
    Context getContext() {
        return app;
    }
}
