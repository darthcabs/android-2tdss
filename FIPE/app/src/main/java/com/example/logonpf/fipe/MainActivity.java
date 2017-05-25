package com.example.logonpf.fipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener{

    private Spinner spMarca;
    private List<Marca> marcas;
    private ArrayAdapter<Marca> adpMarca;

    private Spinner spVeiculo;
    private List<Veiculo> veiculos;
    private ArrayAdapter<Veiculo> adpVeiculo;

    private Spinner spAno;
    private List<Ano> anos;
    private ArrayAdapter<Ano> adpAno;

    private TextView txtPreco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPreco = (TextView) findViewById(R.id.txtPreco);

        spMarca = (Spinner) findViewById(R.id.spMarca);
        spMarca.setOnItemSelectedListener(this);
        marcas = new ArrayList<Marca>();
        adpMarca = new ArrayAdapter<Marca>(this,
                R.layout.spinner_item,marcas);
        spMarca.setAdapter(adpMarca);
        adpMarca.add(new Marca(-1, "Escolha a Marca"));

        spVeiculo = (Spinner) findViewById(R.id.spVeiculo);
        spVeiculo.setOnItemSelectedListener(this);
        veiculos = new ArrayList<Veiculo>();
        adpVeiculo = new ArrayAdapter<Veiculo>(this,
                R.layout.spinner_item,veiculos);
        spVeiculo.setAdapter(adpVeiculo);
        adpVeiculo.add(new Veiculo(-1, "Escolha o Veículo"));

        spAno = (Spinner) findViewById(R.id.spAno);
        spAno.setOnItemSelectedListener(this);
        anos = new ArrayList<Ano>();
        adpAno = new ArrayAdapter<Ano>(this,
                R.layout.spinner_item,anos);
        spAno.setAdapter(adpAno);
        adpAno.add(new Ano(-1, "Escolha o Ano"));

        carregarMarcas();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Object o = parent.getItemAtPosition(position);
        if (parent == spMarca){
            adpVeiculo.clear();
            carregarVeiculos(((Marca) o).getId());
        } else if (parent == spVeiculo){
            adpAno.clear();
            carregarAnos(((Veiculo) o).getMarca(), ((Veiculo) o).getId());
        } else if (parent == spAno){
            //txtPreco.setText("Preço:");
            carregarPreco(((Ano) o).getIdMarca(), ((Ano) o).getIdVeiculo(), ((Ano) o).getCodFipe());
        }
    }

    private void carregarMarcas() {
        String url = "http://fipeapi.appspot.com/api/1/carros/marcas.json";
        JsonArrayRequest req = new JsonArrayRequest(url,
                new RequestMarca(adpMarca),
                new RequestError());
        RequestQueue q = Volley.newRequestQueue(this);
        q.add(req);
    }

    private void carregarVeiculos(int idMarca) {
        String url = "http://fipeapi.appspot.com/api/1/carros/veiculos/" + idMarca + ".json";
        JsonArrayRequest req = new JsonArrayRequest(url,
                new RequestVeiculo(idMarca, adpVeiculo),
                new RequestError());
        RequestQueue q = Volley.newRequestQueue(this);
        q.add(req);
    }

    private void carregarAnos(int idMarca, int idVeiculo) {
        String url = "http://fipeapi.appspot.com/api/1/carros/veiculo/" + idMarca + "/" + idVeiculo + ".json";
        JsonArrayRequest req = new JsonArrayRequest(url,
                new RequestAno(idMarca, idVeiculo, adpAno),
                new RequestError());
        RequestQueue q = Volley.newRequestQueue(this);
        q.add(req);
    }

    private void carregarPreco(int idMarca, int idVeiculo, String codFipe) {
        String url = "http://fipeapi.appspot.com/api/1/carros/veiculo/" + idMarca + "/" + idVeiculo + "/" + codFipe + ".json";

        JsonObjectRequest req = new JsonObjectRequest(url, null, new RequestPreco(this), new RequestError());
        RequestQueue q = Volley.newRequestQueue(this);
        q.add(req);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}