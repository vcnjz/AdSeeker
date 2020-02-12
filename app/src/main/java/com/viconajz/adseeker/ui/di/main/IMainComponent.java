package com.viconajz.adseeker.ui.di.main;

import com.viconajz.adseeker.ui.fragments.main.MainFragment;

import dagger.Subcomponent;

@MainScope
@Subcomponent(modules = {MainModule.class})
public interface IMainComponent {
    void inject(MainFragment view);
}
