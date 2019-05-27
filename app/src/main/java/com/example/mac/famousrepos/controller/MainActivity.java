package com.example.mac.famousrepos.controller;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;
import com.example.mac.famousrepos.R;
import com.example.mac.famousrepos.model.GitHubApi;
import com.example.mac.famousrepos.model.RepoInfo;
import com.example.mac.famousrepos.model.RepoList;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private RepoList repoList = new RepoList();
    private RepoListAdapter adapter;
    private GitHubApi api;
    private Call<RepoList> apiCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.toolbar_text);

        recyclerView = findViewById(R.id.recycler_view);
        adapter = new RepoListAdapter(this, repoList);
        recyclerView.setAdapter(adapter);

        final LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        // use Retrofit to make api call

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // instantiate the GitHubApi interface using Retrofit

        api = retrofit.create(GitHubApi.class);

        fetchRepos();
    }

    private void fetchRepos() {

        // check internet connectivity first

        if (!checkConnectivity()) {
            Toast.makeText(this, R.string.no_network, Toast.LENGTH_LONG).show();
        } else {

            String date = getDate();

            // make api call with query parameters as arguments

            apiCall = api.getRepos("created:>" + date, "stars", "desc", Integer.toString(1));

            apiCall.enqueue(new Callback <RepoList>() {
                @Override
                public void onResponse(Call <RepoList> call, Response <RepoList> response) {

                    if (response.isSuccessful()) {

                        List <RepoInfo> list = response.body().getRepoList();

                        // adding repos from the api response to the adapter's list

                        for (RepoInfo repo : list)
                            repoList.getRepoList().add(repo);

                        adapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onFailure(Call <RepoList> call, Throwable t) {
                    Log.d("error", t.getMessage());
                }
            });


        }
    }


    ///////////////// helper functions /////////////////

    private boolean checkConnectivity() {

        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;

        if (manager != null)
            networkInfo = manager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected())
            return true;

        return false;
    }

    private String getDate() {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -30);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(calendar.getTime());

        return date;
    }



}
