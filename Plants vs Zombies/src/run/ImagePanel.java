package run;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class ImagePanel extends JPanel {
	private Image img;
	private ArrayList<Image> sprites;

	public ImagePanel(String img) {
		this(new ImageIcon(img).getImage());
	}

	public ImagePanel(Image img) {
		this.sprites = new ArrayList<Image>();
		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}
	
	public void addSprite(Image sprite) {
		sprites.add(sprite);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
		
		for (int i = 1; i <= sprites.size(); i ++) {
			g.drawImage(sprites.get(i - 1), i * 15, 10, null);
		}
		
		this.sprites.clear();

	}

}
