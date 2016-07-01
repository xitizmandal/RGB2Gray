/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgb2gray;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorConvertOp;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RenderedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.GrayFilter;

/**
 *
 * @author xitiz
 */
public class GrayFilterUse {
    BufferedImage colorImage,image;
    String grayScale = "test";
    
        public static BufferedImage javaWay(BufferedImage source) {
        BufferedImageOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
        return op.filter(source, null);
    }
    
     
    GrayFilterUse(){
        try{
            File input = new File("pics/xtiz.jpg");
            colorImage = ImageIO.read(input);
            
            image = javaWay(colorImage);
            
            File ouptut = new File("pics/" + grayScale +".jpg");
            ImageIO.write((BufferedImage) image, "jpg", ouptut);
        } catch (Exception e){
        }
    }
   
}
