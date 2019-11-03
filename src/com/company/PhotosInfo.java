package com.company;

import org.opencv.core.Point3;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PhotosInfo {
    public static List<Photo> photos = new ArrayList<>();

    public void receivePhoto(String image, double height, double longitude, double latitude,
                             double yaw, double roll, double pitch){

        MathTransform.height = -height;

        double rad = (latitude * Math.PI) / 180;
        double dist = (40000 * Math.cos(rad) / 360) * 1000;

        roll *= -1;
        Matrices.buildYawMatrix(MathTransform.degreeToRadian(yaw));
        Matrices.buildRollMatrix(MathTransform.degreeToRadian(roll));
        Matrices.buildPitchMatrix(MathTransform.degreeToRadian(pitch));
        Point3 leftTopCorner = MathTransform.getMatrixPointOnGround(new Point3(0, 0, 0), "leftTopCorner");
        Point3 rightTopCorner = MathTransform.getMatrixPointOnGround(new Point3(0, 0, 0), "rightTopCorner");
        Point3 leftBottomCorner = MathTransform.getMatrixPointOnGround(new Point3(0, 0, 0), "leftBottomCorner");
        Point3 rightBottomCorner = MathTransform.getMatrixPointOnGround(new Point3(0, 0, 0), "rightBottomCorner");
        photos.add(new Photo(image, height, new Point3(longitude + leftTopCorner.x / dist, latitude + leftTopCorner.y / 111320.0, 0),
                new Point3(longitude + rightTopCorner.x / dist, latitude + rightTopCorner.y / 111320.0, 0),
                new Point3(longitude + rightBottomCorner.x / dist, latitude + rightBottomCorner.y / 111320.0, 0),
                new Point3(longitude + leftBottomCorner.x / dist, latitude + leftBottomCorner.y / 111320.0, 0)));
}
    public static void clearPhotos(){
        photos.clear();
    }
    public class Photo{
        private String image;
        private double height;
        private Point3 leftTopCorner, rightTopCorner, leftBottomCorner, rightBottomCorner;

        public Photo(String image, double height, Point3 leftTopCorner, Point3 rightTopCorner, Point3 rightBottomCorner, Point3 leftBottomCorner){
            this.image = image;
            this.height = height;
            this.leftTopCorner = leftTopCorner;
            this.rightTopCorner = rightTopCorner;
            this.leftBottomCorner = leftBottomCorner;
            this.rightBottomCorner = rightBottomCorner;
        }


        public String getImage() {
            return image;
        }

        public Point3 getLeftTopCorner() {
            return leftTopCorner;
        }

        public Point3 getRightTopCorner() {
            return rightTopCorner;
        }

        public Point3 getLeftBottomCorner() {
            return leftBottomCorner;
        }

        public Point3 getRightBottomCorner() {
            return rightBottomCorner;
        }

        public double getHeight() { return height; }
    }
}
