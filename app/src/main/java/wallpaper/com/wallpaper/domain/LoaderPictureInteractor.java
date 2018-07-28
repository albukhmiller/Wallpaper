package wallpaper.com.wallpaper.domain;

import com.kc.unsplash.Unsplash;
import com.kc.unsplash.api.Order;
import com.kc.unsplash.models.Photo;

import java.util.List;

import javax.inject.Inject;

import wallpaper.com.wallpaper.presentation.mvp.presenters.interactorListeners.InteractorListener;

/**
 * Created by alex on 27.07.2018.
 */

public class LoaderPictureInteractor {

    private final String USER_ID = "17348ba049fd702f42f9106a00c8745ea9bd4f1464c74862d371e01b91892c61";

    private InteractorListener listener;

    @Inject
    public LoaderPictureInteractor() {
    }

    public void setListener(InteractorListener presenter) {
        listener = presenter;
    }

    public void loadPictures() {
        Unsplash client = new Unsplash(USER_ID);
        client.getPhotos(1, 20, Order.LATEST, new Unsplash.OnPhotosLoadedListener() {
            @Override
            public void onComplete(List<Photo> photos) {
                listener.onSuccessLoad(photos);
            }

            @Override
            public void onError(String error) {
                listener.onFailureLoad();
            }
        });

    }
}
