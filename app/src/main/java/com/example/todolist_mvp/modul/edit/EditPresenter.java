package com.example.todolist_mvp.modul.edit;

import com.example.todolist_mvp.data.model.Task;

/**
 * Created by fahrul on 13/03/19.
 */

public class EditPresenter implements EditContract.Presenter{
    private final EditContract.View view;

    public EditPresenter(EditContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {
    }

    @Override
    public void saveData(final String title, final String description){
        Task newTask = new Task("3", title, description);
        //save new task
        //then go back to task list
        view.redirectToTaskList();
    }

    @Override
    public void loadData(String id) {
        //load data task by id
        //then send data to fragment
        Task task = new Task("3", "title of taskIndex:"+id, "description of taskIndex:"+id);
        view.showData(task);
    }

}
