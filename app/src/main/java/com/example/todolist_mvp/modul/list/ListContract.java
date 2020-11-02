package com.example.todolist_mvp.modul.list;

import com.example.todolist_mvp.base.BasePresenter;
import com.example.todolist_mvp.base.BaseView;
import com.example.todolist_mvp.data.model.Task;

import java.util.ArrayList;

/**
 * Created by fahrul on 13/03/19.
 */

public interface ListContract {
    interface View extends BaseView<Presenter> {
        void redirectToProfile();
        void gotoNewTask();
        void redirectToForm();
//        void showProfile();
    }

    interface Presenter extends BasePresenter {
        ArrayList<Task> getDataSet();
        void performLogout();
    }
}
