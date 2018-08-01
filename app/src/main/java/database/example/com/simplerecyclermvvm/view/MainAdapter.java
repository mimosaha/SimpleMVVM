package database.example.com.simplerecyclermvvm.view;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import database.example.com.simplerecyclermvvm.R;
import database.example.com.simplerecyclermvvm.databinding.ItemUserBinding;
import database.example.com.simplerecyclermvvm.model.UserModel;
import database.example.com.simplerecyclermvvm.viewmodel.ItemViewModel;

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

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {

    private List<UserModel> userModels;

    MainAdapter() {
        userModels = new ArrayList<>();
    }

    void setUserModels(List<UserModel> userModels) {
        this.userModels = userModels;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemUserBinding itemUserBinding = DataBindingUtil.inflate(LayoutInflater.
                from(parent.getContext()), R.layout.item_user, parent, false);

        return new CustomViewHolder(itemUserBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.userBinding(userModels.get(position));
    }

    @Override
    public int getItemCount() {
        return userModels.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        ItemUserBinding itemUserBinding;

        public CustomViewHolder(ItemUserBinding itemUserBinding) {
            super(itemUserBinding.getRoot());
            this.itemUserBinding = itemUserBinding;
        }

        public void userBinding(UserModel userModel) {
            itemUserBinding.setUserItem(new ItemViewModel(userModel));
        }
    }
}
