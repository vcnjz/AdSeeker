package com.viconajz.adseeker.ui.fragments.main;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.viconajz.adseeker.App;
import com.viconajz.adseeker.R;
import com.viconajz.adseeker.common.enums.BaseAnimation;
import com.viconajz.adseeker.ui.di.main.MainModule;
import com.viconajz.adseeker.ui.fragments.CoreFragment;
import com.viconajz.adseeker.ui.fragments.webview.WebViewFragment;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.OnClick;

public class MainFragment extends CoreFragment implements IMainContract.View {

    @Inject
    IMainContract.Presenter mPresenter;

    public static Fragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.get(Objects.requireNonNull(getContext())).applicationComponent().plus(new MainModule(this)).inject(this);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView() {

    }

    @OnClick(R.id.btn_start)
    public void onStartClick(){
        mActivityListener.navigateToFragment(WebViewFragment.newInstance(), BaseAnimation.FadeIn, false);
    }
}
