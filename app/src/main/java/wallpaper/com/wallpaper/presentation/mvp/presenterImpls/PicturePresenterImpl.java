package wallpaper.com.wallpaper.presentation.mvp.presenterImpls;

import com.kc.unsplash.models.Photo;

import java.util.ArrayList;

import javax.inject.Inject;

import wallpaper.com.wallpaper.domain.LoaderPictureInteractor;
import wallpaper.com.wallpaper.presentation.mvp.presenters.PicturePresenter;
import wallpaper.com.wallpaper.presentation.mvp.presenters.interactorListeners.InteractorListener;
import wallpaper.com.wallpaper.presentation.mvp.views.PictureView;


public class PicturePresenterImpl extends BaseMvpPresenterImpl<PictureView> implements PicturePresenter, InteractorListener {

    private LoaderPictureInteractor loaderPhoto;

    @Inject
    public PicturePresenterImpl(LoaderPictureInteractor loaderPhoto) {
        this.loaderPhoto = loaderPhoto;
        this.loaderPhoto.setListener(this);
    }


    @Override
    public void uploadPhoto() {
        loaderPhoto.loadPictures();
    }

    @Override
    public <T> void onSuccessLoad(T data) {
        mView.onSuccessUploadPhoto((ArrayList<Photo>) data);
    }

    @Override
    public void onFailureLoad() {
        mView.onFailureUploadPhoto();
    }
}
