package com.pigapps.ringtones.mvvvmretrofit.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pigapps.ringtones.mvvvmretrofit.App;
import com.pigapps.ringtones.mvvvmretrofit.R;
import com.pigapps.ringtones.mvvvmretrofit.adapter.UserAdapter;
import com.pigapps.ringtones.mvvvmretrofit.databinding.FragmentFirstBinding;
import com.pigapps.ringtones.mvvvmretrofit.di.ViewModelFactory;
import com.pigapps.ringtones.mvvvmretrofit.model.User;
import com.pigapps.ringtones.mvvvmretrofit.viewmodel.MainViewModel;

import javax.inject.Inject;

public class FirstFragment extends Fragment implements UserAdapter.OnClickItemListenner {

    @Inject
    MainViewModel mainViewModel;
    private RecyclerView recyclerView;
    private UserAdapter adapter;

    //@Inject
    //ViewModelFactory viewModelFactory;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        FragmentFirstBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false);
        //
        recyclerView = binding.list;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);

        binding.setViewModel(mainViewModel);
        //
        adapter = new UserAdapter(this);
        mainViewModel.setAdapter(adapter);
        mainViewModel.listUsers("octocat");
        //
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.component.inject(this);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
//            }
//        });
    }

    @Override
    public void onClickItem(User user) {

    }
}
