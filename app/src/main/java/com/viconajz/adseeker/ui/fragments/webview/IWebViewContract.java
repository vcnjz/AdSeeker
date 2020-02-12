package com.viconajz.adseeker.ui.fragments.webview;

import com.viconajz.adseeker.ui.infrastructures.IBasePresenter;
import com.viconajz.adseeker.ui.infrastructures.IBaseView;

public interface IWebViewContract {
    interface Presenter extends IBasePresenter {
        void init();
    }

    interface View extends IBaseView<IWebViewContract.Presenter> {
    }
}
