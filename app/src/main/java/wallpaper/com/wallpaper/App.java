package wallpaper.com.wallpaper;

import android.app.Application;
import android.content.Context;

import wallpaper.com.wallpaper.di.components.AppComponent;
import wallpaper.com.wallpaper.di.components.DaggerAppComponent;
import wallpaper.com.wallpaper.di.modules.AppModule;


public class App extends Application {

    private AppComponent component;

    public static AppComponent getComponent(Context context) {
        return ((App) context.getApplicationContext()).component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponent();

        component.inject(this);
    }

    private void initAppComponent() {
        component = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }
}
