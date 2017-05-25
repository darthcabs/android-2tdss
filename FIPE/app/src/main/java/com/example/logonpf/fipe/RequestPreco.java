package com.example.logonpf.fipe;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.example.logonpf.fipe.R.id.txtPreco;

/**
 * Created by rm76860 on 25/05/2017.
 */
public class RequestPreco implements Response.Listener<JSONObject> {
    private Context context;

    public RequestPreco(Context mainActContext) {
        this.context = mainActContext;
    }

    @Override
    public void onResponse(JSONObject response) {
        Log.i("ReqPreco.onResponse", "Antes do try...catch");
        try {
            Log.i("ReqPreco.onResponse", "Dentro do try...catch");
            String preco = response.getString("preco");
            TextView txtPreco = (TextView) ((MainActivity)context).findViewById(R.id.txtPreco);
            txtPreco.setText(preco);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}