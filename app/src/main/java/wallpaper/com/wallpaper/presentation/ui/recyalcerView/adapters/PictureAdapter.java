package wallpaper.com.wallpaper.presentation.ui.recyalcerView.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.kc.unsplash.models.Photo;

import java.util.ArrayList;

import wallpaper.com.wallpaper.R;
import wallpaper.com.wallpaper.presentation.ui.recyalcerView.holders.PictureHolder;

/**
 * Created by alex on 27.07.2018.
 */

public class PictureAdapter extends RecyclerView.Adapter<PictureHolder> {

    private ArrayList<Photo> pictures;
    private int sizeDisplay;

    public PictureAdapter(ArrayList<Photo> pictures, int sizeDisplay) {
        this.pictures = pictures;
        this.sizeDisplay = sizeDisplay;
    }

    @NonNull
    @Override
    public PictureHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PictureHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.picture_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PictureHolder holder, int position) {
        holder.bind(pictures.get(position), sizeDisplay);
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }
}