package wallpaper.com.wallpaper.presentation.mvp.presenters.interactorListeners;

/**
 * Created by alex on 27.07.2018.
 */

public interface InteractorListener {

    <T> void onSuccessLoad(T data);

    void onFailureLoad();
}
