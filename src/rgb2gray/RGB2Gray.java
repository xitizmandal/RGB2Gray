/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgb2gray;

import java.util.Scanner;

/**
 *
 * @author xitiz
 */
public class RGB2Gray {
    public static void main (String[] args){
        //PixelLocation pixelLocation = new PixelLocation();
        //GrayFilterUse grayFilterUse = new GrayFilterUse();
        //Compare compare = new Compare();
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter name of input image: \t");
        String input = reader.nextLine();
        System.out.print("Enter name of output image: \t");
        String output = reader.nextLine();
        Shrink shrink = new Shrink(input,output);
    }
}
