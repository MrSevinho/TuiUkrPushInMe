package com.company;

import java.applet.Applet;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

public class Task4 extends Applet {
    public static double[] listOfCoords;
    public static boolean ok;
    public static void solveTask4(){
        int n = PhotosInfo.photos.size();
        List<Area> areaList = new ArrayList<>();
        Image[] arrayOfImages = new Image[n];
        int currIndex = 0;



        for(int i = 0; i < PhotosInfo.photos.size(); i++){
            Path2D.Double path = new Path2D.Double();
            path.moveTo(PhotosInfo.photos.get(i).getLeftTopCorner().x, PhotosInfo.photos.get(i).getLeftTopCorner().y);
            path.lineTo(PhotosInfo.photos.get(i).getRightTopCorner().x, PhotosInfo.photos.get(i).getRightTopCorner().y);
            path.lineTo(PhotosInfo.photos.get(i).getRightBottomCorner().x, PhotosInfo.photos.get(i).getRightBottomCorner().y);
            path.lineTo(PhotosInfo.photos.get(i).getLeftBottomCorner().x, PhotosInfo.photos.get(i).getLeftBottomCorner().y);
            path.closePath();

            Shape temp = path;
            areaList.add(new Area(temp));
        }

        boolean[][] matrix = new boolean[n + 1][n + 1];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(check(areaList.get(i), areaList.get(j))) {
                    matrix[i][j] = true;
                    matrix[j][i] = true;
                }
                else {
                    matrix[i][j] = false;
                    matrix[j][i] = false;
                }
            }
        }
        int[] a = new int[n + 1];
        for(int i = 0; i <= n; ++i) {
            a[i] = i;
            matrix[n][i] = matrix[i][n] = true;
        }
        int[] path = PlanPath.init(matrix);
       ok = true;
        for (int i = 0; i + 1 < n; i++) {
            if (!matrix[path[i]][path[i + 1]]) {
                ok = false;
                break;
            }
        }
        a = path;
        if(ok) {
            listOfCoords = new double[n * 8];
            //  System.out.println("Result:");
            for(int i = 0; i < PhotosInfo.photos.size(); ++i) {
                //    System.out.print(a[i] + " ");
                listOfCoords[currIndex] = ( PhotosInfo.photos.get(a[i]).getLeftBottomCorner().x);  currIndex++;

                listOfCoords[currIndex] = ( PhotosInfo.photos.get(a[i]).getLeftBottomCorner().y);  currIndex++;
                listOfCoords[currIndex] = ( PhotosInfo.photos.get(a[i]).getRightBottomCorner().x);  currIndex++;
                listOfCoords[currIndex] = ( PhotosInfo.photos.get(a[i]).getRightBottomCorner().y);  currIndex++;
                listOfCoords[currIndex] = ( PhotosInfo.photos.get(a[i]).getRightTopCorner().x);  currIndex++;
                listOfCoords[currIndex] = ( PhotosInfo.photos.get(a[i]).getRightTopCorner().y); currIndex++;
                listOfCoords[currIndex] = (  PhotosInfo.photos.get(a[i]).getLeftTopCorner().x); currIndex++;
                listOfCoords[currIndex] = ( PhotosInfo.photos.get(a[i]).getLeftTopCorner().y); currIndex++;
             if(i < 4)   System.out.println(" i = " + i + " | " + PhotosInfo.photos.get(a[i]).getLeftBottomCorner().toString() + " " +
                        PhotosInfo.photos.get(a[i]).getRightBottomCorner().toString() + " " +
                        PhotosInfo.photos.get(a[i]).getRightTopCorner().toString() + " " +
                        PhotosInfo.photos.get(a[i]).getLeftTopCorner().toString());
            }
          //  for(int i = 0; i < PhotosInfo.photos.size(); i++)
            //    listOfImages.add(arrayOfImages[i]);
        }
        else {
            listOfCoords = new double[1];

            //  for(int i = 0; i < PhotosInfo.photos.size(); ++i) {
            //    System.out.print(a[i] + " ");
           /*     System.out.println(PhotosInfo.photos.get(i).getLeftBottomCorner().toString() + " " +
                        PhotosInfo.photos.get(i).getRightBottomCorner().toString() + " " +
                        PhotosInfo.photos.get(i).getRightTopCorner().toString() + " " +
                        PhotosInfo.photos.get(i).getLeftTopCorner().toString());*/
            // }
            // System.out.println("Incorrect data");
        }
       // return listOfCoords;
    }
    public static boolean check(Area a, Area b) {
        Area c = (Area)a.clone();
        Area d = (Area)b.clone();
        c.intersect(d);
        if(!c.getPathIterator(null).isDone()) {
            return true;
        }
        else return false;
    }
    public static double[] getData(){
        System.out.println("_______");
        return listOfCoords;
    }
}
