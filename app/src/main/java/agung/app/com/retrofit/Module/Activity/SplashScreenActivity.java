package agung.app.com.retrofit.Module.Activity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.anthonycr.grant.PermissionsManager;
import com.anthonycr.grant.PermissionsResultAction;

import agung.app.com.retrofit.R;
import agung.app.com.retrofit.Widget.SimpleSnackbar;
import butterknife.BindView;

public class SplashScreenActivity extends AppCompatActivity {
private TextView tv;
private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        String img_Splash = getResources().getString(R.string.img_splash);
        ImageView view = findViewById(R.id.image_splash);

        byte[] imageBytes = Base64.decode(img_Splash, Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        view.setImageBitmap(decodedImage);

        tv = (TextView) findViewById(R.id.text_splash);
        iv = (ImageView) findViewById(R.id.image_splash);
        Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.transition);
        tv.startAnimation(myAnim);
        iv.startAnimation(myAnim);

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
