package com.pigapps.ringtones.mvvvmretrofit.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.pigapps.ringtones.mvvvmretrofit.viewmodel.MainViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);


    /*
     * This method basically says
     * inject this object into a Map using the @IntoMap annotation,
     * with the  MovieListViewModel.class as key,
     * and a Provider that will build a MovieListViewModel
     * object.
     *
     * */

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    protected abstract ViewModel mainViewModel(MainViewModel mainViewModel);
}
