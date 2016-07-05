/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgb2gray;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author xitiz
 */
public class Compare {
    private BufferedImage image;
    private int height;
    private int width;
    
    public Compare(String input,String output, int xLoc, int yLoc){
        try{
            File file = new File("pics/"+input+".jpg");
            image = ImageIO.read(file);
            height = image.getHeight();
            width = image.getWidth();
            
//            Color[][] imageArray = new Color[width][height];
//            
//            for (int i = 0; i < height; i++){
//                for(int j = 0; j < width; j++){
//                    Color c = new Color(image.getRGB(j,i));
//                    imageArray[j][i] = c;
//                    System.out.println(j+" "+i+" "+imageArray[j][i]);
//                }
//            }
            
            Graphics2D graph = image.createGraphics();
            Color transparent = new Color(255,0,0,100);
            graph.setColor(transparent);
            graph.fill(new Rectangle(xLoc, yLoc, 30, 30));
            graph.dispose();

            File ouptut = new File("pics/detect/" + output + ".jpg");
            ImageIO.write(image, "jpg", ouptut);
            
        } catch (Exception e){
            
        }
    }
}
