package com.example.hangmev1;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.imageview.ShapeableImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

public class SubCategoryActivity extends AppCompatActivity {

    // Declare views
    public ImageView backBtn, subcat1Img, subcat2Img, subcat3Img;
    public TextView titleTxt, subcat1Txt, subcat2Txt, subcat3Txt;
    public ShapeableImageView mainCatImg;

    //for data from subcat click
    public ConstraintLayout subcat1Const, subcat2Const, subcat3Const;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategory);
        mainCatImg = findViewById(R.id.mainCatImg);
        subcat1Img = findViewById(R.id.subcat1Img);
        subcat2Img = findViewById(R.id.subcat2Img);
        subcat3Img = findViewById(R.id.subcat3Img);
        subcat1Txt = findViewById(R.id.subcat1Txt);
        subcat2Txt = findViewById(R.id.subcat2Txt);
        subcat3Txt = findViewById(R.id.subcat3Txt);
        titleTxt = findViewById(R.id.titleTxt);
        backBtn = findViewById(R.id.backBtn);

        //for data from subcat click
        subcat1Const = findViewById(R.id.subcat1Const);
        subcat2Const = findViewById(R.id.subcat2Const);
        subcat3Const = findViewById(R.id.subcat3Const);


        String category = getIntent().getStringExtra("CATEGORY");
        if (category != null) {
            switch (category) {
                case "Women":
                    mainCatImg.setImageResource(R.drawable.womenjpg);
                    titleTxt.setText("Women");
                    subcat1Txt.setText("Casual");
                    subcat2Txt.setText("Formal");
                    subcat3Txt.setText("Party");
                    subcat1Img.setImageResource(R.drawable.womencasual);
                    subcat2Img.setImageResource(R.drawable.womenformal);
                    subcat3Img.setImageResource(R.drawable.womenparty);
                    break;
                case "Men":
                    mainCatImg.setImageResource(R.drawable.menjpg);
                    titleTxt.setText("Men");
                    subcat1Txt.setText("Formal");
                    subcat2Txt.setText("Shoe");
                    subcat3Txt.setText("Sport");
                    subcat1Img.setImageResource(R.drawable.menformal);
                    subcat2Img.setImageResource(R.drawable.menshoe);
                    subcat3Img.setImageResource(R.drawable.mensport);
                    break;
                case "Kid":
                    mainCatImg.setImageResource(R.drawable.kidjpg);
                    titleTxt.setText("Kid");
                    subcat1Txt.setText("Bag");
                    subcat2Txt.setText("Book");
                    subcat3Txt.setText("Watch");
                    subcat1Img.setImageResource(R.drawable.kidbag);
                    subcat2Img.setImageResource(R.drawable.kidbook);
                    subcat3Img.setImageResource(R.drawable.kidwatch);
                    break;
            }

            subcat1Const.setOnClickListener(v -> openItemListActivity(category, subcat1Txt.getText().toString()));
            subcat2Const.setOnClickListener(v -> openItemListActivity(category, subcat2Txt.getText().toString()));
            subcat3Const.setOnClickListener(v -> openItemListActivity(category, subcat3Txt.getText().toString()));
        }

        // Set up back button to return to the main activity
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go back to MainActivity
                Intent intent = new Intent(SubCategoryActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Close current activity
            }
        });
    }
    private void openItemListActivity(String category, String subCategory) {
        String combinedCategorySubCategory = category + "-" + subCategory;
        Intent intent = new Intent(SubCategoryActivity.this, ItemList.class);
        intent.putExtra("COMBINED_CATEGORY_SUBCATEGORY", combinedCategorySubCategory);
        startActivity(intent);
    }
}
