package Search;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.recyclerview.widget.RecyclerView;

import com.ucsdextandroid2.android2final.MetaWeatherLocationItem;
import com.ucsdextandroid2.android2final.WeatherViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rjaylward on 2019-05-10
 */
public class SearchAdapter extends RecyclerView.Adapter<WeatherViewHolder> {

    private List<? extends MetaWeatherLocationItem> items = new ArrayList<>();

    private OnItemClickListener<MetaWeatherLocationItem> onItemClickListener;

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        WeatherViewHolder weatherViewHolder = WeatherViewHolder.inflate(parent);
        weatherViewHolder.setClickListener(item -> {
            if (onItemClickListener != null)
                onItemClickListener.onItemClicked(item);
        });

        return weatherViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {

    }

    public void submitList(@Nullable List<? extends MetaWeatherLocationItem> list) {
        this.items = list;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener<MetaWeatherLocationItem> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private MetaWeatherLocationItem getItem(int position) {
        return items.get(position);
    }

    private void onBindViewHolder(@NonNull MetaWeatherLocationItem holder, int position) {
        holder.bind(getItem(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}