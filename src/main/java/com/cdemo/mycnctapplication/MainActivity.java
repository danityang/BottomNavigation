package com.cdemo.mycnctapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationBar.OnTabSelectedListener;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import fragment.FifthFragment;
import fragment.FirstFragment;
import fragment.FourthFragment;
import fragment.SecondFragment;
import fragment.ThirdFragment;

public class MainActivity extends AppCompatActivity implements OnClickListener, OnCheckedChangeListener, OnTabSelectedListener {

    BottomNavigationBar bottomNavigationBar;

    FloatingActionButton fabHome;

    FirstFragment mFirstFragment;
    SecondFragment mSecondFragment;
    ThirdFragment mThirdFragment;
    FourthFragment mForthFragment;
    FifthFragment mFifthFragment;
    FragmentManager fragmentManager;

//    Button toggleHide;
//    Button toggleBadge;

    TextView message;
//    TextView scrollableText;

    BadgeItem badgeItem;

    int lastSelectedPosition = 0;

//    ShapeBadgeItem circularBadgeItem, sqaureBadgeItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
    }


    private void initFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (mFirstFragment == null) {
            mFirstFragment = new FirstFragment();
        }
        fragmentTransaction.replace(R.id.fragment_content, mFirstFragment);
        fragmentTransaction.commit();
    }

    private void initView() {
        fragmentManager = getFragmentManager();
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        fabHome = (FloatingActionButton) findViewById(R.id.fab_home);

//        toggleHide = (Button) findViewById(R.id.toggle_hide);
//        toggleBadge = (Button) findViewById(R.id.toggle_badge);

        message = (TextView) findViewById(R.id.message);
//        scrollableText = (TextView) findViewById(R.id.scrollable_text);

        fabHome.setOnClickListener(this);

//        toggleHide.setOnClickListener(this);
//        toggleBadge.setOnClickListener(this);
        bottomNavigationBar.setTabSelectedListener(this);

        badgeItem = new BadgeItem()
                .setBorderWidth(4)
                .setBackgroundColorResource(R.color.blue)
                .setText("1")
                .setHideOnSelect(true)
                .setHideOnSelect(true);

        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
//        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.ic_home_white_24dp, "Home").setActiveColorResource(R.color.orange).setBadgeItem(badgeItem))
                .addItem(new BottomNavigationItem(R.mipmap.ic_book_white_24dp, "Books").setActiveColorResource(R.color.teal))
                .addItem(new BottomNavigationItem(R.mipmap.ic_music_note_white_24dp, "Music").setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.mipmap.ic_tv_white_24dp, "Movies & TV").setActiveColorResource(R.color.brown))
                .addItem(new BottomNavigationItem(R.mipmap.ic_videogame_asset_white_24dp, "Games").setActiveColorResource(R.color.grey))
                .setFirstSelectedPosition(lastSelectedPosition)
                .initialise();

    }

    @Override
    public void onClick(View v) {

       /* if (v.getId() == R.id.toggle_hide) {
            if (bottomNavigationBar != null) {
                bottomNavigationBar.toggle();
            }
        } else if (v.getId() == R.id.toggle_badge) {
            if (badgeItem != null) {
                badgeItem.toggle();
            }
//            if(circularBadgeItem != null){
//                circularBadgeItem.toggle();
//            }
        } else if (v.getId() == R.id.fab_home) {
            final Snackbar snackbar = Snackbar.make(message, "Fab Clicked", Snackbar.LENGTH_LONG);
            snackbar.setAction("dismiss", new OnClickListener() {
                @Override
                public void onClick(View v) {
                    snackbar.dismiss();
                }
            });
            snackbar.show();
        }*/

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }

    @Override
    public void onTabSelected(int position) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        
        switch (position) {
            case 0:
                if (mFirstFragment == null) {
                    mFirstFragment = new FirstFragment();
                }
                fragmentTransaction.replace(R.id.fragment_content, mFirstFragment);
                break;
            case 1:
                if (mSecondFragment == null) {
                    mSecondFragment = new SecondFragment();
                }
                fragmentTransaction.replace(R.id.fragment_content, mSecondFragment);
                break;
            case 2:
                if (mThirdFragment == null) {
                    mThirdFragment = new ThirdFragment();
                }
                fragmentTransaction.replace(R.id.fragment_content, mThirdFragment);
                break;
            case 3:
                if (mForthFragment == null) {
                    mForthFragment = new FourthFragment();
                }
                fragmentTransaction.replace(R.id.fragment_content, mForthFragment);
                break;
            case 4:
                if (mFifthFragment == null) {
                    mFifthFragment = new FifthFragment();
                }
                fragmentTransaction.replace(R.id.fragment_content, mFifthFragment);
                break;

        }
        // 事务提交
        fragmentTransaction.commit();

        lastSelectedPosition = position;
        setMessageText(position + " Tab Selected");
        if (badgeItem != null) {
            badgeItem.setText(Integer.toString(position));
        }
//        setScrollableText(position);

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    private void setMessageText(String messageText) {
        message.setText(messageText);
    }

    private void setScrollableText(int position) {
        switch (position) {
            case 0:
//                scrollableText.setText(R.string.para1);
                break;
            case 1:
//                scrollableText.setText(R.string.para2);
                break;
            case 2:
//                scrollableText.setText(R.string.para3);
                break;
            case 3:
//                scrollableText.setText(R.string.para4);
                break;
            case 4:
//                scrollableText.setText(R.string.para5);
                break;
            default:
//                scrollableText.setText(R.string.para6);
                break;
        }
    }

}
