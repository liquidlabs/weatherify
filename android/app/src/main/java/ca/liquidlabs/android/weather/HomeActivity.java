package ca.liquidlabs.android.weather;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ca.liquidlabs.android.weather.ui.DrawerItemAdapter;
import ca.liquidlabs.android.weather.ui.ScreenSlidePagerAdapter;


/**
 * HomeActivity - contains the Drawer along with ViewPagers
 *
 * @author Abdullah Rubiyath
 */
public class HomeActivity extends FragmentActivity {

    /**
     * drawer layout
     */
    private DrawerLayout mDrawerLayout;

    /**
     * drawer toggle
     */
    private ActionBarDrawerToggle mDrawerToggle;

    /**
     * drawer list - ListView
     */
    private ListView mDrawerList;

    /**
     * The ViewPager
     */
    private ViewPager mPager;

    /**
     * PagerAdapter
     */
    private PagerAdapter mPagerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mPager = (ViewPager) findViewById(R.id.pager);

        // setup ActionBar and Navigation Drawer, ViewPager
        setupActionBar();
        setupDrawer();
        setupViewPager();
        setupGestureListeners();
    }


    /**
     * Sets/Initializes the Gestures
     */
    private void setupGestureListeners() {

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }


    /**
     * Sets up the Drawer's Toggle and List View on Navigation Drawer
     */
    public void setupDrawer() {

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_launcher, R.string.app_name, R.string.app_name) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        initListView();
    }


    /**
     * Sets up the Actionbar
     */
    private void setupActionBar()
    {
        ActionBar actionBar  = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }


    /**
     * Sets up ViewPager
     */
    public void setupViewPager() {
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
    }


    /**
     * Initializes the ListView of Drawer
     * @TODO: improve with a actual Weather Data
     */
    private void initListView()
    {
        String[] titles = {
                "Home", "Max", "Contact", "About"
        };

        List<String> titlesList = new ArrayList<String>(titles.length);
        for (String t: titles) {
            titlesList.add(t);
        }

        mDrawerList.setAdapter(new DrawerItemAdapter(this, titlesList));
    }


    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    /**
     *  Selects an Item.
     *  @param pos  The index/position where it was tapped.
     */
    private void selectItem(int pos)
    {
        Toast.makeText(this, "Tapped: " + pos, Toast.LENGTH_LONG).show();
    }


    /**
     * ActionBar Menu/Item's Handler
     *
     * @param item
     *
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        // Handle your other action bar items...
        return super.onOptionsItemSelected(item);
    }

}
