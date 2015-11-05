package com.rsubramanian.navigationexample;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

public abstract class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

	private static final String LOG_TAG = BaseActivity.class.getName();

	private DrawerLayout drawerLayout;

	private NavigationView navigationView;

	private Toolbar toolbar;

	protected void initNavigation() {

		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		navigationView = (NavigationView) findViewById(R.id.navigationView);
		navigationView.setNavigationItemSelectedListener(this);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

		ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_open, R.string.navigation_close);
		drawerToggle.syncState();
		drawerLayout.setDrawerListener(drawerToggle);

		handleNavigationMenu();
	}

	@Override
	public boolean onNavigationItemSelected(MenuItem menuItem) {

		Log.d(LOG_TAG, "onNavigationItemSelected: " + menuItem.getTitle());
		switch (menuItem.getItemId()) {

			case R.id.menuItem1: {
				drawerLayout.closeDrawer(GravityCompat.START);
				Intent intent = new Intent(this, MainActivity.class);
				startActivity(intent);
				break;
			}
			case R.id.menuItem2: {
				drawerLayout.closeDrawer(GravityCompat.START);
				Intent intent = new Intent(this, ActivityTwo.class);
				startActivity(intent);
				break;
			}
			case R.id.menuItem3: {
				drawerLayout.closeDrawer(GravityCompat.START);
				Intent intent = new Intent(this, ActivityCollapsingToolbar.class);
				startActivity(intent);
				break;
			}
		}
		return false;
	}

	protected NavigationView getNavigationView() {
		return navigationView;
	}

	/**
	 * Hook to deal with the navigation menu at the activity level.
	 * Use this to hide menu items that are not relevant to this
	 * activity, display child menu items, disable the menu item etc..
	 */
	public abstract void handleNavigationMenu();
}
