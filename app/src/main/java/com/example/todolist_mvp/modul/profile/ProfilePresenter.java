package com.example.todolist_mvp.modul.profile;

/**
 * Created by fahrul on 13/03/19.
 */

public class ProfilePresenter implements ProfileContract.Presenter{
    private final ProfileContract.View view;



    public ProfilePresenter(ProfileContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {}

    @Override
    public void performLogout(){
        //proses login
        //if login success call redirect to profile
        view.redirectToLogin();
    }

}
