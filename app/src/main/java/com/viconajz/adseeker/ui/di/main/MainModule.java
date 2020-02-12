package com.viconajz.adseeker.ui.di.main;

import com.viconajz.adseeker.api.Api;
import com.viconajz.adseeker.ui.fragments.main.IMainContract;
import com.viconajz.adseeker.ui.fragments.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    private final IMainContract.View mView;

    public MainModule(IMainContract.View view) {
        this.mView = view;
    }

    @Provides
    @MainScope
    IMainContract.View provideMainView() {
        return this.mView;
    }

    @Provides
    @MainScope
    IMainContract.Presenter provideMainPresenter(Api api) {
        return new MainPresenter(this.mView, api);
    }
}