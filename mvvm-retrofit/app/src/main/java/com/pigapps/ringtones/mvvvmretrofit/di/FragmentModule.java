package com.pigapps.ringtones.mvvvmretrofit.di;

import com.pigapps.ringtones.mvvvmretrofit.ui.FirstFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {
    /*
     * We define the name of the Fragment we are going
     * to inject the ViewModelFactory into. i.e. in our case
     * The name of the fragment: MovieListFragment
     */
    @ContributesAndroidInjector
    abstract FirstFragment contriFirstFragment();
}
