package com.viconajz.adseeker.ui.fragments.webview;

import android.util.Log;

import com.viconajz.adseeker.api.Api;
import com.viconajz.adseeker.ui.infrastructures.BasePresenterImp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class WebViewPresenter extends BasePresenterImp<IWebViewContract.View>
        implements IWebViewContract.Presenter {

    private Api api;

    public WebViewPresenter(IWebViewContract.View view, Api api) {
        super(view, api);
        this.api = api;
    }

    @Override
    public void init() {
        mCompositeDisposable.add(Completable.fromRunnable(this::loadHtml)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {

                        }, throwable -> {

                        }
                ));
    }

    private void loadHtml() {
        Document doc;
        try {
            doc = Jsoup.connect("https://porno-tv.info/categories").get();
            parseHtml(doc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseHtml(Document doc) {
        Log.wtf("vcnjz", "parsing html...");
        Elements links = doc.select("a[href]"); // a with href
        Log.wtf("vcnjz", "links size: " + links.size());
        for (Element link : links){
            String linkString = link.attr("abs:href");
            if (!linkString.contains("google")){
                Log.wtf("vcnjz", "index: " + links.indexOf(link));
                Log.wtf("vcnjz", "abs: " + linkString);
            }
        }
    }
}
