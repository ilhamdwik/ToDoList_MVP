package com.example.todolist_mvp.modul.new_list;

import android.view.View;

import com.example.todolist_mvp.base.BaseFragmentHolderActivity;


public class NewActivity extends BaseFragmentHolderActivity {
    NewFragment newFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
//        ivIcon.setImageResource(R.drawable.....);
        ivIcon.setVisibility(View.VISIBLE);

        newFragment = new NewFragment();
        setCurrentFragment(newFragment, false);

    }




}
