package database.example.com.simplerecyclermvvm.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import java.util.Observable;
import java.util.Observer;

import database.example.com.simplerecyclermvvm.R;
import database.example.com.simplerecyclermvvm.databinding.ActivityMainBinding;
import database.example.com.simplerecyclermvvm.viewmodel.UserViewModel;

/**
 * * ============================================================================
 * * Copyright (C) 2018 W3 Engineers Ltd - All Rights Reserved.
 * * Unauthorized copying of this file, via any medium is strictly prohibited
 * * Proprietary and confidential
 * * ----------------------------------------------------------------------------
 * * Created by: Mimo Saha on [31-Jul-2018 at 6:21 PM].
 * * Email: mimosaha@w3engineers.com
 * * ----------------------------------------------------------------------------
 * * Project: SimpleRecyclerMvvm.
 * * Code Responsibility: <Purpose of code>
 * * ----------------------------------------------------------------------------
 * * Edited by :
 * * --> <First Editor> on [31-Jul-2018 at 6:21 PM].
 * * --> <Second Editor> on [31-Jul-2018 at 6:21 PM].
 * * ----------------------------------------------------------------------------
 * * Reviewed by :
 * * --> <First Reviewer> on [31-Jul-2018 at 6:21 PM].
 * * --> <Second Reviewer> on [31-Jul-2018 at 6:21 PM].
 * * ============================================================================
 **/

public class MainActivity extends AppCompatActivity implements Observer {

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        UserViewModel userViewModel = new UserViewModel();
        activityMainBinding.setMainMvvm(userViewModel);

        initRecyclerView();
        userViewModel.addObserver(this);
    }

    private void initRecyclerView() {
        activityMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        activityMainBinding.recyclerView.setAdapter(new MainAdapter());
    }

    @Override
    public void update(Observable observable, Object object) {
        if(observable instanceof UserViewModel) {
            UserViewModel userViewModel = (UserViewModel) observable;
            MainAdapter mainAdapter = (MainAdapter) activityMainBinding.recyclerView.getAdapter();
            mainAdapter.setUserModels(userViewModel.getUserList());
        }
    }
}
