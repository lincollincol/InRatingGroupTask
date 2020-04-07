package linc.com.inratingtask.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;
import javax.inject.Inject;
import linc.com.inratingtask.InRatingApp;
import linc.com.inratingtask.R;
import linc.com.inratingtask.domain.models.StatisticEntity;
import linc.com.inratingtask.ui.adapters.StatisticsAdapter;
import linc.com.inratingtask.ui.presenters.MainPresenter;
import linc.com.inratingtask.ui.views.MainView;

import static linc.com.inratingtask.utils.Constants.*;


public class MainActivity extends AppCompatActivity implements MainView {

    @Inject
    protected MainPresenter presenter;
    private StatisticsAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InRatingApp.getInstance().getAppComponent().inject(this);

        RecyclerView statistics = findViewById(R.id.statistics);
        adapter = new StatisticsAdapter();

        // Bind view
        presenter.bind(this);

        // Load posts from server
        presenter.loadUsers(TOKEN);

        // Init layoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        );

        // Set-up recycler view
        statistics.setLayoutManager(layoutManager);
        statistics.setAdapter(adapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unbind();
    }

    @Override
    public void showStatistics(List<StatisticEntity> statistics) {
        adapter.setData(statistics);
    }

    @Override
    public void clearStatistics() {
        adapter.clearData();
    }

}