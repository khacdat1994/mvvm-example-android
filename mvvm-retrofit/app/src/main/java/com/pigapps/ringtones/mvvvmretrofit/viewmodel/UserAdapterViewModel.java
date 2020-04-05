package com.pigapps.ringtones.mvvvmretrofit.viewmodel;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.ViewModel;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.pigapps.ringtones.mvvvmretrofit.model.User;

public class UserAdapterViewModel extends ViewModel {

    private User user;

    public UserAdapterViewModel() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // important code for loading image here
    @BindingAdapter({"avatar"})
    public static void loadAvatar(ImageView imageView, String imageURL) {
        Glide.with(imageView.getContext())
                .setDefaultRequestOptions(new RequestOptions()
                        .circleCrop())
                .load(imageURL)
                //.placeholder(R.drawable.loading)
                .into(imageView);
    }

//    @BindingAdapter({"data"})
//    public static void loadData(RecyclerView list, ArrayList<User> users) {
//        if (list.getAdapter() instanceof UserAdapter) {
//            ((UserAdapter) list.getAdapter()).setUser(users);
//        }
//    }
}
