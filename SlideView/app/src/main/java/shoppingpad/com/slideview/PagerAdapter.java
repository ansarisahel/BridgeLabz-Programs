package shoppingpad.com.slideview;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * Created by bridgelabz on 26/3/16.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {

    Context context;

    public PagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragment1,container,false);
        TextView textView = (TextView) view.findViewById(R.id.textView1);
        textView.setText("Fragment 1");
        container.addView(view.getRootView());
        return view.getRootView();
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0)
            return new Fragment1();
        else if(position == 1)
            return new Fragment2();
        else
            return new Fragment3();
    }

    @Override
    public int getCount() {
        return 3;
    }
}
