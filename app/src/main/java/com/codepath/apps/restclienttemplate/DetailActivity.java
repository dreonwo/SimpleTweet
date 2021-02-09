package com.codepath.apps.restclienttemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

public class DetailActivity extends AppCompatActivity {

    TextView tvName;
    TextView tvBody;
    TextView tvScreenName;
    TextView tvTimestamp;
    ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Tweet tweet = Parcels.unwrap(getIntent().getParcelableExtra("tweet"));
        tvName = findViewById(R.id.tvName);
        tvName.setText(tweet.user.name);

        tvBody = findViewById(R.id.tvBody);
        tvBody.setText(tweet.body);

        tvScreenName = findViewById(R.id.tvScreenName);
        tvScreenName.setText("@" + tweet.user.screenName);

        tvTimestamp = findViewById(R.id.tvTimestamp);
        tvTimestamp.setText("· " + tweet.getFormattedTimestamp());

        ivImage = findViewById(R.id.ivImage);
        Glide.with(this).load(tweet.user.profileImageUrl).transform(new CircleCrop()).into(ivImage);

    }
}