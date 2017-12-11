package agung.app.com.retrofit.Module.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import agung.app.com.retrofit.MainActivity;
import agung.app.com.retrofit.Module.Presenter.LoginPresenter;
import agung.app.com.retrofit.Module.Presenter.LoginPresenterImpl;
import agung.app.com.retrofit.Module.View.LoginView;
import agung.app.com.retrofit.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends Activity implements LoginView {

    @BindView(R.id.progress)ProgressBar progressBar;
    @BindView(R.id.username)EditText username;
    @BindView(R.id.password)EditText password;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenter = new LoginPresenterImpl(this);
    }

    @OnClick({R.id.button})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                presenter.validateCredentials(username.getText().toString(), password.getText().toString());
                break;
        }
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError(String error) {
        username.setError(error);
        username.requestFocus();
    }

    @Override
    public void setPasswordError(String error) {
        password.setError(error);
        password.requestFocus();
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
