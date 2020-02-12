package com.viconajz.adseeker.ui.activities;

import androidx.fragment.app.Fragment;

import com.viconajz.adseeker.common.enums.BaseAnimation;

public interface IMainActivityListener {
    void navigateToFragment(Fragment fragment, BaseAnimation baseAnimation, boolean clearOld);
    void clearAndAddFragment(Fragment fragment);
}
