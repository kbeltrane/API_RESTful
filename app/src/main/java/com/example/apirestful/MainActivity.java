package com.example.apirestful;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import WebServices.Asynchtask;
import WebServices.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void btlogin(View view) {
        Map<String, String> datos = new HashMap<String, String>();
        String Url = "https://jsonplaceholder.typicode.com/users";
        WebService ws = new WebService(Url, datos, MainActivity.this, MainActivity.this);
        ws.execute("GET", "Authorization", "Bearer ");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        TextView txtmensaje = findViewById(R.id.idmensaje);
        String lstuser = "";
        JSONArray jsonlist = new JSONArray(result);
        for (int i = 0; i < jsonlist.length(); i++) {
            JSONObject username = jsonlist.getJSONObject(i);
            JSONObject user = jsonlist.getJSONObject(i);
            JSONObject email = jsonlist.getJSONObject(i);

            lstuser += "USERNAME: "+ username.getString("username").toString()+"\n"+
                    "USUARIO: "+ user.getString("name").toString()+"\n"+"EMAIL: "+
                    email.getString("email").toString()+"\n\n";
        }
        txtmensaje.setText(lstuser);
    }
}

