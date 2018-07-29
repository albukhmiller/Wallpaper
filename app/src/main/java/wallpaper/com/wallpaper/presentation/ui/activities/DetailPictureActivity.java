package wallpaper.com.wallpaper.presentation.ui.activities;

import android.app.WallpaperManager;
import android.content.AsyncQueryHandler;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import wallpaper.com.wallpaper.R;

public class DetailPictureActivity extends AppCompatActivity {

    @BindView(R.id.ivFullScreenPicture)
    ImageView ivFullScreenPicture;

    @BindView(R.id.btnSetWallpaper)
    Button btnSetWallpaper;

    @BindView(R.id.toolbar)
    Toolbar myToolbar;

    @BindView(R.id.btnUpdateDetailPicture)
    Button btnUpdateDetailPicture;

    @BindView(R.id.llPictureDetail)
    ConstraintLayout llPictureDetail;


    @BindView(R.id.layoutLoader)
    View layoutLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_picture);
        ButterKnife.bind(this);

        setSupportActionBar(myToolbar);

        String urlFullScreenPicture = getIntent().getStringExtra("url");
        loadPicture(urlFullScreenPicture);

        setListeners(urlFullScreenPicture);
    }

    private void setListeners(String url) {

        btnUpdateDetailPicture.setOnClickListener(view -> {
            loadPicture(url);
            btnUpdateDetailPicture.setVisibility(View.GONE);
        });

        btnSetWallpaper.setOnClickListener(view -> {
            WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());

            new AsyncTask<Void, Void, Void>() {
                @Override
                protected void onPostExecute(Void aVoid) {
                    super.onPostExecute(aVoid);
                    Toast.makeText(getApplicationContext(), "Изображение успешно установлено", Toast.LENGTH_SHORT).show();
                }

                @Override
                protected Void doInBackground(Void... voids) {
                    try {
                        wallpaperManager.setBitmap(((BitmapDrawable) ivFullScreenPicture.getDrawable()).getBitmap());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                    return null;

                }
            }.execute();
        });
    }

    private void loadPicture(String url) {
        layoutLoader.setVisibility(View.VISIBLE);
        Picasso.with(this)
                .load(url)
                .into(ivFullScreenPicture, new Callback() {
                    @Override
                    public void onSuccess() {
                        btnUpdateDetailPicture.setVisibility(View.GONE);
                        btnSetWallpaper.setVisibility(View.VISIBLE);
                        ivFullScreenPicture.setVisibility(View.VISIBLE);
                        layoutLoader.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {
                        showError();
                    }
                });
    }


    private void showError() {
        Snackbar sbError = Snackbar.make(llPictureDetail, "При загрузке произошла ошибка. Проверьте соединение с интернетом.", Snackbar.LENGTH_LONG);
        View view = sbError.getView();
        view.setBackgroundColor(getColor(R.color.colorError));
        sbError.show();

        btnUpdateDetailPicture.setVisibility(View.VISIBLE);
        btnSetWallpaper.setVisibility(View.GONE);
        layoutLoader.setVisibility(View.GONE);
    }
}
