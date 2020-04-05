package com.pigapps.ringtones.mvvvmretrofit.di;

import android.app.Application;

import com.pigapps.ringtones.mvvvmretrofit.App;
import com.pigapps.ringtones.mvvvmretrofit.ui.MainActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {
        ApiModule.class,
//        DbModule.class,
        ViewModelModule.class,
        ActivityModule.class,
        FragmentModule.class,
        AndroidSupportInjectionModule.class})
@Singleton
public interface AppComponent {


    /* We will call this builder interface from our custom Application class.
     * This will set our application object to the AppComponent.
     * So inside the AppComponent the application instance is available.
     * So this application instance can be accessed by our modules
     * such as ApiModule when needed
     * */
    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }


    /*
     * This is our custom Application class
     * */
    void inject(App appController);
}
