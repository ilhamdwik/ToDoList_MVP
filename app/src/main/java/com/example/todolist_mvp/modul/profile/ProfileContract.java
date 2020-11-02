package com.example.todolist_mvp.modul.profile;

import com.example.todolist_mvp.base.BasePresenter;
import com.example.todolist_mvp.base.BaseView;

/**
 * Created by fahrul on 13/03/19.
 */

public interface ProfileContract {
    interface View extends BaseView<Presenter> {
        void redirectToLogin();
        void redirectToLists();
        void showProfile();
    }

    interface Presenter extends BasePresenter {
        void performLogout();
    }
}
