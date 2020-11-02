package com.example.todolist_mvp.modul.new_list;

import com.example.todolist_mvp.R;
import com.example.todolist_mvp.data.model.Task;

/**
 * Created by fahrul on 13/03/19.
 */

public class NewPresenter implements NewContract.Presenter{
    private final NewContract.View view;

    public NewPresenter(NewContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {}

    @Override
    public void saveData(final String title, final String description){
        Task newTask = new Task("3", title, description);
        //save new task
        //then go back to task list
        view.redirectToTaskList();
    }

}
