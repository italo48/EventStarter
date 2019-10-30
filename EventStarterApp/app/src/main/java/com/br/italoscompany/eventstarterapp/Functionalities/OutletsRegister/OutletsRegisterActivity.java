package com.br.italoscompany.eventstarterapp.Functionalities.OutletsRegister;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.br.italoscompany.eventstarterapp.Adapters.OutletsAdapter;
import com.br.italoscompany.eventstarterapp.Functionalities.UserDashboard.UserDashboardActivity;
import com.br.italoscompany.eventstarterapp.Model.entities.Outlets;
import com.br.italoscompany.eventstarterapp.R;

import java.util.List;

public class OutletsRegisterActivity extends AppCompatActivity implements IOutlets.IView {

    private int idEvent;

    private IOutlets.IPresenter mrPresenter;
    private OutletsAdapter outletsAdapter;

    private EditText editTextNameestablishment;
    private EditText editTextNumTickets;
    private RecyclerView recyclerViewOutlets;
    private LinearLayoutManager linearLayoutManager;
    private Button btnSaveOutlet;
    private Button btnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outlets_register);

        idEvent = Integer.parseInt(getIntent().getExtras().get("idEvent").toString());

        if (mrPresenter == null)
            mrPresenter = new OutletsPesenter(this);

        editTextNameestablishment = (EditText) findViewById(R.id.inputNomeDoEstabelecimento);
        editTextNumTickets = (EditText) findViewById(R.id.inputQtdDeIngressos);
        recyclerViewOutlets = (RecyclerView) findViewById(R.id.recyclerViewOutlets);
        btnSaveOutlet = (Button) findViewById(R.id.buttonSalvarPontoVenda);
        btnFinish = (Button) findViewById(R.id.btnFinish);

        recyclerViewOutlets.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewOutlets.setLayoutManager(linearLayoutManager);

        outletsAdapter = new OutletsAdapter(mrPresenter);

        btnSaveOutlet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Outlets o = new Outlets();
                String nameS = editTextNameestablishment.getText().toString();
                if (!nameS.isEmpty() && !editTextNumTickets.getText().toString().isEmpty()) {
                    int numTcks = Integer.parseInt(editTextNumTickets.getText().toString());
                    o.setNomeDoEstabelecimento(nameS);
                    o.setQtdIngressos(numTcks);

                    mrPresenter.saveOutlets(o);
                    mrPresenter.getOutlets();

                    editTextNameestablishment.setText("");
                    editTextNumTickets.setText("");
                } else {
                    showToast("Preencha os campos");
                }
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!mrPresenter.isOutletsEmpty()){
                    mrPresenter.outletsLinkEvent(idEvent);
                } else {
                    mrPresenter.setEmptyOutlets(idEvent);
                    showToast("Nenhum ponto de venda cadastrado");
                }
                goBack();
            }
        });
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showOutlets(List<Outlets> outletsList) {
        outletsAdapter.setOutlets(outletsList);
        recyclerViewOutlets.setAdapter(outletsAdapter);
    }

    public void goBack() {
        Intent i = new Intent(this, UserDashboardActivity.class);
        i.putExtra("userId", 1L);
        startActivity(i);
        finish();
    }
}
