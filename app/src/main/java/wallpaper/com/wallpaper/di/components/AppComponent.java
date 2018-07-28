package wallpaper.com.wallpaper.di.components;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import wallpaper.com.wallpaper.di.modules.PresenterModule;
import wallpaper.com.wallpaper.presentation.ui.activities.PictureActivity;
import wallpaper.com.wallpaper.di.modules.AppModule;

@Singleton
@Component(modules = {AppModule.class,
        PresenterModule.class})

public interface AppComponent {

    void inject(Application app);

    void inject(PictureActivity pictureActivity);

}
