package shoppingpad.com.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by bridgelabz on 2/4/16.
 */
public class MyGridAdapter extends BaseAdapter {

    Context context;
    int[] images;
    public MyGridAdapter(Context context,int[] images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_view,viewGroup,false);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView1);
        imageView.setImageResource(images[i]);
        return rowView;
    }

}
