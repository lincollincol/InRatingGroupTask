package linc.com.inratingtask.di.module;

import com.google.gson.JsonObject;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import linc.com.inratingtask.data.MainRepository;
import linc.com.inratingtask.data.MainRepositoryImpl;
import linc.com.inratingtask.data.api.PostApi;
import linc.com.inratingtask.data.mappers.ActiveGiftMapper;
import linc.com.inratingtask.data.mappers.AvatarImageMapper;
import linc.com.inratingtask.data.mappers.DatumMapper;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static linc.com.inratingtask.utils.Constants.*;

@Module
public class DataModule {

    @Provides
    public MainRepository provideRepository(PostApi postApi, JsonObject apiBody, DatumMapper datumMapper) {
        return new MainRepositoryImpl(postApi, apiBody, datumMapper);
    }

    @Provides
    public PostApi providePostApi(Retrofit retrofit) {
        return retrofit.create(PostApi.class);
    }

    @Provides
    public Retrofit provideRetrofit(OkHttpClient client, GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    public JsonObject provideApiBody() {
        JsonObject apiBody = new JsonObject();
        apiBody.addProperty(BODY_PARAM, BODY_VALUE);
        return apiBody;
    }

    @Provides
    @Singleton
    public HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BASIC);
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(HttpLoggingInterceptor interceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
    }

    @Provides
    @Singleton
    public GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    public DatumMapper provideDatumMapper(ActiveGiftMapper activeGiftMapper, AvatarImageMapper avatarImageMapper) {
        return new DatumMapper(activeGiftMapper, avatarImageMapper);
    }

    @Provides
    @Singleton
    public ActiveGiftMapper provideActiveGiftMapper() {
        return new ActiveGiftMapper();
    }

    @Provides
    @Singleton
    public AvatarImageMapper provideAvatarImageMapper() {
        return new AvatarImageMapper();
    }
}
