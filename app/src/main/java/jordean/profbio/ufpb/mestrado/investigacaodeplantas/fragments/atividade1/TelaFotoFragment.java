package jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import jordean.profbio.ufpb.mestrado.investigacaodeplantas.R;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.activities.CameraActivity;

import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class TelaFotoFragment extends Fragment {

    protected static final int CAMERA_ACTION_PICK_REQUEST_CODE_1 = 610;

    public TelaFotoFragment() {
        // Required empty public constructor
    }

    protected void openCamera(int requestCode) {
        Intent pictureIntent = new Intent(requireActivity(), CameraActivity.class);
        startActivityForResult(pictureIntent, requestCode);
    }


    protected void loadImage(String imagePath, ImageView imageView) {

        try {
            Uri uri = Uri.parse(imagePath);

            Bitmap bit = BitmapFactory.decodeFile(uri.getPath());

            ExifInterface exif = new ExifInterface(imagePath);
            int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION,
                    ExifInterface.ORIENTATION_NORMAL);

            if(orientation != 0) {
                bit = rotateImage(orientation, bit);
            }

            int width = getResources().getDimensionPixelSize(R.dimen.foto_w);
            int height = getResources().getDimensionPixelSize(R.dimen.foto_h);

            imageView.setImageBitmap(Bitmap.createScaledBitmap(bit, width, height, true));

        } catch(IOException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    private Bitmap rotateImage(int orientation, Bitmap bitmap) {
        int rotate = 0;
        switch (orientation) {
            case ExifInterface.ORIENTATION_ROTATE_270:
                rotate = 270;
                break;
            case ExifInterface.ORIENTATION_ROTATE_180:
                rotate = 180;
                break;
            case ExifInterface.ORIENTATION_ROTATE_90:
                rotate = 90;
                break;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(rotate);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
                bitmap.getHeight(), matrix, true);
    }

}
