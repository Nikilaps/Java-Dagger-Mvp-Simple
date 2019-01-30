package dagger.test.com.daggermvp.di.module;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import dagger.test.com.daggermvp.di.anno.ActivityContext;
import dagger.test.com.daggermvp.di.scopes.ApplicationScope;
import io.reactivex.disposables.CompositeDisposable;


@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    @ApplicationScope
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @ApplicationScope
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    @ApplicationScope
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }


}
