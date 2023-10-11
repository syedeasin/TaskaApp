package com.app.taskaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class test extends AppCompatActivity {

    private ImageView sliderImage;
    private TextView titleTextView;
    private TextView textTextView;
    private Button skipButton;
    private Button nextButton;
    private int currentIndex = 0;

    private final int[] imageResources = {R.drawable.calander_icon, R.drawable.chat_icon, R.drawable.statics_icon};
    private final String[] titles = {"Organize Your Tasks &amp; Projects Easily", "Always Connect with Team Anytime Anywhere", "Everything You Can Do in the App"};
    private final String[] texts = {"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

//        sliderImage = findViewById(R.id.sliderImage);
//        titleTextView = findViewById(R.id.titleTextView);
//        textTextView = findViewById(R.id.textTextView);
//        skipButton = findViewById(R.id.skipButton);
//        nextButton = findViewById(R.id.nextButton);

        sliderImage = findViewById(R.id.sliderImage);
        titleTextView = findViewById(R.id.titleTextView);
        textTextView = findViewById(R.id.textTextView);
        nextButton = findViewById(R.id.nextButton);
        skipButton = findViewById(R.id.skipButton);

        updateSlide();
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                if (currentIndex < imageResources.length) {
                    updateSlide();
                } else {
                    System.out.println(v.getX());
                }


            }
        });
    }
    private void updateSlide()
    {
        ObjectAnimator slideOut = ObjectAnimator.ofFloat(sliderImage, "translationX", 0f, -sliderImage.getWidth());
        ObjectAnimator slideIn = ObjectAnimator.ofFloat(sliderImage, "translationX", sliderImage.getWidth(), 0f);

        slideOut.setDuration(100);
        slideIn.setDuration(100);

        slideOut.setInterpolator(new AccelerateDecelerateInterpolator());
        slideIn.setInterpolator(new AccelerateDecelerateInterpolator());

        slideOut.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                sliderImage.setImageResource(imageResources[currentIndex]);
                titleTextView.setText(titles[currentIndex]);
                textTextView.setText(texts[currentIndex]);
            }
        });
        slideOut.start();

    }
}