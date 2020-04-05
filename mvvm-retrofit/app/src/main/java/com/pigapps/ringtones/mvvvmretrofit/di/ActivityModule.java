package com.pigapps.ringtones.mvvvmretrofit.di;

import com.pigapps.ringtones.mvvvmretrofit.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract MainActivity contributeMainActivity();
}
