package com.pigapps.ringtones.mvvvmretrofit.di;

import android.app.Application;

import com.pigapps.ringtones.mvvvmretrofit.App;
import com.pigapps.ringtones.mvvvmretrofit.ui.FirstFragment;
import com.pigapps.ringtones.mvvvmretrofit.ui.MainActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {
        ApiModule.class,
//        DbModule.class,
        ApplicationModule.class,
        ViewModelModule.class})
@Singleton
public interface ApplicationComponent {

    void inject(App app);

    void inject(MainActivity activity);

    void inject(FirstFragment fragment);
}
