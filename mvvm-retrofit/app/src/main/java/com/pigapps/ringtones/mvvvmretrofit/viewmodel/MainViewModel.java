package com.pigapps.ringtones.mvvvmretrofit.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.pigapps.ringtones.mvvvmretrofit.adapter.UserAdapter;
import com.pigapps.ringtones.mvvvmretrofit.api.GitHubRepository;
import com.pigapps.ringtones.mvvvmretrofit.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {
    private GitHubRepository repository;
    private MutableLiveData liveData;

    private UserAdapter adapter;

    public GitHubRepository getRepository() {
        return repository;
    }

    public void setRepository(GitHubRepository repository) {
        this.repository = repository;
    }

    public UserAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(UserAdapter adapter) {
        this.adapter = adapter;
    }

    public MainViewModel() {
        if (repository == null) {
            repository = new GitHubRepository();
        }
    }

    private Observer observe = new Observer<List<User>>() {
        @Override
        public void onChanged(List<User> _users) {
            //
            adapter.setUser(_users);
        }
    };

    private void getAllUsers(String name) {
        liveData = repository.getListUsers(name);
        liveData.observeForever(observe);
    }

    public void listUsers(String name) {
        liveData = repository.getListUsers(name);
        liveData.observeForever(observe);
    }

    @Override
    protected void onCleared() {
        if (liveData != null) {
            liveData.removeObserver(observe);
        }
        super.onCleared();
    }

//    @BindingAdapter({"data"})
//    public static void loadData(RecyclerView list, List<User> users) {
//        if (list.getAdapter() instanceof UserAdapter) {
//            ((UserAdapter) list.getAdapter()).setUser(users);
//        }
//    }

    //    public LiveData<List<User>> getAllUsers(String name) {
//        return repository.getMutableLiveData(name);
//
//    }
}
