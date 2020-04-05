package com.pigapps.ringtones.mvvvmretrofit.viewmodel;

import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.pigapps.ringtones.mvvvmretrofit.api.GitHubRepository;
import com.pigapps.ringtones.mvvvmretrofit.adapter.UserAdapter;
import com.pigapps.ringtones.mvvvmretrofit.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel_ extends BaseObservable {
    private GitHubRepository repository;
    private MutableLiveData liveData;

    //public String name = "khacdat1994";

    @Bindable
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
        notifyPropertyChanged(BR.users);
    }

    //private UserAdapter adapter;

    public GitHubRepository getRepository() {
        return repository;
    }

    public void setRepository(GitHubRepository repository) {
        this.repository = repository;
    }

//    public UserAdapter getAdapter() {
//        return adapter;
//    }
//
//    public void setAdapter(UserAdapter adapter) {
//        this.adapter = adapter;
//    }

    public MainViewModel_() {
        if (repository == null) {
            //repository = new GitHubRepository();
        }
    }

    private Observer observe = new Observer<List<User>>() {
        @Override
        public void onChanged(List<User> _users) {
            //
            setUsers(_users);
            //adapter.setUser(users);
            //notifyPropertyChanged(BR.);
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

//    @Override
//    protected void onCleared() {
//        if (liveData != null) {
//            liveData.removeObserver(observe);
//        }
//        super.onCleared();
//    }

    @BindingAdapter({"data"})
    public static void loadData(RecyclerView list, List<User> users) {
        if (list.getAdapter() instanceof UserAdapter) {
            ((UserAdapter) list.getAdapter()).setUser(users);
        }
    }

    //    public LiveData<List<User>> getAllUsers(String name) {
//        return repository.getMutableLiveData(name);
//
//    }
}
