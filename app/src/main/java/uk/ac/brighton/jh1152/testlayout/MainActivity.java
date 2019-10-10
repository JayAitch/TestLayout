package uk.ac.brighton.jh1152.testlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<CardData> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        data = new ArrayList<CardData>();
        data.add(new CardData("Test1","Description can be a lot longer so lets see what this looks like"));
        data.add(new CardData("Test1","Description can be a lot longer so lets see what this looks like"));
        data.add(new CardData("Test1","Description can be a lot longer so lets see what this looks like"));
        data.add(new CardData("Test1","Description can be a lot longer so lets see what this looks like"));
        data.add(new CardData("Test1","Description can be a lot longer so lets see what this looks like"));
        data.add(new CardData("Test1","Description can be a lot longer so lets see what this looks like"));
        data.add(new CardData("Test1","Description can be a lot longer so lets see what this looks like"));




        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify the adapter that will act on the data
        mAdapter = new RecyclerAdapter(data);
        recyclerView.setAdapter(mAdapter);

        // find the floating button and add a listener to it
        FloatingActionButton button = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewCardToData();
            }
        });
    }


    private void addNewCardToData(){
        // add a new card to the collection
        data.add(new CardData("runtime add","this entry was added at runtime"));

        // notify that the data of the whole collection has changed
        mAdapter.notifyItemInserted(data.size());
    }
}
