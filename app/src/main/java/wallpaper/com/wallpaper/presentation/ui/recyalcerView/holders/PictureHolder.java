package wallpaper.com.wallpaper.presentation.ui.recyalcerView.holders;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kc.unsplash.models.Photo;
import com.squareup.picasso.Picasso;

import wallpaper.com.wallpaper.presentation.ui.activities.DetailPictureActivity;
import wallpaper.com.wallpaper.R;

/**
 * Created by alex on 27.07.2018.
 */

public class PictureHolder extends RecyclerView.ViewHolder {


    ImageView ivPicture = itemView.findViewById(R.id.ivPicture);

    public PictureHolder(View itemView) {
        super(itemView);
    }

    public void bind(Photo picture, int sizeDisplay) {
        calculateSizePicture(sizeDisplay);
        Picasso.with(itemView.getContext())
                .load(picture.getUrls().getSmall())
                .centerCrop()
                .fit()
                .into(ivPicture);

        itemView.setOnClickListener((view) -> {

            Intent intent = new Intent(itemView.getContext(), DetailPictureActivity.class);
            intent.putExtra("url", picture.getUrls().getRegular());
            itemView.getContext().startActivity(intent);
        });
    }

    private void calculateSizePicture(int size) {

        ViewGroup.LayoutParams params = ivPicture.getLayoutParams();
        params.width = size / 2 - 2;
        params.height = size / 2 - 2;
        ivPicture.setLayoutParams(params);
    }
}
