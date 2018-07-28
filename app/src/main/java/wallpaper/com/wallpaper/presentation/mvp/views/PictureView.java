package wallpaper.com.wallpaper.presentation.mvp.views;

import com.kc.unsplash.models.Photo;

import java.util.ArrayList;

/**
 * Created by alex on 27.07.2018.
 */

public interface PictureView extends BaseMvpView {

    void onSuccessUploadPhoto(ArrayList<Photo> pictures);

    void onFailureUploadPhoto();
}
