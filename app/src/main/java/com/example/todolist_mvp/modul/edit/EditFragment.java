package com.example.todolist_mvp.modul.edit;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.example.todolist_mvp.R;
import com.example.todolist_mvp.base.BaseFragment;
import com.example.todolist_mvp.data.model.Task;
import com.example.todolist_mvp.modul.list.ListActivity;

/**
 * Created by fahrul on 13/03/19.
 */

public class EditFragment extends BaseFragment<EditActivity, EditContract.Presenter> implements EditContract.View {

    EditText etTaskTitle;
    EditText etTaskDescription;
    Button btnSave;
    String id;


    public EditFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_form, container, false);
        mPresenter = new EditPresenter(this);
        mPresenter.start();

        etTaskTitle = fragmentView.findViewById(R.id.judul);
        etTaskDescription = fragmentView.findViewById(R.id.deskripsi);
        btnSave = fragmentView.findViewById(R.id.btn_submit);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtSaveClick();
            }
        });

        setTitle("Add New Task");
        mPresenter.loadData(this.id);

        return fragmentView;
    }

    public void setBtSaveClick(){
        String title = etTaskTitle.getText().toString();
        String description = etTaskDescription.getText().toString();
        mPresenter.saveData(title,description);
    }

    @Override
    public void setPresenter(EditContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToTaskList() {
            Intent intent = new Intent(activity, ListActivity.class);
            startActivity(intent);
            activity.finish();
    }

    @Override
    public void showData(Task task) {
        this.etTaskTitle.setText(task.getTitle());
        this.etTaskDescription.setText(task.getDescription());
    }

    @Override
    public void setId(String id) {
        this.id=id;
    }

}
