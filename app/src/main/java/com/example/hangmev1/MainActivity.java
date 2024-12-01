package com.example.hangmev1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hangmev1.SubCategoryActivity;

public class MainActivity extends AppCompatActivity {

    public CardView womenCardView, menCardView, kidCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        womenCardView = findViewById(R.id.womenCardView);
        menCardView = findViewById(R.id.menCardView);
        kidCardView = findViewById(R.id.kidCardView);

        womenCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSubCategoryActivity("Women");
            }
        });

        menCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSubCategoryActivity("Men");
            }
        });

        kidCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSubCategoryActivity("Kid");
            }
        });
    }

    private void openSubCategoryActivity(String category) {
        Intent intent = new Intent(MainActivity.this, SubCategoryActivity.class);
        intent.putExtra("CATEGORY", category);
        startActivity(intent);
    }
}
