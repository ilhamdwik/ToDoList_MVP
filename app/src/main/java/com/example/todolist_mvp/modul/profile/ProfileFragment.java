package com.example.todolist_mvp.modul.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.todolist_mvp.R;
import com.example.todolist_mvp.base.BaseFragment;
import com.example.todolist_mvp.modul.list.ListActivity;
import com.example.todolist_mvp.modul.login.LoginActivity;


/**
 * Created by fahrul on 13/03/19.
 */

public class ProfileFragment extends BaseFragment<ProfileActivity, ProfileContract.Presenter> implements ProfileContract.View {

    TextView tvEmail;
    TextView tvPassword;
    ImageButton bBack;
    Bundle profile;


    public ProfileFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_profile, container, false);
        mPresenter = new ProfilePresenter(this);
        mPresenter.start();

        tvEmail = fragmentView.findViewById(R.id.tv_UsernameProfile);
        tvPassword = fragmentView.findViewById(R.id.tv_PasswordProfile);
        bBack = fragmentView.findViewById(R.id.btBack);

        setTitle("Profile");
        showProfile();

        return fragmentView;
    }

    @Override
    public void setPresenter(ProfileContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToLogin() {
            Intent intent = new Intent(activity, LoginActivity.class);
            startActivity(intent);
            activity.finish();
    }

    @Override
    public void redirectToLists() {
        Intent intent = new Intent(activity, ListActivity.class);
        intent.putExtras(profile);

        startActivity(intent);
        activity.finish();
    }

    @Override
    public void showProfile() {
        if(getActivity().getIntent().getExtras() != null) {
            Bundle bundle = getActivity().getIntent().getExtras();
            profile = bundle;
            tvEmail.setText(bundle.getString("email"));
            tvPassword.setText(bundle.getString("password"));
        }
    }


}
