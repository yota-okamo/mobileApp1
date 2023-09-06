package jp.co.meijou.android.s221205030;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import jp.co.meijou.android.s221205030.databinding.ActivityMain2Binding;
import jp.co.meijou.android.s221205030.databinding.ActivityMainBinding;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}