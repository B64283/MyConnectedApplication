package com.example.matthewdarke.myconnectedapplication.Fragments;
import com.example.matthewdarke.myconnectedapplication.model.Recipe;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.matthewdarke.myconnectedapplication.R;






/**
 * Created by matthewdarke on 11/7/14.
 */
public class DetailFragment extends Fragment {


    private String mName;
    private int mSeason;
    private int mRuntime;
    private int mId;

    private TextView showName;
    public String titleName;


    private TextView seasnShow;
    public int seasonNum;


    private TextView rnTime;
    public int runTme;


    private TextView idee;
    public int iD;


    public static DetailFragment newInstance(   ) {

        DetailFragment frag = new DetailFragment();


     //add bundle
        Bundle args = new Bundle();

    //load arguments that are needed




        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

     View view = inflater.inflate(R.layout.detail_fragment, container, false);


        showName = (TextView) view.findViewById(R.id.textView2);
        seasnShow = (TextView) view.findViewById(R.id.textView3);
        rnTime = (TextView) view.findViewById(R.id.textView4);
        idee = (TextView) view.findViewById(R.id.textView5);

        Bundle args = getArguments();
        System.out.println("Bundle: " + args);

        if (args != null) {

            String titleName = args.getString("titleName");
            int seasonNum = args.getInt("seasonNum");
            int rnTime = args.getInt("rnTime");
            int iD = args.getInt("iD");

            mName = titleName;
            mSeason = seasonNum;
            mRuntime = rnTime;
            mId = iD;



        }


        showName.setText(mName);
        seasnShow.setText(mSeason);
        rnTime.setText(mRuntime);
        idee.setText(mId);



      return view;



    }

}
