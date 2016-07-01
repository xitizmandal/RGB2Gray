/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgb2gray;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author xitiz
 */
public class Shrink {
    private BufferedImage image;
    private String output;
    
    public Shrink(String inputImage,String outputImage){
        BufferedImage outImage;
        try{
            File input = new File("pics/" + inputImage +".jpg");
            image = ImageIO.read(input);
            int height = image.getHeight();
            int width = image.getWidth();
            int conversionFactor;
            
            if((height/256) >= (width/192)){
                conversionFactor = (height/256);
            } else {
                conversionFactor = (width/192);
            }
            
            outImage = enlarge(image,conversionFactor);
            
            File output = new File("pics/shrink/"+ outputImage +".jpg");
            ImageIO.write(outImage, "jpg", output);
            System.out.println("Size converted");
            
        } catch (Exception e){
            
        }
        
    }
    
    static BufferedImage enlarge(BufferedImage image, int n) {
        int w = image.getWidth() / n;
        int h = image.getHeight() / n;

        BufferedImage shrunkImage = new BufferedImage(w, h, image.getType());

        for (int y = 0; y < h; ++y){
          for (int x = 0; x < w; ++x){
            shrunkImage.setRGB(x, y, image.getRGB(x * n, y * n));
          }
        }
        return shrunkImage;
      }
}
