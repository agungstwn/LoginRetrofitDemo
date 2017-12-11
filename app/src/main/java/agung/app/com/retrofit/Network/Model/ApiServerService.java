package agung.app.com.retrofit.Network.Model;

import android.annotation.SuppressLint;

import agung.app.com.retrofit.Network.UserApiService;

/**
 * Created by agung on 12/11/2017.
 */

public class ApiServerService {
    @SuppressLint("StaticFieldLeak")
    private static ApiServerService instance;

    public ApiServerService() {
    }

    public static synchronized ApiServerService getInstance(){
        if(instance == null){
            instance = new ApiServerService();
        }
        return instance;
    }

    public UserApiService getUserApiService(){
        return UserApiService.getInstance();
    }
}
