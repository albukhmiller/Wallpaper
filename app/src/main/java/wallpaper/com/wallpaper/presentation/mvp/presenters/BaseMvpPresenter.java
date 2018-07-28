package wallpaper.com.wallpaper.presentation.mvp.presenters;

import wallpaper.com.wallpaper.presentation.mvp.views.BaseMvpView;

/**
 * Created by alex on 27.07.2018.
 */

public interface BaseMvpPresenter<V extends BaseMvpView> {

    void attachView(V mvpView);
    void detachView();
}
