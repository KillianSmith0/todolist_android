package com.example.ksmith.sortlistapp;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ksmith on 22/02/2018.
 * <p>
 * <p>
 * The layout manager calls the adapter's onCreateViewHolder().
 * That method needs to construct a RecyclerView.ViewHolder and set the view it uses to display its contents
 * The ViewHolder type must match the type declared in the Adapter class signature.
 * Typically it would set the view by inflating an XML Layout file.
 * <p>
 * The layout manager then binds the view holder to its data, by calling the adapter's onBindViewHolder()
 * and passing the view holder's pos. in the RecyclerView.
 * <p>
 * If the list needs an update, call a notification method on the Recycler.Adapter obj,
 * such as notifyItemChanged(). The liayout manager then rebinds any affectedview holders allowing their data to be update
 * <p>
 * -----------------------------------------------------------------------------------
 * To feed all your data to the list, you must extend the RecyclerView.Adapter class.
 * This object creates views for items, and replaces the content of some of the views
 * with new data items when the original item is no longer visible.
 */

class ToDoAdapter extends RecyclerView.Adapter {

    private ArrayList<ToDoItem> data = new ArrayList<ToDoItem>();

    public ArrayList<ToDoItem> getData() {
        return data;
    }


    public void addItem(ToDoItem item){
        data.add(item);
        notifyDataSetChanged();
//        notifyItemInserted(data.size()-1);
    }

    public void sortById() {
        Log.i("Sorting list", "By item ID");

        Collections.sort(data, ToDoItem.idComparator);
        notifyDataSetChanged();
    }

    public void sortByItem() {
        Log.i("Sorting list", "By Item String");
        Collections.sort(data, ToDoItem.itemComparator);
        notifyDataSetChanged();
    }

    @Override   // Invoked by the layout manager
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Create a new view. from the type of view that is inserted in the list.
        View view = LayoutInflater.from(parent.getContext())
                .inflate(viewType, parent, false);
        Log.i("Adapter", "ViewHolder created");
        return new MyViewHolder(view);    // Deals with the view as a whole. i.e. the Layout.
    }

    // Replaces the contents of a view, invoked by layout manager (i.e. when goes off screen)
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        Log.i("Adapter", "bindViewHolder. Pos: " + data.get(position).getItem());

        ((MyViewHolder) holder).bindData(data.get(position));

        // Needs to be outside of ViewHolder has needs place reference in Adapter
        ((MyViewHolder) holder).deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.remove(position);
                notifyItemRemoved(position);
                Toast.makeText(view.getContext(), "Removed: " + String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.my_text_view;
    }

    // Provide a ref to the views for each data item
    // Complex data items may need more than one view per item
    // Provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView idView;
        private TextView itemView;
        private Button deleteButton;

        public MyViewHolder(View view) {
            super(view);
            this.idView = (TextView) view.findViewById(R.id.id_text_view);
            this.itemView = (TextView) view.findViewById(R.id.item_text_view);
            this.deleteButton = (Button) view.findViewById(R.id.delete_button);
        }

        // Need to create a method that binds the data from the dataset to a RecyclerView's cell
        public void bindData(ToDoItem itemModel) {
            idView.setText(Integer.toHexString(itemModel.getId()));
            itemView.setText(itemModel.getItem());
        }
    }
}