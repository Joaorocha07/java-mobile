package com.example.applistadecomprasversaodois.modal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.applistadecomprasversaodois.R;

import java.util.List;

public class Adpter extends RecyclerView.Adapter<Adpter.RecyclerTesteViewHolder> {
    public static Interface.ClickRecyclerView_Interface clickRecyclerViewInterface;
    Context mctx;
    private List<Compras> mList;

    public Adpter(Context ctx, List<Compras> list, Interface.ClickRecyclerView_Interface clickRecyclerViewInterface) {
        this.mctx = ctx;
        this.mList = list;
        this.clickRecyclerViewInterface = clickRecyclerViewInterface;
    }

    @Override
    public RecyclerTesteViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_items, viewGroup, false);
        return new RecyclerTesteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerTesteViewHolder viewHolder, int i) {
        Compras item = mList.get(i);

        viewHolder.viewNome.setText(item.getNome());
        viewHolder.viewQntd.setText(item.getQuantidade());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    protected class RecyclerTesteViewHolder extends RecyclerView.ViewHolder {

        protected TextView viewNome;
        protected TextView viewQntd;

        public RecyclerTesteViewHolder(final View itemView) {
            super(itemView);

            viewNome = (TextView) itemView.findViewById(R.id.TextViewNome);
            viewQntd = (TextView) itemView.findViewById(R.id.textViewQnt);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewInterface.onCustomClick(mList.get(getLayoutPosition()));
                }
            });
        }
    }
}
