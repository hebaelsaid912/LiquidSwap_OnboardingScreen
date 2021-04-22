package com.example.android.onboardingscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    private static int NUM_PAGER = 3;
    private ViewPager viewPager;
    private ScreenSlidePagerAdapter PagerAdapter;
    ImageView imageView;
    LottieAnimationView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.pager);
        PagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(PagerAdapter);
        view = findViewById(R.id.robot);
        imageView = findViewById(R.id.background);
        imageView.animate().translationY(-2500).setDuration(1000).setStartDelay(4000);
        view.animate().translationY(2000).setDuration(1000).setStartDelay(4000);

    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0 :
                    OnBordingFragment1 tab1 = new OnBordingFragment1();
                    return tab1;
                case 1 :
                    OnBordingFragment2 tab2 = new OnBordingFragment2();
                    return tab2;
                case 2 :
                    OnBordingFragment3 tab3 = new OnBordingFragment3();
                    return tab3;
            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_PAGER;
        }
    }
}