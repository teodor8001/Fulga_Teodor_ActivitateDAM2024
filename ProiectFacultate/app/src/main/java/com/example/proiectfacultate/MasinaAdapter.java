package com.example.proiectfacultate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MasinaAdapter extends BaseAdapter {
    private List<Masina> masini = null;
    private Context context;
    private int resursaLayout;

    public MasinaAdapter(List<Masina> masini, Context context, int resursaLayout) {
        this.masini = masini;
        this.context = context;
        this.resursaLayout = resursaLayout;
    }


    @Override
    public int getCount() {
        return masini.size();
    }

    @Override
    public Object getItem(int position) {
        return masini.get(position); // se poate face masini[i]? nu
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(resursaLayout, parent, false);

        TextView t1 = v.findViewById(R.id.t1);
        TextView t2 = v.findViewById(R.id.t2);
        TextView t3 = v.findViewById(R.id.t3);
        TextView t4 = v.findViewById(R.id.t4);

        Masina masina = (Masina)getItem(position);
        t1.setText(masina.getBrand());
        t2.setText(masina.getModel());
        t3.setText(String.valueOf(masina.getCaiPutere()));
        t4.setText(String.valueOf(masina.getIsSport()));

        return v;
    }
}
