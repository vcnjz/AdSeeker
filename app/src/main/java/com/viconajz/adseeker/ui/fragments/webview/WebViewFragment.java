package com.viconajz.adseeker.ui.fragments.webview;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.viconajz.adseeker.App;
import com.viconajz.adseeker.R;
import com.viconajz.adseeker.ui.di.webview.WebViewModule;
import com.viconajz.adseeker.ui.fragments.CoreFragment;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;

public class WebViewFragment extends CoreFragment implements IWebViewContract.View {

    @Inject
    IWebViewContract.Presenter mPresenter;

    @BindView(R.id.wv)
    WebView wv;

    public static Fragment newInstance() {
        return new WebViewFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.get(Objects.requireNonNull(getContext())).applicationComponent().plus(new WebViewModule(this)).inject(this);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragmen_webview;
    }

    @Override
    protected void initView() {
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setLoadWithOverviewMode(true);
        wv.getSettings().setUseWideViewPort(true);
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, final String url) {

            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Log.wtf("vcnjz", "url: " + request.getUrl().toString());
                return super.shouldOverrideUrlLoading(view, request);
            }

        });
        wv.loadUrl("https://porno-tv.info/categories");
        mPresenter.init();
    }
}
