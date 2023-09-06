package jp.co.meijou.android.s221205030;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import jp.co.meijou.android.s221205030.databinding.ActivityMainCalculatorBinding;

public class MainActivity_calculator extends AppCompatActivity {

    private ActivityMainCalculatorBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainCalculatorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }

    public class ButtonClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int id = v.getId();

        }
    }
}