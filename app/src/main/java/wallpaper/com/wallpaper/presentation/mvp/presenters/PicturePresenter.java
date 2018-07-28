package wallpaper.com.wallpaper.presentation.mvp.presenters;

import wallpaper.com.wallpaper.presentation.mvp.views.PictureView;

/**
 * Created by alex on 27.07.2018.
 */

public interface PicturePresenter extends BaseMvpPresenter<PictureView> {

    void uploadPhoto();
}
