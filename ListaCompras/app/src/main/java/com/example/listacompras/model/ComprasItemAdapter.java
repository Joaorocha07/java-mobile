package com.example.listacompras.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.listacompras.R;

import java.util.ArrayList;

public class ComprasItemAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ComprasItem> itemsList;
    private OnDeleteButtonClickListener deleteButtonClickListener;

    public interface OnDeleteButtonClickListener {
        void onDeleteButtonClick(int position);
    }

    public ComprasItemAdapter(Context context, ArrayList<ComprasItem> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    public void setOnDeleteButtonClickListener(OnDeleteButtonClickListener listener) {
        this.deleteButtonClickListener = listener;
    }

    @Override
    public int getCount() {
        return itemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_item, parent, false);
        }

        TextView textViewItemName = convertView.findViewById(R.id.textViewItemNome);
        TextView textViewItemQuantidade = convertView.findViewById(R.id.textViewItemQuantidade);
        Button btnDeleteItem = convertView.findViewById(R.id.btnDeleteItem);

        ComprasItem item = itemsList.get(position);
        textViewItemName.setText(item.getName());
        textViewItemQuantidade.setText(Integer.toString(item.getQuantity()));

        btnDeleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (deleteButtonClickListener != null) {
                    deleteButtonClickListener.onDeleteButtonClick(position);
                }
            }
        });

        return convertView;
    }
}
