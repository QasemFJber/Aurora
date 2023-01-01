package com.example.qasemtest.Aurora.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.qasemtest.Aurora.Activity.Adapters.Level.LevelAdapter;
import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Models.Level;
import com.example.qasemtest.Aurora.Activity.AuroraDataBase.ViewModel;
import com.example.qasemtest.Aurora.Activity.Interface.RecyclerViewListener;
import com.example.qasemtest.R;
import com.example.qasemtest.databinding.ActivityLevelBinding;

import java.util.ArrayList;
import java.util.List;

public class Stage extends AppCompatActivity implements RecyclerViewListener {

    private ActivityLevelBinding binding;
    private LevelAdapter adapter ;
    private List<Level> levelList = new ArrayList<>();
    private ViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLevelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("Levels of Game ");
        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        viewModel.getAllLevel().observe(this, new Observer<List<Level>>() {
            @Override
            public void onChanged(List<Level> levels) {

                adapter.setLevelList(levels);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        setDataInRecycler();

    }


    private void setDataInRecycler() {
        adapter = new LevelAdapter(new ArrayList<>(),this);
        binding.rvLevel.setAdapter(adapter);
        binding.rvLevel.setHasFixedSize(true);
        binding.rvLevel.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getApplicationContext(),StartPlay.class);
        intent.putExtra("pos",position);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       MenuInflater inflater = getMenuInflater();
//       inflater.inflate(R.menu.level_menu,menu);
       return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.back:
                Intent intent = new Intent(getApplicationContext(),Home.class);
                startActivity(intent);
                return true;

            default:
                break;
        }
        return false;

    }
}