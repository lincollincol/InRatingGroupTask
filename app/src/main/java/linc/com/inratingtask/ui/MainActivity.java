package linc.com.inratingtask.ui;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.JsonObject;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import linc.com.inratingtask.R;
import linc.com.inratingtask.data.MainRepositoryImpl;
import linc.com.inratingtask.data.api.PostApi;
import linc.com.inratingtask.data.mappers.ActiveGiftMapper;
import linc.com.inratingtask.data.mappers.AvatarImageMapper;
import linc.com.inratingtask.data.mappers.DatumMapper;
import linc.com.inratingtask.domain.MainInteractorImpl;
import linc.com.inratingtask.domain.models.StatisticEntity;
import linc.com.inratingtask.ui.adapters.StatisticsAdapter;
import linc.com.inratingtask.ui.presenters.MainPresenterImpl;
import linc.com.inratingtask.ui.views.MainView;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static linc.com.inratingtask.utils.Constants.*;


public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenterImpl presenter;
    private StatisticsAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new StatisticsAdapter();

        // todo to di
        JsonObject apiBody = new JsonObject();
        apiBody.addProperty(BODY_PARAM, BODY_VALUE);

        //todo implement di with dagger
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                // todo base url to const
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        if(presenter == null) {
            presenter = new MainPresenterImpl(
                    new MainInteractorImpl(
                            new MainRepositoryImpl(
                                    retrofit.create(PostApi.class),
                                    apiBody,
                                    new DatumMapper(
                                            new ActiveGiftMapper(),
                                            new AvatarImageMapper()
                                    )
                            ),
                            new CompositeDisposable()
                    ),
                    new CompositeDisposable()
            );
        }
        presenter.bind(this);

        Button b = findViewById(R.id.load);
        b.setOnClickListener(v -> {
            presenter.loadUsers(TOKEN);
        });


        RecyclerView statistics = findViewById(R.id.statistics);

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
    public void showStatistics(List<StatisticEntity> statistics) {
        adapter.setData(statistics);
    }

    @Override
    public void clearStatistics() {
        adapter.clearData();
    }
}

