package ca.liquidlabs.android.weather.ui;

/**
 * Created by Alif on 3/10/14.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import ca.liquidlabs.android.weather.ScreenSlidePageFragment;

/**
 * A simple pager adapter that represents ScreenSlidePageFragment objects containing
 * Weather Data in sequence.
 * Copied from {@link http://developer.android.com/training/animation/screen-slide.html}
 */
public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {


    private static int NUM_PAGES = 5;

    /**
     *
     * @param fm
     */
    public ScreenSlidePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return ScreenSlidePageFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

}