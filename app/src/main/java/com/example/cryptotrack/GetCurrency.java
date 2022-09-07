package com.example.cryptotrack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cryptotrack.CryptoTemplate;
import com.example.cryptotrack.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GetCurrency extends RecyclerView.Adapter<GetCurrency.CurrencyViewholder> {
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    private ArrayList<CryptoTemplate> cryptoTemplate;
    private Context context;

    public GetCurrency(ArrayList<CryptoTemplate> currencyModals, Context context) {
        this.cryptoTemplate = currencyModals;
        this.context = context;
    }


    public void filterList(ArrayList<CryptoTemplate> filterlist) {
        cryptoTemplate = filterlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GetCurrency.CurrencyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.crypto_cards, parent, false);
        return new GetCurrency.CurrencyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GetCurrency.CurrencyViewholder holder, int position) {
        CryptoTemplate modal = cryptoTemplate.get(position);
        holder.nameTV.setText(modal.getName());
        holder.rateTV.setText("$ " + df2.format(modal.getPrice()));
        holder.symbolTV.setText(modal.getSymbol());
    }

    @Override
    public int getItemCount() {
        return cryptoTemplate.size();
    }

    public class CurrencyViewholder extends RecyclerView.ViewHolder {
        private TextView symbolTV, rateTV, nameTV;

        public CurrencyViewholder(@NonNull View itemView) {
            super(itemView);
            symbolTV = itemView.findViewById(R.id.idTVSymbol);
            rateTV = itemView.findViewById(R.id.idTVRate);
            nameTV = itemView.findViewById(R.id.idTVName);
        }
    }
}