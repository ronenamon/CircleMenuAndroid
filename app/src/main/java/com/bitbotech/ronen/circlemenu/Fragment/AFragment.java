package com.bitbotech.ronen.circlemenu.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bitbotech.ronen.circlemenu.R;

/**
 * Created by ronen on 13/07/2017.
 */

public class AFragment extends Fragment {
    public String name;
    public int index;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        /** Inflating the layout for this fragment **/

        View v;
        v = inflater.inflate(R.layout.a_fragment, null);
        TextView x = (TextView)v.findViewById(R.id.txtView);
        x.setText(this.name + ", at index : " + this.index);
        return v;
    }
}
