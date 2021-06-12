package com.example.melvint_pas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {


        private Context mContext;
        private ArrayList<Model> list;
        View view;
        Model temp;


        public DataAdapter(Context mContext, ArrayList<Model> list){
            this.mContext = mContext;
            this.list = list;
        }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            view = LayoutInflater.from(mContext).inflate(R.layout.rv_datachild, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.textView.setText(list.get(position).getName());
            holder.imageView.setImageResource(list.get(position).getImage());
            holder.menuPopUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PopupMenu popupMenu = new PopupMenu(mContext, view);
                    popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                    popupMenu.show();
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            switch (menuItem.getItemId()){
                                case R.id.delete:
                                    Toast.makeText(mContext, "Delete", Toast.LENGTH_SHORT).show();
                                    temp = new Model(list.get(position).getName(), list.get(position).getImage());
                                    deleteitem(position, view);
                                    break;
                            }
                            return true;
                        }
                    });
                }
            });

    }

    private void deleteitem(int position, View view){
            list.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, list.size());

            //snakbar
        Snackbar.make(view, "Undo Deletion of : "+temp.getName(), Snackbar.LENGTH_SHORT )
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        list.add(position, temp);
                        notifyItemInserted(position);
                        notifyItemRangeChanged(position, list.size());
                    }
                })
.setActionTextColor(mContext.getResources().getColor(android.R.color.holo_blue_dark))
                .show();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView, menuPopUp;
            TextView textView;
             public ViewHolder(@NonNull View itemView) {
                 super(itemView);
                 imageView = itemView.findViewById(R.id.imageview);
                 menuPopUp = itemView.findViewById(R.id.img_more);
                 textView = itemView.findViewById(R.id.name);

        }
    }
}
