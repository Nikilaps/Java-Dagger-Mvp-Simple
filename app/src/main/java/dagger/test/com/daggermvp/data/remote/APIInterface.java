package dagger.test.com.daggermvp.data.remote;

import dagger.test.com.daggermvp.data.model.api.ResponseModel;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIInterface {

    @FormUrlEncoded
    @POST("5c5023f6330000e224c586f5")
    Observable<ResponseModel> login(
            @Field("email") String email,
            @Field("password") String password);
}
