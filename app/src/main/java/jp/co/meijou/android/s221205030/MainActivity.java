package jp.co.meijou.android.s221205030;

import static jp.co.meijou.android.s221205030.R.drawable.baseline_ondemand_video_24;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import jp.co.meijou.android.s221205030.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private PrefDataStore prefDataStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        prefDataStore = PrefDataStore.getInstance(this);




        prefDataStore.getInt("num")
                        .ifPresent(num -> binding.text.setText(num));



        binding.change.setOnClickListener(view -> {
            var text = binding.editText.getText().toString();
            var text2 = binding.editText2.getText().toString();
            binding.text.setText(text + text2);
        });

        binding.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                var text = binding.editText.getText().toString();
                var text2 = binding.editText2.getText().toString();
                binding.text.setText(text + text2);
            }
        });

        binding.editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                var text = binding.editText.getText().toString();
                var text2 = binding.editText2.getText().toString();
                binding.text.setText(text + text2);

            }
        });

        binding.savebutton.setOnClickListener(v -> {
            var text = binding.editText.getText().toString();
            prefDataStore.setString("name", text);
        });


        binding.numButton.setOnClickListener(v -> {
            var text = binding.editText2.getText().toString();
            int num = Integer.parseInt(text);
            prefDataStore.setInt("num", num);
        });



    }
    @Override
        protected void onStart() {
            super.onStart();
            prefDataStore.getString("name")
                    .ifPresent(name -> binding.text.setText(name));
}}

