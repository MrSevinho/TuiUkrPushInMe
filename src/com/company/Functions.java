package com.company;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import static java.lang.Math.sqrt;

public class Functions {
    PhotosInfo photosInfo = new PhotosInfo();
   public static Mat reSizeOnlyOne(Mat src) {
        double normalS = 500 * 500;
        double Sc = src.width() * src.height();
        double k = sqrt(Sc / normalS);
        if (k < 1) k = 1;
        Mat tra = new Mat(2, 3, CvType.CV_32FC1);
        tra.put(0, 0,
                1 / k, 0, 0,
                0, 1 / k, 0
        );
        Imgproc.warpAffine(src, src, tra, new Size(src.width() / k, src.height() / k));
        return src;
    }
    public static Mat BufferedImage2Mat(BufferedImage image) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", byteArrayOutputStream);
        byteArrayOutputStream.flush();
        return Imgcodecs.imdecode(new MatOfByte(byteArrayOutputStream.toByteArray()), Imgcodecs.CV_LOAD_IMAGE_UNCHANGED);
    }

    public static BufferedImage Mat2BufferedImage(Mat matrix) throws Exception {
        MatOfByte mob = new MatOfByte();
        Imgcodecs.imencode(".jpg", matrix, mob);
        byte ba[] = mob.toArray();

        BufferedImage bi = ImageIO.read(new ByteArrayInputStream(ba));
        return bi;
    }
    public  void readInfo(List< String > lines){
        int cnt = 0;
        for (String s : lines) {
            if (s.contains("img_idx")) {
                int currIndex = 10;
                String lat = "", lng = "", rel = "", roll = "", pitch = "", yaw = "";
                for (; currIndex < s.length(); currIndex++) {
                    if (s.charAt(currIndex) == 't' && s.charAt(currIndex - 1) == 'a' && s.charAt(currIndex - 2) == 'l') {
                        currIndex++;
                        currIndex++;
                        while (currIndex < s.length() && ((s.charAt(currIndex) >= '0' && s.charAt(currIndex) <= '9') || s.charAt(currIndex) == ',')) {
                            if (s.charAt(currIndex) == ',') lat += '.';
                            else lat += s.charAt(currIndex);
                            currIndex++;
                        }
                    }
                    if (s.charAt(currIndex) == 'g' && s.charAt(currIndex - 1) == 'n' && s.charAt(currIndex - 2) == 'l') {
                        currIndex++;
                        currIndex++;
                        while (currIndex < s.length() && ((s.charAt(currIndex) >= '0' && s.charAt(currIndex) <= '9') || s.charAt(currIndex) == ',')) {
                            if (s.charAt(currIndex) == ',') lng += '.';
                            else lng += s.charAt(currIndex);
                            currIndex++;
                        }
                    }
                    if (s.charAt(currIndex) == 'l' && s.charAt(currIndex - 1) == 'e' && s.charAt(currIndex - 2) == 'r') {
                        currIndex++;
                        currIndex++;
                        rel += s.charAt(currIndex);
                        currIndex++;
                        while (currIndex < s.length() && ((s.charAt(currIndex) >= '0' && s.charAt(currIndex) <= '9') || s.charAt(currIndex) == ',')) {
                            if (s.charAt(currIndex) == ',') rel += '.';
                            else rel += s.charAt(currIndex);
                            currIndex++;
                        }
                    }
                    if (s.charAt(currIndex) == 'l' && s.charAt(currIndex - 1) == 'l' && s.charAt(currIndex - 2) == 'o' && s.charAt(currIndex - 3) == 'r') {
                        currIndex++;
                        currIndex++;
                        roll += s.charAt(currIndex);
                        currIndex++;
                        while (currIndex < s.length() && ((s.charAt(currIndex) >= '0' && s.charAt(currIndex) <= '9') || s.charAt(currIndex) == ',')) {
                            if (s.charAt(currIndex) == ',') roll += '.';
                            else roll += s.charAt(currIndex);
                            currIndex++;
                        }
                    }
                    if (s.charAt(currIndex) == 'h' && s.charAt(currIndex - 1) == 'c' && s.charAt(currIndex - 2) == 't' && s.charAt(currIndex - 3) == 'i') {
                        currIndex++;
                        currIndex++;
                        pitch += s.charAt(currIndex);
                        currIndex++;
                        while (currIndex < s.length() && ((s.charAt(currIndex) >= '0' && s.charAt(currIndex) <= '9') || s.charAt(currIndex) == ',')) {
                            if (s.charAt(currIndex) == ',') pitch += '.';
                            else pitch += s.charAt(currIndex);
                            currIndex++;
                        }
                    }
                    if (s.charAt(currIndex) == 'w' && s.charAt(currIndex - 1) == 'a' && s.charAt(currIndex - 2) == 'y') {
                        currIndex++;
                        currIndex++;
                        yaw += s.charAt(currIndex);
                        currIndex++;
                        while (currIndex < s.length() && ((s.charAt(currIndex) >= '0' && s.charAt(currIndex) <= '9') || s.charAt(currIndex) == ',')) {
                            if (s.charAt(currIndex) == ',') yaw += '.';
                            else yaw += s.charAt(currIndex);
                            currIndex++;
                        }
                    }
                }
                System.out.println(Double.parseDouble(lat) / 10000000.0 + " lat");
                System.out.println(Double.parseDouble(lng) / 10000000.0 + " lng");
                System.out.println(rel + " rel");
                System.out.println(roll + " roll");
                System.out.println(pitch + " pitch");
                System.out.println(yaw + " yaw");
                photosInfo.receivePhoto(cnt + " ", Double.parseDouble(rel), Double.parseDouble(lng) / 10000000.0,
                        Double.parseDouble(lat) / 10000000.0, Double.parseDouble(yaw),
                        Double.parseDouble(roll), Double.parseDouble(pitch));
                cnt++;
            }
        }

    }
}