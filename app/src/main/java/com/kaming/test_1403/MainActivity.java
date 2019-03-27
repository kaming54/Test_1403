package com.kaming.test_1403;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView main_menu,me_menu,add_menu;
    private RelativeLayout container_context;

    MainFragment mMainFragment = new MainFragment();
    AddFragment mAddFragment = new AddFragment();
    MeFragment mMeFragment = new MeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView(){
        main_menu = (ImageView) findViewById(R.id.main_menu);
        add_menu = (ImageView) findViewById(R.id.add_menu);
        me_menu = (ImageView) findViewById(R.id.me_menu);
        container_context = (RelativeLayout) findViewById(R.id.container_context);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container_context,mMainFragment)
                .add(R.id.container_context,mAddFragment)
                .hide(mAddFragment)
                .add(R.id.container_context,mMeFragment)
                .hide(mMeFragment)
                .commit();

        main_menu.setOnClickListener(this);
        add_menu.setOnClickListener(this);
        me_menu.setOnClickListener(this);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.main_menu:
                getSupportFragmentManager()
                        .beginTransaction()
                        .show(mMainFragment)
                        .hide(mAddFragment)
                        .hide(mMeFragment)
                        .commit();
                break;
            case R.id.add_menu:
                getSupportFragmentManager()
                        .beginTransaction()
                        .show(mAddFragment)
                        .hide(mMainFragment)
                        .hide(mMeFragment)
                        .commit();
                break;
            case R.id.me_menu:
                getSupportFragmentManager()
                        .beginTransaction()
                        .show(mMeFragment)
                        .hide(mAddFragment)
                        .hide(mMainFragment)
                        .commit();
                break;
        }
    }
}
