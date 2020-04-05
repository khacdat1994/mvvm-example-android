package com.pigapps.ringtones.mvvvmretrofit.adapter;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pigapps.ringtones.mvvvmretrofit.R;
import com.pigapps.ringtones.mvvvmretrofit.databinding.ViewItemUserBinding;
import com.pigapps.ringtones.mvvvmretrofit.model.User;
import com.pigapps.ringtones.mvvvmretrofit.viewmodel.UserAdapterViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    public interface OnClickItemListenner {
        void onClickItem(User user);
    }

    private ArrayList<User> mValues = new ArrayList<>();
    private OnClickItemListenner listenner;

    public UserAdapter(OnClickItemListenner listenner) {
        this.listenner = listenner;
    }

    public void setUser(List<User> user) {
        mValues.clear();
        mValues.addAll(user);
        //
        Log.d("---", mValues.size() + "");
        //
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //
        ViewItemUserBinding viewItemUserBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.view_item_user, parent, false);
        return new ViewHolder(viewItemUserBinding);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.viewItemUserBinding.getViewModel().setUser(mValues.get(position));

        holder.viewItemUserBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listenner != null) {
                    listenner.onClickItem(mValues.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ViewItemUserBinding viewItemUserBinding;

        public ViewHolder(ViewItemUserBinding _viewItemUserBinding) {
            super(_viewItemUserBinding.getRoot());
            this.viewItemUserBinding = _viewItemUserBinding;
            this.viewItemUserBinding.setViewModel(new UserAdapterViewModel());
        }
    }
}
