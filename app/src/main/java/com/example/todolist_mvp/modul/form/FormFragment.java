package com.example.todolist_mvp.modul.form;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.example.todolist_mvp.R;
import com.example.todolist_mvp.base.BaseFragment;
import com.example.todolist_mvp.modul.list.ListActivity;

//import com.hakim.belajaractivity.FirstActivity;


/**
 * Created by fahrul on 13/03/19.
 */

public class FormFragment extends BaseFragment<FormActivity, FormContract.Presenter> implements FormContract.View {

    Bundle profile;

    public FormFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_form, container, false);
        Toolbar toolbar = ((FormActivity) getActivity()).getToolbar();
        //((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
        mPresenter = new FormPresenter(this);
        mPresenter.start();

        profile = getActivity().getIntent().getExtras();

        setTitle("To-Do List");

        return fragmentView;
    }

    @Override
    public void setPresenter(FormContract.Presenter presenter) {
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
    public void redirectToLists() {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(activity, ListActivity.class);
        intent.putExtras(profile);

        startActivity(intent);
        activity.finish();
    }
}
