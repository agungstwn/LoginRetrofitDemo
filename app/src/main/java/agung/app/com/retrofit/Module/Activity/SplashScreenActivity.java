package agung.app.com.retrofit.Module.Activity;

import android.Manifest;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.anthonycr.grant.PermissionsManager;
import com.anthonycr.grant.PermissionsResultAction;

import agung.app.com.retrofit.R;
import agung.app.com.retrofit.Widget.SimpleSnackbar;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        PermissionsManager.getInstance().
                requestPermissionsIfNecessaryForResult(SplashScreenActivity.this, new String[]{
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                }, new PermissionsResultAction() {
                    @Override
                    public void onGranted() {
                        navigatePage();
                    }

                    @Override
                    public void onDenied(String permission) {
                        SimpleSnackbar.showError(findViewById(R.id.mRootView), "Izin ditolak, tidak dapat membuka Aplikasi.");
                    }
                });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        PermissionsManager.getInstance().notifyPermissionsChange(permissions, grantResults);
    }

    private void navigatePage() {
        new Handler().postDelayed(() -> {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        }, 5000);
    }
}
