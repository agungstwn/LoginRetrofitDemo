package agung.app.com.retrofit.Network;

import agung.app.com.retrofit.Network.Model.UserResponse;
import retrofit2.Call;

/**
 * Created by agung on 12/11/2017.
 */

public class UserApiService {
    private static UserApiService instance;

    public static UserApiService getInstance(){
        if(instance == null){
            instance = new UserApiService();
        }
        return instance;
    }

    public UserApiService() {
    }

    public Call<UserResponse> login(String username){
        return ApiServer.getUserApi().login(username);
    }
}
