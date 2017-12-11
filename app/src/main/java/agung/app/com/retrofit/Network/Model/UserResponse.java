package agung.app.com.retrofit.Network.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by agung on 12/11/2017.
 */

public class UserResponse implements Serializable {
    @SerializedName("id") private int id;
    @SerializedName("unique_id") private String unique_id;
    @SerializedName("nama")private String username;
    @SerializedName("email")private String email;
    @SerializedName("encrypted_password")private String encrypted_password;
    @SerializedName("salt")private String salt;

    public UserResponse(){

    }

    public UserResponse(int id, String unique_id, String username, String email, String encrypted_password, String salt) {
        this.id = id;
        this.unique_id = unique_id;
        this.username = username;
        this.email = email;
        this.encrypted_password = encrypted_password;
        this.salt = salt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncrypted_password() {
        return encrypted_password;
    }

    public void setEncrypted_password(String encrypted_password) {
        this.encrypted_password = encrypted_password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
