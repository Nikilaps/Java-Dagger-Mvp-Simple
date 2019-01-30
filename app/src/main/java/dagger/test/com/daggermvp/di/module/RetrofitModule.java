package dagger.test.com.daggermvp.di.module;


import dagger.Module;
import dagger.Provides;
import dagger.test.com.daggermvp.BuildConfig;
import dagger.test.com.daggermvp.data.remote.APIInterface;
import dagger.test.com.daggermvp.di.anno.DomainUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static dagger.test.com.daggermvp.utils.AppConstants.LIVE_DOMAIN_URL;
import static dagger.test.com.daggermvp.utils.AppConstants.LOCAL_DOMAIN_URL;

@Module
public class RetrofitModule {

    @Provides
    APIInterface getApiInterface(Retrofit retroFit) {
        return retroFit.create(APIInterface.class);
    }

    @Provides
    Retrofit getRetrofit(OkHttpClient okHttpClient, @DomainUrl String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    OkHttpClient getOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    @Provides
    HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    @Provides
    @DomainUrl
    String getDomainUrl() {
        switch (BuildConfig.BUILD_TYPE) {
            case "release":
                return LIVE_DOMAIN_URL;
            case "debug":
                return LOCAL_DOMAIN_URL;
            default:
                return LIVE_DOMAIN_URL;
        }
    }
}
