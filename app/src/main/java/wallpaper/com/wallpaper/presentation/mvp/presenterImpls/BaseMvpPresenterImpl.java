package wallpaper.com.wallpaper.presentation.mvp.presenterImpls;


import wallpaper.com.wallpaper.presentation.mvp.presenters.BaseMvpPresenter;
import wallpaper.com.wallpaper.presentation.mvp.views.BaseMvpView;

abstract class BaseMvpPresenterImpl<V extends BaseMvpView> implements BaseMvpPresenter<V> {

    protected V mView;

    @Override
    public void attachView(V mvpView) {
        mView = mvpView;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
