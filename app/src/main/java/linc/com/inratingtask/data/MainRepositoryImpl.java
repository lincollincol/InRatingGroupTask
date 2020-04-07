package linc.com.inratingtask.data;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import linc.com.inratingtask.data.api.PostApi;
import linc.com.inratingtask.data.mappers.DatumMapper;
import linc.com.inratingtask.data.models.Datum;
import linc.com.inratingtask.data.models.ResponseModel;
import linc.com.inratingtask.domain.models.DatumEntity;
import retrofit2.Call;
import retrofit2.Callback;
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

/*

JsonObject joo = new JsonObject();
        joo.addProperty("id", "2720");
        postApi.getLikers(token, joo)
                .enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                        if(response.isSuccessful()) {
                            for (Datum d : response.body().getData()) {
                                Log.d("RESPONSE", d.getNickname());
                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {
                        Log.d("RESPONSE", t.getLocalizedMessage());
                    }
                });



postApi.getLikers(token, apiBody)
                    .map(responseModel -> datumMapper.datumToEntityList(responseModel.getData()))
                    .subscribeOn(Schedulers.io());
 */