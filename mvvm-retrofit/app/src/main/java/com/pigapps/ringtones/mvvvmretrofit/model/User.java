package com.pigapps.ringtones.mvvvmretrofit.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class User {
    private String name;
    private String full_name;
    private Owner owner;

    public User(String name, String full_name, Owner owner) {
        this.name = name;
        this.full_name = full_name;
        this.owner = owner;
    }

    public User() {
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public static class Owner {
        private String avatar_url;

        public Owner(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public Owner() {
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }
    }
}
