package com.example.hangmev1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class ItemList extends AppCompatActivity {

    public TextView categoryNSubCategory;
    public ImageView backBtn2;
    MainAdapter mainAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_itemlist);

        recyclerView = findViewById(R.id.itemList);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        categoryNSubCategory = findViewById(R.id.categoryNSubCategory);

        // Initialize the back button and set its click listener
        backBtn2 = findViewById(R.id.backBtn2);
        backBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to the previous activity
                onBackPressed();
            }
        });

        // Get the combined category and subcategory string from the intent
        String combinedCategorySubCategory = getIntent().getStringExtra("COMBINED_CATEGORY_SUBCATEGORY");

        if (combinedCategorySubCategory != null) {
            categoryNSubCategory.setText(combinedCategorySubCategory);

            String firebasePath = getFirebasePath(combinedCategorySubCategory);
            FirebaseRecyclerOptions<ItemModel> options =
                    new FirebaseRecyclerOptions.Builder<ItemModel>()
                            .setQuery(FirebaseDatabase.getInstance().getReference().child(firebasePath), ItemModel.class)
                            .build();

            mainAdapter = new MainAdapter(options);
            recyclerView.setAdapter(mainAdapter);
        }
    }

    private String getFirebasePath(String combinedCategorySubCategory) {
        switch (combinedCategorySubCategory) {
            case "Women-Casual":
                return "womenCasual";
            case "Women-Formal":
                return "womenFormal";
            case "Women-Party":
                return "womenParty";
            case "Men-Formal":
                return "menFormal";
            case "Men-Shoe":
                return "menShoe";
            case "Men-Sport":
                return "menSport";
            case "Kid-Bag":
                return "kidBag";
            case "Kid-Book":
                return "kidBook";
            case "Kid-Watch":
                return "kidWatch";
            default:
                return "";
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainAdapter.stopListening();
    }
}
