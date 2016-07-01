/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgb2gray;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;



/**
 *
 * @author xitiz
 */
public class PixelLocation {
    BufferedImage image;
    int height;
    int width;
    
    
    public PixelLocation(){
        try{
            File input = new File("pics/test2.jpg");
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();
            
            BackThread backThreadOne = new BackThread(1,0,height,0,width,image);
            //BackThread backThreadTwo = new BackThread(2,0,height/2,width/2,width,image);
            //BackThread backThreadThree = new BackThread(3,height/2,height,0,width/2,image);
            //BackThread backThreadFour = new BackThread(4,height/2,height,width/2,width,image);
            
//            int count = 0;
            
//            for(int i = 0; i < height; i++){
//                for(int j = 0; j < width; j = j + 1){
//                    //count++;
//                    Color c = new Color(image.getRGB(j,i));
//                    System.out.println("Pixel (" + j + "," + i +") : Red =  " + c.getRed()
//                    + " Green = " + c.getGreen() + " Blue = " + c.getBlue());
//                    
//                    int red = (int)(c.getRed() * 0.299);
//                    int green = (int)(c.getGreen() * 0.587);
//                    int blue = (int)(c.getBlue() *0.114);
//                    Color newColor = new Color(red+green+blue,
//
//                    red+green+blue,red+green+blue);
//
//                    image.setRGB(j,i,newColor.getRGB());
//                }
//            }
            
           
            
        } catch (Exception e){
            //Ahile add garamla kei chaina
        }
        
    }
}

