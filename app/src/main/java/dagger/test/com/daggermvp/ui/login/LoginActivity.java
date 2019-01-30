package dagger.test.com.daggermvp.ui.login;

import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.widget.Toast;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.test.com.daggermvp.R;
import dagger.test.com.daggermvp.ui.base.BaseActivity;

public class LoginActivity extends BaseActivity implements LoginMvpView {

    @Inject
    LoginPresenter mPresenter;

    @BindView(R.id.edt_username)
    AppCompatEditText mEdtUsername;
    @BindView(R.id.edt_password)
    AppCompatEditText mEdtPassword;
    @BindView(R.id.btn_login)
    AppCompatButton mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getMActivityComponent().inject(this);
        ButterKnife.bind(this);

        mPresenter.attachView(this);
        mBtnLogin.setOnClickListener(v -> {
            String username = Objects.requireNonNull(mEdtUsername.getText()).toString();
            String password = Objects.requireNonNull(mEdtPassword.getText()).toString();
            mPresenter.checkLogin(username, password);
        });

    }

    @Override
    public void showUsernameEmptyMessage() {

    }

    @Override
    public void showPasswordEmptyMessage() {

    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFail() {
        Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
