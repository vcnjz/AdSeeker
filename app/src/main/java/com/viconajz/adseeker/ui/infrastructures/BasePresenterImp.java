package com.viconajz.adseeker.ui.infrastructures;

import com.viconajz.adseeker.api.Api;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenterImp<T extends IBaseView> implements IBasePresenter {
    protected T mView;
    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private Api api;

    public BasePresenterImp(T view, Api api) {
        mView = view;
        this.api = api;
    }

    @Override
    public void onDestroy() {
        mCompositeDisposable.clear();
    }
}
