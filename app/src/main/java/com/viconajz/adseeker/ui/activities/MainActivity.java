package com.viconajz.adseeker.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.viconajz.adseeker.R;
import com.viconajz.adseeker.common.enums.BaseAnimation;
import com.viconajz.adseeker.ui.fragments.main.MainFragment;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IMainActivityListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initMainFragment();
    }

    private void initMainFragment() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragment = MainFragment.newInstance();
            String fragmentTag = fragment.getClass().getName();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.fragment_container, fragment, fragmentTag).commit();
        }
    }

    public void navigateToFragment(Fragment fragment, BaseAnimation baseAnimation, boolean clearPrev) {
        String fragmentTag = fragment.getClass().getName();
        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(fragmentTag, 0);

        if (!fragmentPopped) {
            FragmentTransaction ft = manager.beginTransaction();
            switch (baseAnimation) {
                case FadeIn:
                    ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                    break;
                case SlideLeft:
                    ft.setCustomAnimations(R.anim.right_enter, R.anim.left_out, R.anim.left_enter, R.anim.right_out);
                    break;
            }

            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

            ft.replace(R.id.fragment_container, fragment, fragmentTag);

            if (!clearPrev) {
                ft.addToBackStack(fragmentTag);
            }
            ft.commit();
        }
    }

    public void clearAndAddFragment(Fragment fragment) {
        String backStackName = fragment.getClass().getName();
        FragmentManager manager = getSupportFragmentManager();
        manager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        FragmentTransaction ft = manager.beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.replace(R.id.fragment_container, fragment, backStackName);

        ft.commit();
    }
}
