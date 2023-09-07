package jp.co.meijou.android.s221205030;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

import jp.co.meijou.android.s221205030.databinding.ActivityMainApiBinding;
import jp.co.meijou.android.s221205030.databinding.ActivityMainImageBinding;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity_Image extends AppCompatActivity {

    private ActivityMainImageBinding binding;
    private final OkHttpClient okHttpClient = new OkHttpClient();
    private final Moshi moshi = new Moshi.Builder().build();
    private final JsonAdapter<Gist> gistJsonAdapter = moshi.adapter(Gist.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainImageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        var pre_url = "https://placehold.jp/00a1ae/ffffff/350x350.png";

        binding.selectColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String  text = binding.selectColor.getSelectedItem().toString();

                String textColor = pre_url.substring(21, 27);


                switch (text) {
                    case "黒":
                    case "赤":
                    case "白":
                    case "浅葱":
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //未選択の場合
            }
        });

        binding.getTextButton.setOnClickListener(v -> {
            var text = binding.imageText.getText().toString();

            var url = Uri.parse(pre_url)
                    .buildUpon()
                    .appendQueryParameter("text", text)
                    .build()
                    .toString();

            getImage(url);

        });


    }

    private void getImage(String url){
        var request = new Request.Builder()
                .url(url)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                var bitmap = BitmapFactory.decodeStream(response.body().byteStream());

                runOnUiThread(() -> binding.imageView.setImageBitmap(bitmap));
            }
        });

    }
}