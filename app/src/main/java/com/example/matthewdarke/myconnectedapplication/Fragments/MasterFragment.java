package com.example.matthewdarke.myconnectedapplication.Fragments;
import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.matthewdarke.myconnectedapplication.R;
import com.example.matthewdarke.myconnectedapplication.RecipeAdapter;
import com.example.matthewdarke.myconnectedapplication.model.Recipe;

import java.util.List;

/**
 * Created by matthewdarke on 11/7/14.
 */



public class MasterFragment extends ListFragment implements View.OnClickListener {
    ListView ListV;
    private List<Recipe> recipeList;
    private MasterFragment masterFragment;

    public String TAG = "MasterFragment.TAG";

    private OnClickListener mListener;

    public static MasterFragment newInstance() {

        MasterFragment frag = new MasterFragment();

        return frag;
    }

    @Override
    public void onClick(View view) {

    }


    public interface OnClickListener {




    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof OnClickListener) mListener = (OnClickListener) activity;
        else {
            throw new IllegalArgumentException("Containing activity must implement OnClickListener interface");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_main, container, false);


        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);





        View view = getView();

        ListV.findViewById(R.id.container2);
        RecipeAdapter adapter = new RecipeAdapter(masterFragment.getActivity(), android.R.layout.simple_selectable_list_item, recipeList);

        setListAdapter(adapter);
        Button button = null;
        if (view != null) {
            button = (Button)view.findViewById(R.id.searchButton);
        }
        assert button != null;
        button.setOnClickListener(this);



    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Recipe recipe = (Recipe) l.getItemAtPosition(position);


        Bundle bundle = new Bundle();
        DetailFragment fragment = new DetailFragment();
        bundle.putString("name", recipe.getName());
        bundle.putInt("id", recipe.getId());
        bundle.putInt("season", recipe.getSeason());
        bundle.putInt("runtime", recipe.getRuntime());


        fragment.setArguments(bundle);

        getFragmentManager().beginTransaction().replace(R.id.container1, fragment).commit();


    }


    public void onSavedinstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);


    }


//oncreateview inflate the container for masterfragment using layout inflater

}






// create bundel saved instance









//update display with onClickView



