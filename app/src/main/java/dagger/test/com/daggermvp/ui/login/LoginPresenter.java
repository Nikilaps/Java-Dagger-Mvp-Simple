package dagger.test.com.daggermvp.ui.login;

import android.content.Context;
import android.text.TextUtils;

import javax.inject.Inject;

import dagger.test.com.daggermvp.data.model.api.ResponseModel;
import dagger.test.com.daggermvp.data.remote.APIInterface;
import dagger.test.com.daggermvp.di.anno.ApplicationContext;
import dagger.test.com.daggermvp.ui.base.BasePresenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter extends BasePresenter<LoginMvpView> {
    private final CompositeDisposable mCompositeDisposable;
    private APIInterface apiInterface;
    private Context context;

    @Inject
    public LoginPresenter(CompositeDisposable compositeDisposable,
                          APIInterface apiInterface,
                          @ApplicationContext Context context) {
        this.mCompositeDisposable = compositeDisposable;
        this.apiInterface = apiInterface;
        this.context = context;
    }

    @Override
    public void attachView(LoginMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    void checkLogin(String username, String password) {
        boolean isValid = true;
        if (TextUtils.isEmpty(username)) {
            isValid = false;
            getMvpView().showUsernameEmptyMessage();
        }

        if (TextUtils.isEmpty(password)) {
            isValid = false;
            getMvpView().showPasswordEmptyMessage();
        }

        if (isValid) {
            mCompositeDisposable.add(apiInterface.login(username, password)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<ResponseModel>() {
                        @Override
                        public void onNext(ResponseModel response) {
                           getMvpView().onLoginSuccess();
                        }

                        @Override
                        public void onError(Throwable e) {
                            getMvpView().onLoginFail();
                        }


                        @Override
                        public void onComplete() {

                        }
                    }));
        }
    }
}
