package com.viconajz.adseeker;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;

import com.viconajz.adseeker.ui.di.application.AppModule;
import com.viconajz.adseeker.ui.di.application.DaggerIAppComponent;
import com.viconajz.adseeker.ui.di.application.IAppComponent;

public class App extends Application {

    @NonNull
    private IAppComponent appComponent;

    @NonNull
    public static App get(@NonNull Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = prepareAppComponent().build();
    }

    @NonNull
    private DaggerIAppComponent.Builder prepareAppComponent() {
        return DaggerIAppComponent.builder().appModule(new AppModule(this));
    }

    @NonNull
    public IAppComponent applicationComponent() {
        return appComponent;
    }
}
