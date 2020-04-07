package linc.com.inratingtask.domain;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import linc.com.inratingtask.data.MainRepository;
import linc.com.inratingtask.domain.models.DatumEntity;
import linc.com.inratingtask.domain.models.StatisticEntity;
import linc.com.inratingtask.domain.models.StatisticEntity.*;

public class MainInteractorImpl implements MainInteractor{

    private MainRepository repository;
    private CompositeDisposable disposableBag;

    public MainInteractorImpl(MainRepository repository, CompositeDisposable disposableBag) {
        this.repository = repository;
        this.disposableBag = disposableBag;
    }

    //todo merge with other
    @Override
    public Flowable<List<StatisticEntity>> execute(String token) {
        /*Log.d("LIST_INT", "INSIDE");
        return Single.create(emitter -> {
            Log.d("LIST_INT", "FIRST LAYER");
            List<StatisticEntity> allStatistics = new ArrayList<>();
        });*/

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

    private StatisticEntity formStatistic(List<DatumEntity> datumEntities, Type type) {
        return new StatisticEntity(
                type,
                datumEntities,
                datumEntities.size()
        );
    }

}


/*


@Override
    public Single<List<StatisticEntity>> execute(String token) {
        return Single.create((SingleOnSubscribe<List<StatisticEntity>>)  emitter -> {
            final List<StatisticEntity> statisticEntities = new ArrayList<>();

            //todo add coposite dis
            repository.getLikers(token)
                .subscribe(datumEntities -> {
                    statisticEntities.add(formStatistic(datumEntities, Type.LIKES));
                }, e-> e.printStackTrace());
            Log.d("LIST_DEB", ""+statisticEntities.size());

            emitter.onSuccess(statisticEntities);
            //todo merge all requests and create statistics
        }).subscribeOn(Schedulers.io());
    }


 */