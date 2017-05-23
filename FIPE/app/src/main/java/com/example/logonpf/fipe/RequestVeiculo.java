package com.example.logonpf.fipe;

import android.util.Log;
import android.widget.ArrayAdapter;

import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RequestVeiculo implements Response.Listener<JSONArray>{

    private ArrayAdapter<Veiculo> adpVeiculo;
    private int idMarca;

    public RequestVeiculo(int idMarca, ArrayAdapter<Veiculo> adpVeiculo) {
        this.adpVeiculo = adpVeiculo;
        this.idMarca = idMarca;
    }

    @Override
    public void onResponse(JSONArray response) {

        Log.i("FIPE", response.toString());

        for (int i = 0; i < response.length(); i++) {

            try {
                JSONObject obj = response.getJSONObject(i);
                Veiculo m = new Veiculo(obj.getInt("id"), obj.getString("fipe_name"));
                m.setMarca(idMarca);
                adpVeiculo.add(m);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
