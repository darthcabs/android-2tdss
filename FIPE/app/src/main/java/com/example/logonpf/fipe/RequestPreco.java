package com.example.logonpf.fipe;

import android.content.Context;
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
    private Context context;

    public RequestPreco(Context mainActContext) {
        this.context = mainActContext;
    }

    @Override
    public void onResponse(JSONArray response) {
        try {
            JSONObject obj = response.getJSONObject(0);
            String preco = obj.getString("preco");
            TextView txtPreco = (TextView) ((MainActivity)context).findViewById(R.id.txtPreco);
            txtPreco.setText(preco);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
