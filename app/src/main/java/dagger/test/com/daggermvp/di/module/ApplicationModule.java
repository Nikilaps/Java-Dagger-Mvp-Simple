package dagger.test.com.daggermvp.di.module;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import dagger.test.com.daggermvp.di.anno.ApplicationContext;

@Module
public class ApplicationModule {

    private Application mApplication;


    public ApplicationModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

}
