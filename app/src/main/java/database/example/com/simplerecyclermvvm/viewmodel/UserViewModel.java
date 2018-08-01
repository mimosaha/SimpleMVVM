package database.example.com.simplerecyclermvvm.viewmodel;

import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import database.example.com.simplerecyclermvvm.data.ServerHitHelper;
import database.example.com.simplerecyclermvvm.data.ServerHitService;
import database.example.com.simplerecyclermvvm.data.ServerResponse;
import database.example.com.simplerecyclermvvm.model.UserModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * * ============================================================================
 * * Copyright (C) 2018 W3 Engineers Ltd - All Rights Reserved.
 * * Unauthorized copying of this file, via any medium is strictly prohibited
 * * Proprietary and confidential
 * * ----------------------------------------------------------------------------
 * * Created by: Mimo Saha on [31-Jul-2018 at 3:42 PM].
 * * Email: mimosaha@w3engineers.com
 * * ----------------------------------------------------------------------------
 * * Project: SimpleRecyclerMvvm.
 * * Code Responsibility: <Purpose of code>
 * * ----------------------------------------------------------------------------
 * * Edited by :
 * * --> <First Editor> on [31-Jul-2018 at 3:42 PM].
 * * --> <Second Editor> on [31-Jul-2018 at 3:42 PM].
 * * ----------------------------------------------------------------------------
 * * Reviewed by :
 * * --> <First Reviewer> on [31-Jul-2018 at 3:42 PM].
 * * --> <Second Reviewer> on [31-Jul-2018 at 3:42 PM].
 * * ============================================================================
 **/

public class UserViewModel extends Observable {

    private List<UserModel> userList;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public UserViewModel() {
        this.userList = new ArrayList<>();
    }

    public void onClickFabLoad(View view) {
        fetchUserList();
    }

    /**
     * Fetch user list from this random user url
     * and get 10 random users every time
     */
    private void fetchUserList() {

        ServerHitService serverHitService = ServerHitHelper.getInstance().create();

        Disposable disposable = serverHitService.fetchUsers(ServerHitService.RANDOM_USER_URL)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ServerResponse>() {
                    @Override
                    public void accept(ServerResponse peopleResponse) throws Exception {
                        changePeopleDataSet(peopleResponse.getUserList());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

        compositeDisposable.add(disposable);
    }

    private void changePeopleDataSet(List<UserModel> peoples) {
        userList.clear();
        userList.addAll(peoples);
        setChanged();
        notifyObservers();
    }

    public List<UserModel> getUserList() {
        return userList;
    }
}
