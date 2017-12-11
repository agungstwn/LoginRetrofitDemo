package agung.app.com.retrofit.Module.Presenter;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v7.util.SortedList;
import android.util.Log;

import agung.app.com.retrofit.Interactor.LoginInteractor;
import agung.app.com.retrofit.Interactor.LoginInteractorImpl;
import agung.app.com.retrofit.Module.View.LoginView;
import agung.app.com.retrofit.Network.Model.ApiServerService;
import agung.app.com.retrofit.Network.Model.UserResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by agung on 12/7/2017.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;
    UserResponse user;

    public LoginPresenterImpl(LoginView loginView){
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();

    }
    @Override
    public void validateCredentials(String username, String password) {
        if(loginView != null){
            loginView.showProgress();
        }
        ApiServerService.getInstance().getUserApiService().login(username).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(@NonNull Call<UserResponse> call, @NonNull Response<UserResponse> response) {
                new Handler(Looper.getMainLooper()).post(() -> {
                    if(response.isSuccessful()){
                        if(response.body() != null){
                            Log.e("Errorku", "onResponse: " + response.body().getUsername());
                            user = response.body();
                        }
                        else {
                            user = new UserResponse();
                            user.setUsername("");
                        }
                    }
                });

            }
            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });
        loginInteractor.login(username, password, user, this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }


    @Override
    public void onUserNameError(String error) {
        if(loginView != null){
            loginView.setUsernameError(error);
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError(String error) {
        if(loginView != null){
            loginView.setPasswordError(error);
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (loginView != null) {
            loginView.navigateToHome();

        }
    }
}
