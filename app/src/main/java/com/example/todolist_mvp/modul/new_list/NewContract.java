package com.example.todolist_mvp.modul.new_list;

import com.example.todolist_mvp.base.BasePresenter;
import com.example.todolist_mvp.base.BaseView;

/**
 * Created by fahrul on 13/03/19.
 */

public interface NewContract {
    interface View extends BaseView<Presenter> {
        void redirectToTaskList();
    }

    interface Presenter extends BasePresenter {
        void saveData(String title, String description);
    }
}
