package com.example.logonpf.fipe;

import android.util.Log;
import android.widget.ArrayAdapter;

import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RequestVeiculo implements Response.Listener<JSONArray>{

    private ArrayAdapter<Veiculo> adpVeiculo;

    public RequestVeiculo(ArrayAdapter<Veiculo> adpVeiculo) {
        this.adpVeiculo = adpVeiculo;
    }

    @Override
    public void onResponse(JSONArray response) {

        Log.i("FIPE", response.toString());

        for (int i = 0; i < response.length(); i++) {

            try {
                JSONObject obj = response.getJSONObject(i);
                Veiculo m = new Veiculo(obj.getInt("id"), obj.getString("fipe_name"));

                //TODO fazer buscar ano, key, etc,
                // para listar os anos com o respectivo preço
                getAno();

                adpVeiculo.add(m);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    public void getAno(){
        //TODO
    }


}
