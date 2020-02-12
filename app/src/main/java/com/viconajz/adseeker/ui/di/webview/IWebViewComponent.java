package com.viconajz.adseeker.ui.di.webview;

import com.viconajz.adseeker.ui.fragments.webview.WebViewFragment;

import dagger.Subcomponent;

@WebViewScope
@Subcomponent(modules = {WebViewModule.class})
public interface IWebViewComponent {
    void inject(WebViewFragment view);
}