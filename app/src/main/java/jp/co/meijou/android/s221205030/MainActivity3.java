package jp.co.meijou.android.s221205030;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import java.util.Optional;

import jp.co.meijou.android.s221205030.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {

    private ActivityMain3Binding binding;

    private final ActivityResultLauncher<Intent> getActivityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                switch (result.getResultCode()){
                    case RESULT_OK:
                        Optional.ofNullable(result.getData())
                                .map(data -> data.getStringExtra("ret"))
                                .map(text -> "Result:" + text)
                                .ifPresent(text -> binding.textView2.setText(text));
                        break;
                    case RESULT_CANCELED:
                        binding.textView2.setText("Result: Canceled");
                        break;
                    default:
                        binding.textView2.setText("Result: Unknown(" + result.getResultCode() + ")");
                        break;
                }
            }
    );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //明示的intent
        binding.button.setOnClickListener(view -> {
            var intent = new Intent(this, SubActivity3.class);
            startActivity(intent);
        });

        //暗示的intent
        binding.button2.setOnClickListener(v -> {
            var intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://www.yahoo.co.jp"));
            startActivity(intent);
        });

        //データを送る
        binding.sendButton.setOnClickListener(v -> {
            var intent = new Intent(this, SubActivity3.class);
            var text = binding.editTextText.getText().toString();
            intent.putExtra("text", text);
            startActivity(intent);
        });

        // 結果を取得
        binding.button3.setOnClickListener(view -> {
            var intent = new Intent(this, SubActivity3.class);
            getActivityResult.launch(intent);
        });


    }
}