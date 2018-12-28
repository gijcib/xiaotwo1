package image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by luojiawei on 2018/12/24.
 */

/**
 * high quality zoom
 */


/**
 * low quality zoom
 */
public class ZoomPic {

    public String srcPic = "D:\\c\\imageCut\\zoom0.jpg";
    public String trgtPic = "D:\\c\\imageCut\\zoom5.jpg";
    //目标宽:1088*0.75=756.0
    public int trgWidth = 756;
    public double orgW=1088.0;
    //目标高:762*0.75=571.5
    public int trgHeight = 518;
    public double orgH = 762.0;

    public void zoomPicSmaller() throws IOException {
        File sourcePic = new File(srcPic);
        File targetPic = new File(trgtPic);
        if(!targetPic.exists()){
            targetPic.createNewFile();
        }

        //读取图片
        BufferedImage bfImg = ImageIO.read(sourcePic);
        //设置缩放目标图片模板？
        Image tempPic = bfImg.getScaledInstance(trgWidth,trgHeight,bfImg.SCALE_SMOOTH);

        AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(0.33,0.33),null);
        tempPic = ato.filter(bfImg,null);

        ImageIO.write((BufferedImage)tempPic,trgtPic.substring(trgtPic.lastIndexOf(".")+1),targetPic);
    }


    public static void main(String[] args) throws IOException {

        ZoomPic z1 = new ZoomPic();
        z1.zoomPicSmaller();

    }

}
