package com.example.android.githubapp;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by vaasudevkala on 09/10/17.
 */

public class DetailsAsyncTask extends AsyncTask<String,Void,UserDetails> {

    String followersUrl,followingUrl,reposUrl;


    public DetailsAsyncTask(UserDetails userDetails) {
    }

    @Override
    protected UserDetails doInBackground(String... strings) {

        String idString = strings[0];
        followersUrl= strings[0]+ "/followers";
        Log.i("folowers url",followersUrl);

        try {
            URL url = new URL(idString);
            HttpURLConnection urlConnection=(HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("GET");
            Log.i("Details Response","Connection Started");
            urlConnection.connect();
            Log.i("Details Response","Connection Complete");
            InputStream inputStream=urlConnection.getInputStream();
            Scanner scanner=new Scanner(inputStream);
            String response="";

            while(scanner.hasNext()){

                response += scanner.next();

            }

            UserDetails detailsUrlResponse = parseResponse(response);
            return detailsUrlResponse;


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }


    private UserDetails parseResponse(String response) throws JSONException {

        JSONObject rootObject = new JSONObject(response);
        String id= rootObject.getString("id");
        String name = rootObject.getString("name");
        String public_Repos=rootObject.getString("public_repos");
        Log.i("id",id);
        Log.i("name",name);
        Log.i("Repos",public_Repos);
        UserDetails userDetails=new UserDetails();

        userDetails.setName(name);
        userDetails.setId(id);
        userDetails.setPublic_repos(public_Repos);

        return userDetails;
    }
}
