package com.example.logonpf.fipe;

import android.widget.ArrayAdapter;

import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RequestAno implements Response.Listener<JSONArray> {

    private ArrayAdapter<Ano> adpAno;
    private int idMarca;
    private int idVeiculo;

    public RequestAno(int idMarca, int idVeiculo, ArrayAdapter<Ano> adpAno) {
        this.adpAno = adpAno;
        this.idMarca = idMarca;
        this.idVeiculo = idVeiculo;
    }

    @Override
    public void onResponse(JSONArray response) {
        for (int i = 1; i < response.length(); i++){
            try {
                //"fipe_codigo": "32000-1",
                //       "name": "Zero KM Gasolina",
                //        "key": "32000-1",
                //    "veiculo": "Palio 1.0 ECONOMY Fire Flex 8V 4p",
                //         "id": "32000-1"

                JSONObject obj = response.getJSONObject(i);
                Ano a = new Ano();
                String fc = obj.getString("fipe_codigo");
                a.setCodFipe(fc);
                String[] id = fc.split("-");
                a.setId(Integer.parseInt(id[0]));

                adpAno.add(a);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
