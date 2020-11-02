package com.example.todolist_mvp.modul.edit;


import com.example.todolist_mvp.base.BasePresenter;
import com.example.todolist_mvp.base.BaseView;
import com.example.todolist_mvp.data.model.Task;

/**
 * Created by fahrul on 13/03/19.
 */

public interface EditContract {
    interface View extends BaseView<Presenter> {
        void redirectToTaskList();
        void showData(Task task);
        void setId(String id);
    }

    interface Presenter extends BasePresenter {
        void saveData(String title, String description);
        void loadData(String id);
    }
}
