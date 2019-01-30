package dagger.test.com.daggermvp.ui.login;

import dagger.test.com.daggermvp.ui.base.MvpView;

public interface LoginMvpView extends MvpView {

    void showUsernameEmptyMessage();

    void showPasswordEmptyMessage();

    void onLoginSuccess();

    void onLoginFail();
}