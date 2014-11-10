package com.example.matthewdarke.myconnectedapplication.Fragments;
import android.content.Context;
import android.net.ConnectivityManager;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Log;
import android.widget.ListView;
import android.net.NetworkInfo;

import com.example.matthewdarke.myconnectedapplication.RecipeAdapter;
import com.example.matthewdarke.myconnectedapplication.model.Recipe;
import com.example.matthewdarke.myconnectedapplication.HttpManager;
import com.example.matthewdarke.myconnectedapplication.R;

/**
 * Created by matthewdarke on 11/7/14.
 */



public class MasterFragment extends ListFragment  {

    public String TAG = "MasterFragment.TAG";
// Reference of activity





    public static MasterFragment newInstance() {

        MasterFragment frag = new MasterFragment();

        return frag;
    }


   public interface OnButtionClickListener{

    ///


   }

    @Override
    public void onAttach(Activity activity){
    super.onAttach(activity);

    //if(activity instanceof OnClickListener) {

      // mListener = (onClickListener) activity;
    //}else {
        //throw new IllegalArgumentException("activity must implament the onClickButton listener");


    }
        //enforce interface





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.master_fragment, container, false);



        return view;
    }

    @Override
    public  void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        View view = getView();

    }



    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
         super.onListItemClick(l, v, position, id);

       Recipe recipe = (Recipe) l.getItemAtPosition(position);


        Bundle bundle = new Bundle();
        DetailFragment fragment = new DetailFragment();
        bundle.putString("name", recipe.getmName());
        bundle.putInt("id", recipe.getmId());
        bundle.putInt("season", recipe.getmSeason());
        bundle.putInt("runtime", recipe.getmRuntime());


        fragment.setArguments(bundle);

getFragmentManager().beginTransaction().replace(R.id.container2,fragment).commit();


    }



}

//oncreateview inflate the container for masterfragment using layout inflater








// create bundel saved instance









//update display with onClickView


















