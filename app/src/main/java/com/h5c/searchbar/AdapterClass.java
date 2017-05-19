package com.h5c.searchbar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @author Harsh G. on 19/5/17.
 */

class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolders> {
    Context context;
    ArrayList<String> list;
    ViewHolders viewHolders;

    public AdapterClass(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter, null);
        viewHolders = new ViewHolders(view);
        return viewHolders;
    }

    @Override
    public void onBindViewHolder(ViewHolders holder, int position) {
        holder.text.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setFilter(ArrayList<String> list){
        this.list = new ArrayList<>();
        this.list.addAll(list);
        notifyDataSetChanged();
    }


    public static class ViewHolders extends RecyclerView.ViewHolder {

        public TextView text;

        public ViewHolders(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);

        }
    }
}
