package vues;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controleurs.MenuControleur;

/**
 *
 * @author Clément DOSDA, Louis FRIEDRICH, Loïc STEINMETZ, Julien TAVERNIER
 *
 */
class MenuVue extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton carre;
	private JButton triangle;
	private JButton cercle;
	private JButton polygone;

	
	public MenuVue() {
	    
	    //Font font = new Font("Courier", Font.BOLD,40);
	    
	    this.carre = new JButton("Jouer");
	    this.triangle = new JButton("Aléatoire");
	    this.cercle = new JButton("Reset");
	    this.polygone = new JButton("Quitter");
	    
	    this.carre.setPreferredSize(new Dimension(200,50));
	    this.triangle.setPreferredSize(new Dimension(200,50));
	    this.cercle.setPreferredSize(new Dimension(200,50));
	    this.polygone.setPreferredSize(new Dimension(200,50));


	    this.add(this.carre);
	    this.add(this.triangle);
	    this.add(this.cercle);
	    this.add(this.polygone);
	    
	    this.setPreferredSize(new Dimension(200,50));
	}
	
	public void setButtonLister(MenuControleur controller) {
		this.carre.addActionListener(controller);
		this.triangle.addActionListener(controller);
		this.cercle.addActionListener(controller);
		this.polygone.addActionListener(controller);

	}
	
	public int whoIsButton(Object button) {
		if(button == this.carre) {
			return 1;
		}
		
		if(button == this.triangle) {
			return 2;
		}
		
		if(button == this.cercle) {
			return 3;
		}
		
		if(button == this.polygone) {
			return 4;
		}
		
		return -1;
	}
	
	public JButton whoIsNumber(int button) {
		switch(button) {
			case 1:
				return this.carre;
				
			case 2:
				return this.triangle;
				
			case 3:
				return this.cercle;
				
			case 4:
				return this.polygone;
				
			default:
				return null;
		}
		
	}
	
}
