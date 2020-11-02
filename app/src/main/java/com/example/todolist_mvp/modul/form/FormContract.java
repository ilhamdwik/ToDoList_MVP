package com.example.todolist_mvp.modul.form;

import com.example.todolist_mvp.base.BasePresenter;
import com.example.todolist_mvp.base.BaseView;

/**
 * Created by fahrul on 13/03/19.
 */

public interface FormContract {
    interface View extends BaseView<Presenter> {
        void redirectToLists();
//        void showProfile();
    }

    interface Presenter extends BasePresenter {
        void performLogout();
    }
}
