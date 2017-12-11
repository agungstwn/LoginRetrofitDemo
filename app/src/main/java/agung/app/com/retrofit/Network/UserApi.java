package agung.app.com.retrofit.Network;

import agung.app.com.retrofit.Network.Model.UserResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by agung on 12/11/2017.
 */

public interface UserApi {
    @GET("/login")
    Call<UserResponse> login(@Query("u") String username);
}
