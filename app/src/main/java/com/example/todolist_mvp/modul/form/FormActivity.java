package com.example.todolist_mvp.modul.form;

import android.view.Menu;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

import com.example.todolist_mvp.R;
import com.example.todolist_mvp.base.BaseFragmentHolderActivity;


public class FormActivity extends BaseFragmentHolderActivity {
    FormFragment formFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.VISIBLE);
        btUser.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
//        ivIcon.setImageResource(R.drawable.....);
        ivIcon.setVisibility(View.VISIBLE);


        formFragment = new FormFragment();
        setCurrentFragment(formFragment, false);
        //((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        //setHasOptionsMenu(true);

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formFragment.redirectToLists();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_pilihan, menu);
        return super.onCreateOptionsMenu(menu);
        //return true;
    }

    public Toolbar getToolbar() { return mToolbar; }
}
