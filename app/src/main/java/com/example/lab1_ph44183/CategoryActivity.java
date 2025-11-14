package com.example.lab1_ph44183;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab1_ph44183.Adapter.CatAdapter;
import com.example.lab1_ph44183.DAO.CatDAO;
import com.example.lab1_ph44183.Model.ModelCat;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView rvCategory;
    private CatDAO catDAO;
    private ArrayList<ModelCat> list;
    private CatAdapter catAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        rvCategory = findViewById(R.id.rvCategory);

        rvCategory.setLayoutManager(new LinearLayoutManager(this));

        catDAO = new CatDAO(this);
        catDAO.open();

        loadData();

        catAdapter = new CatAdapter(this, list);
        rvCategory.setAdapter(catAdapter);

    }

    private void loadData(){
        list = catDAO.getAll();
        if (list.isEmpty()) {
            Toast.makeText(this, "Chua co du lieu", Toast.LENGTH_SHORT).show();
        }
    }
}