package linc.com.inratingtask.data;

import java.util.List;

import io.reactivex.Single;
import linc.com.inratingtask.domain.models.DatumEntity;

public interface MainRepository {
    Single<List<DatumEntity>> getLikers(String token);
    Single<List<DatumEntity>> getCommentators(String token);
    Single<List<DatumEntity>> getMentions(String token);
    Single<List<DatumEntity>> getReposters(String token);
}
