package agung.app.com.retrofit.Interactor;

import agung.app.com.retrofit.Network.Model.UserResponse;

/**
 * Created by agung on 12/7/2017.
 */

public interface LoginInteractor {
    interface OnLoginFinishedListener {

        void onSuccess();

        void onUserNameError(String error);

        void onPasswordError(String error);
    }
    void login(String username, String password, UserResponse userResponse, OnLoginFinishedListener listener);
}
