package dagger.test.com.daggermvp.ui.base;

public interface Presenter<T extends MvpView> {

    void attachView(T mvpView);

    void detachView();
}
