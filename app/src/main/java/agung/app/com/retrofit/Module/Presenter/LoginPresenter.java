package agung.app.com.retrofit.Module.Presenter;

/**
 * Created by agung on 12/7/2017.
 */

public interface LoginPresenter {
    void validateCredentials(String username, String password);
    void onDestroy();
}
