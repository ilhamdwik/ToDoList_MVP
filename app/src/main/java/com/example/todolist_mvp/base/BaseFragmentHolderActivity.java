package com.example.todolist_mvp.base;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.example.todolist_mvp.R;

public abstract class BaseFragmentHolderActivity extends BaseActivity {
    protected TextView tvToolbarTitle;
    protected FrameLayout flFragmentContainer;
    protected ImageButton btOptionMenu;
    protected ImageView ivIcon;
    protected ImageButton btBack;
    protected View vMenuBarShadow;
    protected RelativeLayout rlActivityFragmentHolder;
    protected Toolbar mToolbar;
    protected ImageButton btUser;

    @Override
    protected void initializeView() {
        setContentView(R.layout.base_activity);
        tvToolbarTitle = (TextView) findViewById(R.id.tvToolbarTitle);
        flFragmentContainer = (FrameLayout) findViewById(R.id.fl_FragmentContainer);
        btOptionMenu = (ImageButton) findViewById(R.id.btOptionMenu);
        ivIcon = (ImageView) findViewById(R.id.ivIcon);
        btBack = (ImageButton) findViewById(R.id.btBack);
        vMenuBarShadow = findViewById(R.id.vMenuBarShadow);
        rlActivityFragmentHolder = (RelativeLayout) findViewById(R.id.rl_ActivityFragmentHolder);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        btUser = (ImageButton) findViewById(R.id.btUser);

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void setTitle(String title) {
        this.tvToolbarTitle.setText(title);
    }

}
