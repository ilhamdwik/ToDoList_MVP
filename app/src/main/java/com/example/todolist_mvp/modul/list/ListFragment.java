package com.example.todolist_mvp.modul.list;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist_mvp.R;
import com.example.todolist_mvp.utils.RecyclerViewAdapter;

import com.example.todolist_mvp.base.BaseFragment;
import com.example.todolist_mvp.data.model.Task;
import com.example.todolist_mvp.modul.edit.EditActivity;
import com.example.todolist_mvp.modul.form.FormActivity;
import com.example.todolist_mvp.modul.new_list.NewActivity;
import com.example.todolist_mvp.modul.profile.ProfileActivity;

import java.util.ArrayList;



/**
 * Created by fahrul on 13/03/19.
 */

public class ListFragment extends BaseFragment<ListActivity, ListContract.Presenter> implements ListContract.View {

    Bundle profile;
    Button btAddNew;
    RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public ListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_list, container, false);
        //Toolbar toolbar = ((ListActivity) getActivity()).getToolbar();
        //((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        //setHasOptionsMenu(true);
        mPresenter = new ListPresenter(this);
        mPresenter.start();

        profile = getActivity().getIntent().getExtras();

        mRecyclerView = fragmentView.findViewById(R.id.recycleView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(activity);
        mRecyclerView.setLayoutManager(mLayoutManager);
        final ArrayList<Task> data = mPresenter.getDataSet();
        mAdapter = new RecyclerViewAdapter(data);
        mRecyclerView.setAdapter(mAdapter);

        Log.d("Data", "Data : ++++++++++++++++++++++++++++++++++");
        Log.d("Data 1", data.get(3).getTitle());

        setTitle("To-Do List");

        btAddNew = fragmentView.findViewById(R.id.bt_AddNew);
        btAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoNewTask();
            }
        });

        ((RecyclerViewAdapter) mAdapter).setOnItemClickListener(new RecyclerViewAdapter.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                String id = data.get(position).getId();
                Log.d("BELAJAR ACTIVITY",">>>>>"+ position);
                editTask(id);
            }
        });

        return fragmentView;
    }

    @Override
    public void setPresenter(ListContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        //getActivity().getMenuInflater().inflate(R.menu.menu_ops1, menu);
        menu.clear();
        inflater.inflate(R.menu.menu_pilihan, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void redirectToForm() {
        Intent intent = new Intent(activity, FormActivity.class);
        intent.putExtras(profile);

        startActivity(intent);
        activity.finish();
    }

    @Override
    public void redirectToProfile() {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(activity, ProfileActivity.class);
        intent.putExtras(profile);

        startActivity(intent);
        activity.finish();
    }

    @Override
    public void gotoNewTask() {
        Intent intent = new Intent(activity, NewActivity.class);
        startActivity(intent);
    }

    public void editTask(String id) {
        Intent intent = new Intent(activity, EditActivity.class);
        intent.putExtra("TaskId", id);
        startActivity(intent);
    }

}
