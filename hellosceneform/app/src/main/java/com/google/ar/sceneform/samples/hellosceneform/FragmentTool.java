package com.google.ar.sceneform.samples.hellosceneform;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.samples.hellosceneform.utilities.Utilities;

/*
When this activity is created the class gets the product data & sets the textView's with that info.
 */

public class FragmentTool extends Fragment {

    @SuppressLint("WrongConstant")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inf = inflater.inflate(R.layout.fragment_fragment_tool, container, false);

        TextView tvID = (TextView) inf.findViewById(R.id.textViewID);
        tvID.setText(Utilities.TOOL_ID);

        TextView tvPrice = (TextView) inf.findViewById(R.id.textViewPrice);
        tvPrice.setText(Utilities.TOOL_PRICE);

        TextView tvName = (TextView) inf.findViewById(R.id.textViewName);
        tvName.setText(Utilities.TOOL_NAME);

        TextView tvDescription = (TextView) inf.findViewById(R.id.textViewDescription);
        tvDescription.setText(Utilities.TOOL_DESCRIPTION);

        return inf;
    }

    public void setText(String text){
        TextView textView = (TextView) getView().findViewById(R.id.textViewID);
        textView.setText(text);
    }


}
