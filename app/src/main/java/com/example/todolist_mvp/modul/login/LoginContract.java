package com.example.todolist_mvp.modul.login;

import com.example.todolist_mvp.base.BasePresenter;
import com.example.todolist_mvp.base.BaseView;

/**
 * Created by fahrul on 13/03/19.
 */

public interface LoginContract {
    interface View extends BaseView<Presenter> {
        void redirectToProfile();
        void redirectToMainList();
    }

    interface Presenter extends BasePresenter {
        void performLogin(String email, String password);
    }
}
