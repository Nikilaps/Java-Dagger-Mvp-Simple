package dagger.test.com.daggermvp.ui.base;


public class BasePresenter<V extends MvpView> implements Presenter<V> {

    private V mMvpView;

    @Override
    public void attachView(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) {
            throw new ViewNotAttachedException();
        }

    }

    public V getMvpView() {
        return mMvpView;
    }

    private boolean isViewAttached() {
        return mMvpView != null;
    }

    public static class ViewNotAttachedException extends RuntimeException {
        ViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}
