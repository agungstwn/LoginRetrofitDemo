package agung.app.com.retrofit.Module.View;

/**
 * Created by agung on 12/7/2017.
 */

public interface LoginView {
    void showProgress();
    void hideProgress();
    void setUsernameError(String error);
    void setPasswordError(String error);
    void navigateToHome();
}
