package wallpaper.com.wallpaper.di.modules;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by alex on 27.07.2018.
 */

@Module
public class AppModule {

    private Application app;

    public AppModule(Application app) {
        this.app = app;
    }

    @Provides
    Context providesContext() {
        return app;
    }

    @Provides
    Application providesApp() {
        return app;
    }
}
