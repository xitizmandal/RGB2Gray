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
    String grayScale = "xitizGray";
    
    public PixelLocation(){
        try{
            File input = new File("pics/xitiz.jpg");
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();
            
//            int count = 0;
            
            for(int i = 0; i < height; i++){
                for(int j = 0; j < width; j = j + 1){
                    //count++;
                    Color c = new Color(image.getRGB(j,i));
                    System.out.println("Pixel (" + j + "," + i +") : Red =  " + c.getRed()
                    + " Green = " + c.getGreen() + " Blue = " + c.getBlue());
                    
                    int red = (int)(c.getRed() * 0.299);
                    int green = (int)(c.getGreen() * 0.587);
                    int blue = (int)(c.getBlue() *0.114);
                    Color newColor = new Color(red+green+blue,

                    red+green+blue,red+green+blue);

                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            
            File ouptut = new File("pics/" + grayScale +".jpg");
            ImageIO.write(image, "jpg", ouptut);
            
        } catch (Exception e){
            //Ahile add garamla kei chaina
        }
        
    }
}

