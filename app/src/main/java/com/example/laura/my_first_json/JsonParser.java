package com.example.laura.my_first_json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {
    public List<HashMap<String,Object>> parse(JSONObject jObject){

        JSONArray jCountries = null;
        try {
            jCountries = jObject.getJSONArray("countries");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return getCountries(jCountries);
    }

    private List<HashMap<String, Object>> getCountries(JSONArray jCountries){
        int countryCount = jCountries.length();
        List<HashMap<String, Object>> countryList = new ArrayList<HashMap<String,Object>>();
        HashMap<String, Object> country = null;
        for(int i=0; i<countryCount;i++){
            try {
                country = getCountry((JSONObject)jCountries.get(i));
                countryList.add(country);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return countryList;
    }
    private HashMap<String, Object> getCountry(JSONObject jCountry){

        HashMap<String, Object> country = new HashMap<String, Object>();
        String flag="";
        try {

            flag = jCountry.getString("flag");
            country.put("flag",R.drawable.icon);
            country.put("flag_path", flag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return country;
    }
}