package com.example.matthewdarke.myconnectedapplication.com.examplematthewdarke.myconnectedapplication.parser;

import java.util.List;

import com.example.matthewdarke.myconnectedapplication.Fragments.MasterFragment;
import com.example.matthewdarke.myconnectedapplication.R;
import com.example.matthewdarke.myconnectedapplication.model.Recipe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
/**
 * Created by matthewdarke on 10/22/14.
 */
public class RecipeJSONParser {


    public static List<Recipe> parseFeed(String content) {



        try {

            JSONArray ar = new JSONArray(content);
            List<Recipe> recipeList = new ArrayList<>();

            for (int i = 0; i < ar.length(); i++) {

                JSONObject obj = ar.getJSONObject(i);
                Recipe recipe = new Recipe();

                recipe.setmId(obj.getInt("id"));
                recipe.setmName(obj.getString("name"));
                recipe.setmSeason(obj.getInt("season"));
                recipe.setmRuntime(obj.getInt("runtime"));

                recipeList.add(recipe);

            }

            return recipeList;


        } catch (JSONException e) {
            e.printStackTrace();
            return null;

        }

    }
}
