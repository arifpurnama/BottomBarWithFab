package com.arifpurnama.bottombarwithfab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;

public class MainActivity extends AppCompatActivity {
    MBottomBar mBottomBar;
    private boolean isOpenMenu2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomBar = new MBottomBar(findViewById(R.id.home_bottom_bar));
        setFabClick();
        setBarItemClick();
    }

    private void setFabClick() {
        mBottomBar.getFab().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isOpenMenu2 = !isOpenMenu2;
                changeBarMenu();
            }
        });
    }

    private void changeBarMenu() {
        if (isOpenMenu2) {
            mBottomBar.getBottomBar().setNavigationIcon(null);
            mBottomBar.getBottomBar().setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
            mBottomBar.getBottomBar().replaceMenu(R.menu.menu2);
            mBottomBar.fabAnimation(isOpenMenu2);
        } else {
            mBottomBar.getBottomBar().setNavigationIcon(R.drawable.menu_icn);
            mBottomBar.getBottomBar().setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
            mBottomBar.getBottomBar().replaceMenu(R.menu.menu);
            mBottomBar.fabAnimation(isOpenMenu2);
        }
    }

    private void setBarItemClick() {
        mBottomBar.getBottomBar().setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bar_search:
                        Toast.makeText(MainActivity.this, "Bar Search Click", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.btn_favorite:
                        Toast.makeText(MainActivity.this, "Bar Favorite Click", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bar_notifications:
                        Toast.makeText(MainActivity.this, "Bar Notifications Click", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bar_shopping:
                        Toast.makeText(MainActivity.this, "Bar Shopping Click", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

        mBottomBar.getBottomBar().setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Bar Navigation Click", Toast.LENGTH_LONG).show();
            }
        });
    }
}