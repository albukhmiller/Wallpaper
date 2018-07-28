package wallpaper.com.wallpaper.presentation.ui.activities;

import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.kc.unsplash.models.Photo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import wallpaper.com.wallpaper.App;
import wallpaper.com.wallpaper.R;
import wallpaper.com.wallpaper.presentation.mvp.presenters.PicturePresenter;
import wallpaper.com.wallpaper.presentation.mvp.views.PictureView;
import wallpaper.com.wallpaper.presentation.ui.recyalcerView.adapters.PictureAdapter;

public class PictureActivity extends BaseMvpActivity<PictureView, PicturePresenter> implements PictureView {

    @BindView(R.id.rvPicture)
    RecyclerView rvPicture;

    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;

    @BindView(R.id.llPicture)
    LinearLayout llPicture;

    @BindView(R.id.btnUpdate)
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        App.getComponent(this).inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        ButterKnife.bind(this);

        setSupportActionBar(myToolbar);
        setListeners();

        initRecyclerViewPicture();
        mvpPresenter.uploadPhoto();
    }

    @Override
    public void onSuccessUploadPhoto(ArrayList<Photo> pictures) {
        btnUpdate.setVisibility(View.GONE);
        rvPicture.setAdapter(new PictureAdapter(pictures, getSizeDisplay()));
    }

    @Override
    public void onFailureUploadPhoto() {
        btnUpdate.setVisibility(View.VISIBLE);
        Snackbar sbError = Snackbar.make(llPicture, "При загрузке произошла ошибка. Проверьте соединение с интернетом.", Snackbar.LENGTH_LONG);
        View view = sbError.getView();
        view.setBackgroundColor(getColor(R.color.colorError));
        sbError.show();
    }

    private void initRecyclerViewPicture() {
        rvPicture.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rvPicture.hasFixedSize();
    }

    private int getSizeDisplay() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;

    }

    private void setListeners() {
        btnUpdate.setOnClickListener(v -> {
            mvpPresenter.uploadPhoto();
            btnUpdate.setVisibility(View.GONE);
        });
    }
}
