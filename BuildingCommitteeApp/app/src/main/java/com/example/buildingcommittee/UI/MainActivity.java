package com.example.buildingcommittee.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.buildingcommittee.Data.API.ApiPlaceHolder;
import com.example.buildingcommittee.Data.Post;
import com.example.buildingcommittee.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    EditText edtUsernames;
    EditText edtPassword;
    ProgressBar progress_circular;
    Retrofit retrofit;
    public static String BaseURL="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         btnLogin=findViewById(R.id.btnLogin);
        edtUsernames=findViewById(R.id.edtUsernames);
        edtPassword=findViewById(R.id.edtPassword);
        progress_circular=findViewById(R.id.progress_circular);
        progress_circular.setVisibility(View.INVISIBLE);
        btnListeners();



    }
    public void callGetPosts(){
        retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiPlaceHolder apiPlaceHolder =retrofit.create(ApiPlaceHolder.class);
        Call<List<Post>> call = apiPlaceHolder.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getApplicationContext()," Error Code from server is "+response.code(),Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Post> posts= response.body();
                for (Post post:posts){
                    Log.i("Answer",post.getId()+" : is the ID");

                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e("onFailure",t.getMessage());
            }
        });
    };
    private void btnListeners(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),edtUsernames.getText().toString()+" clicked the button",Toast.LENGTH_SHORT).show();
                if(progress_circular.getVisibility()==View.VISIBLE){
                    progress_circular.setVisibility(View.INVISIBLE);
                }else{
                    callGetPosts();
                    progress_circular.setVisibility(View.VISIBLE);
                }







            }
        });
    }



}