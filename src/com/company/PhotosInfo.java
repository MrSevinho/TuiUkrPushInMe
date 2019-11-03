package com.company;

import org.opencv.core.Point3;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PhotosInfo {
    public static List<Photo> photos = new ArrayList<>();

    public void receivePhoto(String image, double height, double longitude, double latitude,
                             double yaw, double roll, double pitch){
        yaw = roll = pitch = 0;
        Matrices.buildYawMatrix(MathTransform.degreeToRadian(yaw));
        Matrices.buildRollMatrix(MathTransform.degreeToRadian(roll));
        Matrices.buildPitchMatrix(MathTransform.degreeToRadian(pitch));
        Point3 leftTopCorner = MathTransform.getMatrixPointOnGround(new Point3(0, 0, height/* * 1000*/), "leftTopCorner");
    Point3 rightTopCorner = MathTransform.getMatrixPointOnGround(new Point3(0, 0, height/* * 1000*/), "rightTopCorner");
    Point3 leftBottomCorner = MathTransform.getMatrixPointOnGround(new Point3(0, 0, height/* * 1000*/), "leftBottomCorner");
    Point3 rightBottomCorner = MathTransform.getMatrixPointOnGround(new Point3(0, 0, height/* * 1000*/), "rightBottomCorner");

        photos.add(new Photo(image, height, new Point3(longitude + leftTopCorner.x / 71500.0, latitude + leftTopCorner.y / 111320.0, 0),
                new Point3(longitude + rightTopCorner.x / 71500.0, latitude + rightTopCorner.y / 111320.0, 0),
                new Point3(longitude + rightBottomCorner.x / 71500.0, latitude + rightBottomCorner.y / 111320.0, 0),
                new Point3(longitude + leftBottomCorner.x / 71500.0, latitude + leftBottomCorner.y / 111320.0, 0)));
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
