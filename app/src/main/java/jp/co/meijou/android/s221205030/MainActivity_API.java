package jp.co.meijou.android.s221205030;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import jp.co.meijou.android.s221205030.databinding.ActivityMainApiBinding;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity_API extends AppCompatActivity {

    private ActivityMainApiBinding binding;
    private final OkHttpClient okHttpClient = new OkHttpClient();
    private final Moshi moshi = new Moshi.Builder().build();
    private final JsonAdapter<Gist> gistJsonAdapter = moshi.adapter(Gist.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainApiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        var request = new Request.Builder()
                .url("https://gist.stoic.jp/okhttp.json")
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                var gist = gistJsonAdapter.fromJson(response.body().source());
                //Log.d("debug", gist.files.get("OkHttp.txt").content.toString());

                Optional.ofNullable(gist)
                        .map(g -> g.files.get("OkHttp.txt"))
                        .ifPresent(gistFile -> {
                            runOnUiThread(() -> binding.textView.setText(gistFile.content));
                        });
            }
        });


    }
}

