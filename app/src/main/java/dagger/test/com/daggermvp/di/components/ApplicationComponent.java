package dagger.test.com.daggermvp.di.components;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import dagger.test.com.daggermvp.DaggerMvpApp;
import dagger.test.com.daggermvp.di.anno.ApplicationContext;
import dagger.test.com.daggermvp.di.module.ApplicationModule;
import dagger.test.com.daggermvp.di.module.RetrofitModule;
import dagger.test.com.daggermvp.data.remote.APIInterface;

@Singleton
@Component(modules = {ApplicationModule.class, RetrofitModule.class})
public interface ApplicationComponent {

    APIInterface getApiInterface();

    @ApplicationContext
    Context getContext();

    void injectApplication(DaggerMvpApp daggerMvpApp);
}
