package tt.escom.ipn.avalosbarrera.transportec;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by laavalos on 5/22/2018.
 */

public class InitialActivity extends AppCompatActivity{

    private final int SPLASH_DISPLAY_LENGTH = 2500;
    private  final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 100;
    private  final int PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION = 101;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(InitialActivity.this, MainActivity.class));
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

}
