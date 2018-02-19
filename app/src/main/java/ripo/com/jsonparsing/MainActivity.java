package ripo.com.jsonparsing;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<JSONResponse> data = new ArrayList<>();
    private DataAdapter adapter;
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Snackbar snackbar = Snackbar
                .make(layout, "No Internet Connection!", Snackbar.LENGTH_LONG)
                .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        WifiManager manager= (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                        manager.setWifiEnabled(true);
//                        Intent emailIntent = new Intent(Intent.ACTION_MANAGE_NETWORK_USAGE);
//                        emailIntent.setData(Uri.parse(""));
//                        emailIntent.setType("text/plain");
                    }
                });
// Changing message text color
        snackbar.setActionTextColor(Color.RED);
// Changing action button text color
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        snackbar.show();

    }

    private void initViews(){
        layout= findViewById(R.id.linier) ;
        recyclerView =findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }
    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
               .baseUrl("https://api.coinmarketcap.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<ArrayList<JSONResponse>> call = request.getJSON();
        call.enqueue(new Callback<ArrayList<JSONResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<JSONResponse>> call, Response<ArrayList<JSONResponse>> response) {
                data.addAll(response.body());
                adapter = new DataAdapter(data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<JSONResponse>> call, Throwable t) {
                Log.d("onResponse", "dataNotFound");
            }
        });


    }

}
