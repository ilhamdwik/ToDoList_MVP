package com.example.todolist_mvp.base;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.todolist_mvp.R;
import com.example.todolist_mvp.modul.login.LoginFragment;


public abstract class BaseActivity extends FragmentActivity implements FragmentListener {
    protected BaseFragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeView();
        initializeFragment();
    }

    protected abstract void initializeFragment();

    protected abstract void initializeView();

    protected void setCurrentFragment(LoginFragment fragment, boolean addToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (currentFragment != null && addToBackStack) {
            fragmentTransaction.addToBackStack(currentFragment.getTitle());
        }

        fragmentTransaction.replace(R.id.fl_FragmentContainer, fragment, fragment.getTitle());
        fragmentTransaction.commit();

        this.currentFragment = fragment;
    }
}