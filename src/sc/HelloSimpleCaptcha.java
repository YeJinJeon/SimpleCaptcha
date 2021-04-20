package sc;
import java.io.File;
import java.awt.Color;
import java.awt.Image;
import java.awt.Font;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nl.captcha.Captcha;
import nl.captcha.backgrounds.GradiatedBackgroundProducer;
import nl.captcha.gimpy.DropShadowGimpyRenderer;
import nl.captcha.text.producer.DefaultTextProducer;
import nl.captcha.text.renderer.DefaultWordRenderer;


public class HelloSimpleCaptcha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int width = 250;
		int height = 50;
		int font_size = 40;
		List<Font> fontList = new ArrayList<Font>();
		fontList.add(new Font("���� ����", Font.BOLD, font_size));
		//fontList.add(new Font("����ü", Font.BOLD, font_size));
		//fontList.add(new Font("HY�׷���M", Font.BOLD, font_size));
		List<Color> colorList = new ArrayList<Color>(); 
		colorList.add(Color.BLACK);
		
		for(int i=0; i<500; i++) {
			try {
			    Captcha captcha = new Captcha.Builder(width, height)
			    .addText(new DefaultWordRenderer(colorList, fontList))
			    .addNoise().addNoise()
			    .addBorder()
			    .gimp(new DropShadowGimpyRenderer()).gimp()
			    .addBackground(new GradiatedBackgroundProducer())
			    .build();
			    
			    String answer = captcha.getAnswer();
			    
			    File file = new File("C:/Users/tanker002/data/captcha/"+answer+".png");
			    try {
			    	ImageIO.write(captcha.getImage(), "png", file);
			    } catch(IOException e) {
			    	System.out.println(e.toString());
			    }
			} catch(NullPointerException ignore) {}
		}
	}
}
