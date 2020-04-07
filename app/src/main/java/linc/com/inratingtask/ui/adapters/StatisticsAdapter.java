package linc.com.inratingtask.ui.adapters;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import java.util.ArrayList;
import java.util.List;

import linc.com.inratingtask.R;
import linc.com.inratingtask.domain.models.StatisticEntity;

import static linc.com.inratingtask.domain.models.StatisticEntity.Type.MENTIONS;

public class StatisticsAdapter  extends RecyclerView.Adapter<StatisticsAdapter.StatisticViewHolder>{

    private final List<StatisticEntity> statisticEntities = new ArrayList<>();

    public void setData(final List<StatisticEntity> statisticEntities) {
        this.statisticEntities.addAll(statisticEntities);
        notifyDataSetChanged();
    }

    public void clearData() {
        this.statisticEntities.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StatisticViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StatisticViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_statistic, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull StatisticViewHolder holder, int position) {
        holder.bind(statisticEntities.get(position));
    }

    @Override
    public int getItemCount() {
        return statisticEntities.size();
    }

    class StatisticViewHolder extends RecyclerView.ViewHolder {
        private CardView statisticCard;
        private TextView tittle;
        private TextView more;
        private ImageView icon;
        private RecyclerView profiles;
        private ProfilesAdapter adapter;

        public StatisticViewHolder(@NonNull View itemView) {
            super(itemView);
            statisticCard = itemView.findViewById(R.id.statisticCard);
            tittle = itemView.findViewById(R.id.title);
            more = itemView.findViewById(R.id.more);
            icon = itemView.findViewById(R.id.icon);
            profiles = itemView.findViewById(R.id.profiles);

            adapter = new ProfilesAdapter();
            setupProfiles();
        }

        public void bind(StatisticEntity statisticEntity) {
            Context context = itemView.getContext();
            int titleRes = 0;
            int iconRes = 0;

            adapter.setData(statisticEntity.getProfiles());

            // todo optimize
            switch (statisticEntity.getType()) {
                case LIKES: titleRes = R.string.title_statistics_likes;
                            iconRes = R.drawable.ic_like_24dp;
                    break;
                case COMMENTS: titleRes = R.string.title_statistics_comments;
                               iconRes = R.drawable.ic_comment_24dp;
                    break;
                case MENTIONS: titleRes = R.string.title_statistics_mentions;
                               iconRes = R.drawable.ic_mention_24dp;
                    break;
                case REPOSTS: titleRes = R.string.title_statistics_reposts;
                              iconRes = R.drawable.ic_repost_24dp;
                    break;
                default:break;
            }

            // Hide mentions (task condition)
            if(statisticEntity.getType() == MENTIONS) {
                statisticCard.setLayoutParams(new CardView.LayoutParams(
                        CardView.LayoutParams.MATCH_PARENT, CardView.LayoutParams.WRAP_CONTENT));
            }

            // Hide more
            if(statisticEntity.getAmountOfData() < 5) {
                more.setVisibility(View.GONE);
            }else {
                more.setVisibility(View.VISIBLE);
            }

            // Set card data
            tittle.setText(context.getString(titleRes, statisticEntity.getAmountOfData()));
            icon.setBackgroundResource(iconRes);
        }

        private void setupProfiles() {
            // Set simple snapHelper
            SnapHelper snapHelper = new LinearSnapHelper();
            snapHelper.attachToRecyclerView(profiles);

            // Init layoutManager
            LinearLayoutManager layoutManager = new LinearLayoutManager(
                    itemView.getContext(),
                    LinearLayoutManager.HORIZONTAL,
                    false
            );

            // Set-up recycler view
            profiles.setLayoutManager(layoutManager);
            profiles.setAdapter(adapter);
        }

    }


}
