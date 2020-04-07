package linc.com.inratingtask.ui.adapters;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import linc.com.inratingtask.R;
import linc.com.inratingtask.domain.models.DatumEntity;

public class ProfilesAdapter extends RecyclerView.Adapter<ProfilesAdapter.ProfileViewHolder>{

    private final List<DatumEntity> profiles = new ArrayList<>();

    public void setData(final List<DatumEntity> profiles) {
        this.profiles.clear();
        this.profiles.addAll(profiles);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProfileViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_profile, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
        holder.bind(profiles.get(position));
    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    class ProfileViewHolder extends RecyclerView.ViewHolder {
        private ImageView avatar;
        private TextView nickname;

        public ProfileViewHolder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            nickname = itemView.findViewById(R.id.nickname);
        }

        public void bind(DatumEntity datum) {
            Resources res = itemView.getContext().getResources();
            nickname.setText(datum.getNickname());

            // Set image
            Glide.with(itemView.getContext())
                 .load(datum.getAvatarImage().getUrlSmall())
                 .apply(RequestOptions.bitmapTransform(
                         new RoundedCorners((int)res.getDimension(R.dimen.corners_large)))
                 )
                 .into(avatar);
        }
    }
}
