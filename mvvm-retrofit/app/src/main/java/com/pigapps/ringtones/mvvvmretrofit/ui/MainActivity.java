package com.pigapps.ringtones.mvvvmretrofit.ui;

import android.os.Bundle;

import com.pigapps.ringtones.mvvvmretrofit.R;
import com.pigapps.ringtones.mvvvmretrofit.databinding.ActivityMainBinding;
import com.pigapps.ringtones.mvvvmretrofit.adapter.UserAdapter;
import com.pigapps.ringtones.mvvvmretrofit.viewmodel.MainViewModel;
import com.pigapps.ringtones.mvvvmretrofit.viewmodel.MainViewModel2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private UserAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ActivityMainBinding activityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);
        // bind RecyclerView
        recyclerView = activityMainBinding.list;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setHasFixedSize(true);
        //
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        //mainViewModel = new MainViewModel2();
        activityMainBinding.setViewModel(mainViewModel);
        //
        adapter = new UserAdapter();
        mainViewModel.setAdapter(adapter);
        mainViewModel.listUsers("octocat");
        //mainViewModel.setAdapter(adapter);
        //mainViewModel.getAllUsers("octocat");


        //getData("octocat");


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getData("khacdat1994");
                //mainViewModel.getAllUsers("khacdat1994");
                mainViewModel.listUsers("khacdat1994");
            }
        });
    }

//    private void getData(String name) {
//        mainViewModel.getAllUsers(name).observe(this, new Observer<List<User>>() {
//            @Override
//            public void onChanged(List<User> users) {
//                adapter.setUser(users);
//            }
//        });
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
