package linc.com.inratingtask.domain;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import linc.com.inratingtask.domain.models.StatisticEntity;

public interface MainInteractor {

    Flowable<List<StatisticEntity>> execute(String token);

}
