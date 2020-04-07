package linc.com.inratingtask.domain;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

import linc.com.inratingtask.data.MainRepository;
import linc.com.inratingtask.domain.models.DatumEntity;
import linc.com.inratingtask.domain.models.StatisticEntity;
import linc.com.inratingtask.domain.models.StatisticEntity.*;

public class MainInteractorImpl implements MainInteractor{

    private MainRepository repository;

    public MainInteractorImpl(MainRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flowable<List<StatisticEntity>> execute(String token) {
        Single<List<StatisticEntity>> likers = repository.getLikers(token)
                .map(datumEntities -> Collections.singletonList(
                        formStatistic(datumEntities, Type.LIKES)));
        Single<List<StatisticEntity>> commentators = repository.getCommentators(token)
                .map(datumEntities -> Collections.singletonList(
                        formStatistic(datumEntities, Type.COMMENTS)));
        Single<List<StatisticEntity>> mentions = repository.getMentions(token)
                .map(datumEntities -> Collections.singletonList(
                        formStatistic(datumEntities, Type.MENTIONS)));
        Single<List<StatisticEntity>> reposters = repository.getReposters(token)
                .map(datumEntities -> Collections.singletonList(
                        formStatistic(datumEntities, Type.REPOSTS)));

        return Single.concat(likers, commentators, mentions, reposters);

    }

    @Override
    public void stop() {
        repository = null;
    }

    private StatisticEntity formStatistic(List<DatumEntity> datumEntities, Type type) {
        return new StatisticEntity(
                type,
                datumEntities,
                datumEntities.size()
        );
    }

}
