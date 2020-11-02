package com.example.todolist_mvp.modul.form;

/**
 * Created by fahrul on 13/03/19.
 */

public class FormPresenter implements FormContract.Presenter{
    private final FormContract.View view;



    public FormPresenter(FormContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {}

    @Override
    public void performLogout(){
        //proses login
        //if login success call redirect to profile
        //view.redirectToLogin();
    }

}
