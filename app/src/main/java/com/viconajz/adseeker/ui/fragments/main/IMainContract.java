package com.viconajz.adseeker.ui.fragments.main;

import androidx.fragment.app.FragmentActivity;

import com.viconajz.adseeker.ui.infrastructures.IBasePresenter;
import com.viconajz.adseeker.ui.infrastructures.IBaseView;

public interface IMainContract {
    interface Presenter extends IBasePresenter {
    }

    interface View extends IBaseView<Presenter> {
    }
}
