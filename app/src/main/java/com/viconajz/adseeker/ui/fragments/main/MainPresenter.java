package com.viconajz.adseeker.ui.fragments.main;

import com.viconajz.adseeker.api.Api;
import com.viconajz.adseeker.ui.infrastructures.BasePresenterImp;

public class MainPresenter extends BasePresenterImp<IMainContract.View>
        implements IMainContract.Presenter {

    private Api api;

    public MainPresenter(IMainContract.View view, Api api) {
        super(view, api);
        this.api = api;
    }
}
