package dagger.test.com.daggermvp.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import dagger.test.com.daggermvp.DaggerMvpApp;
import dagger.test.com.daggermvp.di.components.ActivityComponent;
import dagger.test.com.daggermvp.di.components.DaggerActivityComponent;
import dagger.test.com.daggermvp.di.module.ActivityModule;

public class BaseActivity extends AppCompatActivity {

    ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(DaggerMvpApp.get(this).getComponent()).build();
    }

    public ActivityComponent getMActivityComponent() {
        return mActivityComponent;
    }
}
