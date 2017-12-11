package agung.app.com.retrofit.Interactor;

import android.text.TextUtils;
import android.os.Handler;

import agung.app.com.retrofit.Network.Model.UserResponse;

/**
 * Created by agung on 12/7/2017.
 */

public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void login(String username, String password, UserResponse userResponse, OnLoginFinishedListener listener) {
        new Handler().postDelayed(() ->{
            if (username.isEmpty()) {
                listener.onUserNameError("Username kosong");
                return;
            } else if (password.isEmpty()) {
                listener.onPasswordError("Password Kosong");
                return;
            } else {
                if (!username.equals(userResponse.getUsername())) {
                    listener.onUserNameError("Username Salah");
                    return;
                } else if (!password.equals(userResponse.getEncrypted_password())) {
                    listener.onPasswordError("Password yang dimasukkan salah");
                    return;
                }
            }
//            if(TextUtils.isEmpty(username)){
//                listener.onUserNameError("Username tidak boleh kosong");
//                return;
//            }
//            else{
//                if(userResponse == null){
//                    listener.onUserNameError("Username belum terdaftar");
//                    return;
//                }
//                else if(!username.equals(userResponse.getUsername())){
//                    listener.onUserNameError("Username yang dimasukkan salah");
//                    return;
//                }
//            }
//            if(TextUtils.isEmpty(password)){
//                listener.onPasswordError("Password tidak boleh kosong");
//                return;
//            }else{
//                if(!password.equals(userResponse.getEncrypted_password())){
//                    listener.onPasswordError("Password yang dimasukkan salah");
//                    return;
//                }
//            }
            listener.onSuccess();
        }, 5000);
    }
}
