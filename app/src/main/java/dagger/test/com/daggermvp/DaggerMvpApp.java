package dagger.test.com.daggermvp;

import android.app.Application;
import android.content.Context;

import dagger.test.com.daggermvp.di.components.ApplicationComponent;
import dagger.test.com.daggermvp.di.components.DaggerApplicationComponent;
import dagger.test.com.daggermvp.di.module.ApplicationModule;

public class DaggerMvpApp extends Application {

    ApplicationComponent mApplicationComponent;

    public static DaggerMvpApp get(Context context) {
        return (DaggerMvpApp) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {

        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this)).build();
            mApplicationComponent.injectApplication(this);
        }

        return mApplicationComponent;
    }
}
