package jp.co.meijou.android.s221205030;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Optional;

import jp.co.meijou.android.s221205030.databinding.ActivitySub3Binding;

public class SubActivity3 extends AppCompatActivity {

    private ActivitySub3Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySub3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonBack.setOnClickListener(v -> {
            var intent = new Intent(this, MainActivity3.class);
            startActivity(intent);
        });

        Optional.ofNullable(getIntent().getStringExtra("text"))
                .ifPresent(text -> binding.textView.setText(text));

        binding.okButton.setOnClickListener(v -> {
            var intent = new Intent();
            intent.putExtra("ret", "meijo");
            setResult(RESULT_OK, intent);
            finish();
        });
        
        binding.cancelButton.setOnClickListener(v -> {
            setResult(RESULT_CANCELED);
            finish();
        });





    }
}