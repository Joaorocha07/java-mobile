package com.example.applistadecomprasversaodois.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applistadecomprasversaodois.R;
import com.example.applistadecomprasversaodois.controller.ComprasController;
import com.example.applistadecomprasversaodois.modal.Adpter;
import com.example.applistadecomprasversaodois.modal.Compras;

import java.util.ArrayList;
import java.util.List;

public class ItemsActivity extends AppCompatActivity {

    Adpter adpter;

    ComprasController comprasController;
    Compras compras;

    Button btn_Excluir;
    private RecyclerView mRecyclerView;

    private List<Compras> itemListas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        comprasController = new ComprasController(this);

        compras = new Compras();

        Button btn_Excluir = findViewById(R.id.buttonExcluir);
        btn_Excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = mRecyclerView.getChildAdapterPosition(v);
                if (position != RecyclerView.NO_POSITION) {
                    Compras comprasExcluir = itemListas.get(position);
                    comprasController.excluir(compras.getId()); // Certifique-se de ter um método getId() na classe Compras
                    itemListas.remove(position);
                    adpter.notifyItemRemoved(position);
                }
            }
        });

    }
}
