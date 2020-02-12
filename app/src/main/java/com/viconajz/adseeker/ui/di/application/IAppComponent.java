package com.viconajz.adseeker.ui.di.application;

import android.content.Context;

import com.viconajz.adseeker.api.Api;
import com.viconajz.adseeker.api.modules.GsonApiModule;
import com.viconajz.adseeker.ui.di.main.IMainComponent;
import com.viconajz.adseeker.ui.di.main.MainModule;
import com.viconajz.adseeker.ui.di.webview.IWebViewComponent;
import com.viconajz.adseeker.ui.di.webview.WebViewModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class, GsonApiModule.class})
@Singleton
public interface IAppComponent {
    Context context();

    Api api();

    IMainComponent plus(MainModule mainModule);

    IWebViewComponent plus(WebViewModule webViewModule);
}
