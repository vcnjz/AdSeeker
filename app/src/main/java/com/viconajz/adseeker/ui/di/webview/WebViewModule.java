package com.viconajz.adseeker.ui.di.webview;

import com.viconajz.adseeker.api.Api;
import com.viconajz.adseeker.ui.fragments.webview.IWebViewContract;
import com.viconajz.adseeker.ui.fragments.webview.WebViewPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class WebViewModule {
    private final IWebViewContract.View mView;

    public WebViewModule(IWebViewContract.View view) {
        this.mView = view;
    }

    @Provides
    @WebViewScope
    IWebViewContract.View provideWebViewView() {
        return this.mView;
    }

    @Provides
    @WebViewScope
    IWebViewContract.Presenter provideWebViewPresenter(Api api) {
        return new WebViewPresenter(this.mView, api);
    }
}
