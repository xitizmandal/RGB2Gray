/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgb2gray;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author xitiz
 */
public class BackThread extends Thread {
    int threadNo,startHeight,endHeight,startWidth,endWidth;
    BufferedImage image;
    String grayScale = "test2BW";
    int count = 0;
    
    BackThread(int threadNo,int startHeight,int endHeight,
            int startWidth, int endWidth, BufferedImage image){
        super("my extending thread");
        this.threadNo = threadNo;
        this.startHeight = startHeight;
        this.endHeight = endHeight;
        this.startWidth = startWidth;
        this.endWidth = endWidth;
        this.image = image;
        System.out.println("Thread " + threadNo  +" Created");
        start();
    }
    
    public void run(){
        try{
            for(int i = startHeight; i < endHeight; i++){
                for(int j = startWidth; j < endWidth; j = j + 1){
                    count++;
                    Color c = new Color(image.getRGB(j,i));
                    System.out.println("Pixel (" + j + "," + i +") : Red =  " + c.getRed()
                    + " Green = " + c.getGreen() + " Blue = " + c.getBlue());
              
                    int red = (int)(c.getRed()* 0.299);
                    int green = (int)(c.getGreen() * 0.587);
                    int blue = (int)(c.getBlue() *0.114);
                    int mix = (int) (red+green+blue);
                    if(mix < 128){
                        mix = 0;
                    } else {
                        mix = 255;
                    }
                    Color newColor = new Color(mix,

                    mix,mix);

                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            
             File ouptut = new File("pics/" + grayScale +".jpg");
            ImageIO.write(image, "jpg", ouptut);
            System.out.println(count);
        }
        catch(Exception e){
            System.out.println("my thread interrupted");
         }
    } 
}