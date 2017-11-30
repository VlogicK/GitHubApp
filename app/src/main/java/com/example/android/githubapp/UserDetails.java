package com.example.android.githubapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.android.githubapp.MainActivity.ID;

public class UserDetails extends AppCompatActivity {

    String id;
    int followers;
    int following;
    String public_repos;
    String userId;
    String name;
    String mainUrl;

    public UserDetails() {
    }

    public UserDetails(String userId, String id, int followers, int following, String public_repos) {
        this.userId = userId;
        this.id = id;
        this.followers = followers;
        this.following = following;
        this.public_repos = public_repos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    ArrayList<UserDetails> userDetails = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public String getPublic_repos() {
        return public_repos;
    }

    public void setPublic_repos(String public_repos) {
        this.public_repos = public_repos;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        Intent intent=getIntent();
        String userId=intent.getStringExtra(ID);
        Toast t1=Toast.makeText(this,userId,Toast.LENGTH_SHORT);
        t1.show();

         mainUrl="https://api.github.com/users/"+userId;

         fetchDetails();



    }

    private void fetchDetails() {

        DetailsAsyncTask detailsAsyncTask=new DetailsAsyncTask(this);
        detailsAsyncTask.execute(mainUrl);
        Log.i("Course Async Task","After execution");


    }
}
