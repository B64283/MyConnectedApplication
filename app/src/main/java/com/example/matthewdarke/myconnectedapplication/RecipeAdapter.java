package com.example.matthewdarke.myconnectedapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.matthewdarke.myconnectedapplication.com.examplematthewdarke.myconnectedapplication.parser.RecipeJSONParser;
import com.example.matthewdarke.myconnectedapplication.model.Recipe;
import java.util.List;
/**
 * Created by matthewdarke on 10/23/14.
 */


public class RecipeAdapter extends ArrayAdapter<Recipe> {

    private Context context;


    private List<Recipe> recipeList;

    public RecipeAdapter(Context context, int resource, List<Recipe> objects) {

        super(context, resource, objects);
        this.context = context;
        this.recipeList = objects;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_recipe, parent, false);


        // display recipe title in the widget

Recipe recipe = recipeList.get(position);
        TextView tv = (TextView)view.findViewById(R.id.textView1);
        //TextView tv2 = (TextView)view.findViewById(R.id.textView5);
        tv.setText(recipe.getName());
        //tv2.setText(recipe.getRuntime());
        //return view;


        //TextView tv5 = (TextView)view.findViewById(R.id.textView5);

        //tv.setText(recipe.getRuntime());

        return view;

    }


}
