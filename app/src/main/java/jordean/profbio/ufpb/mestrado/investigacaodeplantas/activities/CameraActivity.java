package jordean.profbio.ufpb.mestrado.investigacaodeplantas.activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Surface;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import jordean.profbio.ufpb.mestrado.investigacaodeplantas.R;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.util.AppStrings;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.util.ImageSurfaceView;


public class CameraActivity extends AppCompatActivity {

    private ImageSurfaceView mImageSurfaceView;
    private Camera camera;

    private FrameLayout cameraPreviewLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        cameraPreviewLayout = findViewById(R.id.camera_preview);

        camera = checkDeviceCamera();
        camera.setDisplayOrientation(90);

        //STEP #1: Get rotation degrees
        Camera.CameraInfo info = new Camera.CameraInfo();
        Camera.getCameraInfo(Camera.CameraInfo.CAMERA_FACING_BACK, info);
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        int degrees = 0;
        switch (rotation) {
            case Surface.ROTATION_0: degrees = 0; break; //Natural orientation
            case Surface.ROTATION_90: degrees = 90; break; //Landscape left
            case Surface.ROTATION_180: degrees = 180; break;//Upside down
            case Surface.ROTATION_270: degrees = 270; break;//Landscape right
        }
        int rotate = (info.orientation - degrees + 360) % 360;

        //STEP #2: Set the 'rotation' parameter
        Camera.Parameters params = camera.getParameters();
        params.setRotation(rotate);
        camera.setParameters(params);


        mImageSurfaceView = new ImageSurfaceView(CameraActivity.this, camera);
        cameraPreviewLayout.addView(mImageSurfaceView);

        ImageView captureButton = findViewById(R.id.butao);
        captureButton.setOnClickListener(v -> camera.takePicture(null, null, pictureCallback));
    }

    private Camera checkDeviceCamera() {
        Camera mCamera = null;
        try {
            mCamera = Camera.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mCamera;
    }

    Camera.PictureCallback pictureCallback = getPictureCallback();

    private Camera.PictureCallback getPictureCallback() {
        return (data, camera) -> {

            String imageFileName = "IMG_" + System.currentTimeMillis() + ".jpg";

            File diretorioDoApp = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + AppStrings.NOME_DIRETORIO_APP);
            if (!diretorioDoApp.exists()) {
                diretorioDoApp.mkdir();
            }

            File file = new File(diretorioDoApp + File.separator + imageFileName);

            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(data);
                fileOutputStream.flush();
                fileOutputStream.close();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("file_name", file.getAbsolutePath());

                setResult(-1, resultIntent); // OK!
                Toast.makeText(CameraActivity.this, "Imagem salva em " + file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
                finish();
            } catch (IOException e) {
                setResult(1);
                e.printStackTrace();
                finish();
            } catch (Exception exception) {
                setResult(2);
                exception.printStackTrace();
                finish();
            }
        };
    }

    public void onResume() {

        super.onResume();
        if (camera == null) {
            camera = Camera.open();
            camera.setDisplayOrientation(90);
            pictureCallback = getPictureCallback();
            mImageSurfaceView.refreshCamera(camera);
            Log.d("nu", "null");
        } else {
            Log.d("nu", "no null");
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        //when on Pause, release camera in order to be used from other applications
        releaseCamera();
    }

    private void releaseCamera() {
        // stop and release camera
        if (camera != null) {
            camera.stopPreview();
            camera.setPreviewCallback(null);
            camera.release();
            camera = null;
        }
    }
}
