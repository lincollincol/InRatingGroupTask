package linc.com.inratingtask.data;


import com.google.gson.JsonObject;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import linc.com.inratingtask.data.api.PostApi;
import linc.com.inratingtask.data.mappers.DatumMapper;
import linc.com.inratingtask.data.models.ResponseModel;
import linc.com.inratingtask.domain.models.DatumEntity;
import retrofit2.Response;

public class MainRepositoryImpl implements MainRepository {

    private PostApi postApi;
    private JsonObject apiBody;
    private DatumMapper datumMapper;

    public MainRepositoryImpl(PostApi postApi, JsonObject apiBody, DatumMapper datumMapper) {
        this.postApi = postApi;
        this.apiBody = apiBody;
        this.datumMapper = datumMapper;
    }

    @Override
    public Single<List<DatumEntity>> getLikers(String token) {
        return Single.create((SingleOnSubscribe<List<DatumEntity>>) emitter -> {
            Response<ResponseModel> response = postApi.getLikers(token, apiBody).execute();
            emitter.onSuccess(
                    datumMapper.datumToEntityList(response.body().getData())
            );
        }).subscribeOn(Schedulers.io());
    }

    @Override
    public Single<List<DatumEntity>> getCommentators(String token) {
        return Single.create((SingleOnSubscribe<List<DatumEntity>>) emitter -> {
            Response<ResponseModel> response = postApi.getCommentators(token, apiBody).execute();
            emitter.onSuccess(
                    datumMapper.datumToEntityList(response.body().getData())
            );
        }).subscribeOn(Schedulers.io());
    }

    @Override
    public Single<List<DatumEntity>> getMentions(String token) {
        return Single.create((SingleOnSubscribe<List<DatumEntity>>) emitter -> {
            Response<ResponseModel> response = postApi.getMentions(token, apiBody).execute();
            emitter.onSuccess(
                    datumMapper.datumToEntityList(response.body().getData())
            );
        }).subscribeOn(Schedulers.io());
    }

    @Override
    public Single<List<DatumEntity>> getReposters(String token) {
        return Single.create((SingleOnSubscribe<List<DatumEntity>>) emitter -> {
            Response<ResponseModel> response = postApi.getReposters(token, apiBody).execute();
            emitter.onSuccess(
                    datumMapper.datumToEntityList(response.body().getData())
            );
        }).subscribeOn(Schedulers.io());
    }


}