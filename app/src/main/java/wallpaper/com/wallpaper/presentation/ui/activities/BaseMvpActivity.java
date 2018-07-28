package wallpaper.com.wallpaper.presentation.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import wallpaper.com.wallpaper.presentation.mvp.presenters.BaseMvpPresenter;
import wallpaper.com.wallpaper.presentation.mvp.views.BaseMvpView;



abstract class BaseMvpActivity<V extends BaseMvpView, P extends BaseMvpPresenter<V>> extends AppCompatActivity implements BaseMvpView {

    @Inject
     protected P mvpPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mvpPresenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        mvpPresenter.detachView();
        super.onDestroy();
    }
}
