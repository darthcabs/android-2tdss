package com.example.logonpf.fipe;

import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.example.logonpf.fipe.R.id.txtPreco;

/**
 * Created by rm76860 on 25/05/2017.
 */
public class RequestPreco implements Response.Listener<JSONArray> {
    TextView txtPreco;

    public RequestPreco(TextView txtPreco) {
        this.txtPreco = txtPreco;
    }

    @Override
    public void onResponse(JSONArray response) {
        try {
            JSONObject obj = response.getJSONObject(0);
            String preco = obj.getString("preco");
            txtPreco.setText(preco);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
