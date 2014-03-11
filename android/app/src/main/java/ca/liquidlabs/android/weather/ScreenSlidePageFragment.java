package ca.liquidlabs.android.weather;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Abdullah Rubiyath
 */
public class ScreenSlidePageFragment extends Fragment {


    public static final String ARGS_COUNTER = "counter";

    /**
     * Creates a new Instance of ScreenSlidePageFragment
     * @return An instance of ScreenSlidePageFragment
     */
    public static Fragment newInstance(int position) {

        Fragment frag = new ScreenSlidePageFragment();
        Bundle b = new Bundle();
        b.putString(ARGS_COUNTER, position + "");
        frag.setArguments(b);

        return frag;
    }


    private ScreenSlidePageFragment() {
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);


        Bundle b = getArguments();

        // put the string!
        TextView tView = (TextView) rootView.findViewById(R.id.pager_counter);
        tView.setText(b.getString(ARGS_COUNTER));

        return rootView;
    }

}
