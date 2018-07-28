package wallpaper.com.wallpaper.di.modules;

import dagger.Module;
import dagger.Provides;
import wallpaper.com.wallpaper.presentation.mvp.presenterImpls.PicturePresenterImpl;
import wallpaper.com.wallpaper.presentation.mvp.presenters.PicturePresenter;


@Module
public class PresenterModule {

    @Provides
    PicturePresenter providesPicturePresenter(PicturePresenterImpl presenterImpl) {
        return presenterImpl;
    }
}
