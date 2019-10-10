package uk.ac.brighton.jh1152.testlayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>  {

    // refernce to dataset on the adapter
    private ArrayList<CardData> mDataset;


    // inner class to control the actions of the individual recycler rows
    public static class MyViewHolder extends RecyclerView.ViewHolder {


        //  Fields to display the text data
        public TextView textName;
        public TextView textDesc;

        public MyViewHolder(View view) {
            super(view);

            // select the fields from the passed in view
            textName = (TextView) view.findViewById(R.id.cardTitle);
            textDesc = (TextView) view.findViewById(R.id.cardDescription);
        }
    }

    // constructor to assign the collection to the local variable when intiased
    public RecyclerAdapter(ArrayList<CardData>  myDataset) {
        mDataset = myDataset;
    }


    // instantiate the inner class to form the subunits of the view
    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;

    }

    // when binding to the recycle view assign to the data fields
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CardData cardData = mDataset.get(position);

        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textName.setText(cardData.name + "at" + position);
        holder.textDesc.setText(cardData.description);
    }

    // used by view manager to work out how many elements are in the data collection
    @Override
    public int getItemCount() {
        Log.d(">>>>>>>",""+ mDataset.size());
        return mDataset.size();
    }

}
