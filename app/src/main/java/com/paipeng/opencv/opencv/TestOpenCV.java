package com.paipeng.opencv.opencv;

import android.graphics.Bitmap;
import android.util.Log;

import org.opencv.android.Utils;
import org.opencv.core.CvException;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

/**
 * Created by paipeng on 12/07/15.
 */
public class TestOpenCV {
    private Mat new_image;
    public TestOpenCV() {

    }

    public Mat createMat() {
        new_image = new Mat(512, 512, CvType.CV_8U, new Scalar(4));
        new_image.setTo(new Scalar(255, 255, 255));
        return new_image;
    }

    public void releaseMat() {
        new_image.release();
    }

    public Bitmap convertMatToBitmap(Mat seedsImage) {
        Bitmap bmp = null;
        Mat tmp = new Mat (seedsImage.height(), seedsImage.width(), CvType.CV_8U, new Scalar(4));
        try {
            //Imgproc.cvtColor(seedsImage, tmp, Imgproc.COLOR_RGB2BGRA);
            Imgproc.cvtColor(seedsImage, tmp, Imgproc.COLOR_GRAY2RGBA, 4);
            bmp = Bitmap.createBitmap(tmp.cols(), tmp.rows(), Bitmap.Config.ARGB_8888);
            Utils.matToBitmap(tmp, bmp);
        }
        catch (CvException e){
            Log.d("Exception", e.getMessage());
        }
        return bmp;
    }
}
