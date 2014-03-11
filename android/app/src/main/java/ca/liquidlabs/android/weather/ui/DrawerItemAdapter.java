package ca.liquidlabs.android.weather.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ca.liquidlabs.android.weather.R;

/**
 * An Adapter for the Item's Nav Drawer's ListView
 * @author Abdullah Rubiyath
 */
public class DrawerItemAdapter extends BaseAdapter {

    // TODO: to be replaced with Weather Data
    private List<String> items;
    private Context context;

    // a ViewHolder class for performance
    private static class ViewHolder {
        TextView cityName;
    }

    /**
     * Creates an Adapter with the List and a Context
     * @param ctx   The Application Context
     * @param list  List of Weather Data
     */
    public DrawerItemAdapter(Context ctx, List<String> list) {
        items = list;
        context = ctx;

        // items cannot be null!
        assert(items != null);
    }

    // returns the total/count of items in ListView
    @Override
    public int getCount() {
        return items.size();
    }

    /**
     * Returns the element at position
     */
    @Override
    public String getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // reference to ViewHolder for performance
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                            .inflate(R.layout.drawer_list_item, parent, false);

            holder = new ViewHolder();
            holder.cityName = (TextView) convertView.findViewById(R.id.drawer_item_city_name);

            // Use a tag to refer to reference the object.
            // since we are targeting Android 4+, this should be fine.
            //
            // @see https://plus.google.com/u/0/+NicolasKlein/posts/2cH1tw3bCy9
            // Adam Powell (Google Engineer's response) on using ViewHolder with Id
            convertView.setTag(R.id.drawer_item_city_name, holder);
        }
        else {

            // extract based on the tag
            holder = (ViewHolder) convertView.getTag(R.id.drawer_item_city_name);
        }


        String city = getItem(position);
        holder.cityName.setText(city);

        return convertView;
    }

}
