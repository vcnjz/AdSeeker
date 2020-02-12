package com.viconajz.adseeker.ui.infrastructures;

import android.content.Context;
import android.view.View;

public interface IBaseView<T> {
    //IResolution getResolution();

    Context getContext();

    View getCurrentView();
}
