package linc.com.inratingtask.data.api;

import com.google.gson.JsonObject;

import java.util.List;

import io.reactivex.Single;
import linc.com.inratingtask.data.models.Datum;
import linc.com.inratingtask.data.models.ResponseModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface PostApi {

    @POST("/v1/users/posts/likers/all")
    @Headers({ "Content-Type: application/json",
                "Accept: application/json"})
    Call<ResponseModel> getLikers(@Header("Authorization") String token, @Body JsonObject id);

    @POST("/v1/users/posts/reposters/all")
    Call<ResponseModel> getReposters(@Header("Authorization") String token, @Body JsonObject id);

    @POST("/v1/users/posts/commentators/all")
    Call<ResponseModel> getCommentators(@Header("Authorization") String token, @Body JsonObject id);

    @POST("/v1/users/posts/mentions/all")
    Call<ResponseModel> getMentions(@Header("Authorization") String token, @Body JsonObject id);

}
