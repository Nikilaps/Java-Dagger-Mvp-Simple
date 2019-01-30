package dagger.test.com.daggermvp.di.components;

import android.content.Context;

import dagger.Component;
import dagger.test.com.daggermvp.di.anno.ActivityContext;
import dagger.test.com.daggermvp.di.module.ActivityModule;
import dagger.test.com.daggermvp.di.scopes.ApplicationScope;
import dagger.test.com.daggermvp.ui.login.LoginActivity;

/**
 * ActivityComponent specify ApplicationComponent and ActivityModule.
 * ApplicationComponent is added to use the graph that has already been generated in the previous
 * step and do exists because the Application class persists till the application is running.
 */
@ApplicationScope
@Component(modules = ActivityModule.class, dependencies = ApplicationComponent.class)
public interface ActivityComponent {

    @ActivityContext
    Context getContext();

    void inject(LoginActivity loginActivity);
}
