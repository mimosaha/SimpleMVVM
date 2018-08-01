package database.example.com.simplerecyclermvvm.viewmodel;

import android.databinding.BaseObservable;

import database.example.com.simplerecyclermvvm.model.UserModel;

/**
 * * ============================================================================
 * * Copyright (C) 2018 W3 Engineers Ltd - All Rights Reserved.
 * * Unauthorized copying of this file, via any medium is strictly prohibited
 * * Proprietary and confidential
 * * ----------------------------------------------------------------------------
 * * Created by: Mimo Saha on [31-Jul-2018 at 6:27 PM].
 * * Email: mimosaha@w3engineers.com
 * * ----------------------------------------------------------------------------
 * * Project: SimpleRecyclerMvvm.
 * * Code Responsibility: <Purpose of code>
 * * ----------------------------------------------------------------------------
 * * Edited by :
 * * --> <First Editor> on [31-Jul-2018 at 6:27 PM].
 * * --> <Second Editor> on [31-Jul-2018 at 6:27 PM].
 * * ----------------------------------------------------------------------------
 * * Reviewed by :
 * * --> <First Reviewer> on [31-Jul-2018 at 6:27 PM].
 * * --> <Second Reviewer> on [31-Jul-2018 at 6:27 PM].
 * * ============================================================================
 **/

public class ItemViewModel extends BaseObservable {

    private UserModel userModel;


    public ItemViewModel(UserModel userModel) {
        this.userModel = userModel;
        notifyChange();
    }

    public String getUserName() {
        return userModel.name.title + ". " + userModel.name.firts + " " + userModel.name.last;
    }

    public String getCellNumber() {
        return userModel.cell;
    }
}
