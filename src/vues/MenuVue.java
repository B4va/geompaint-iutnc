package vues;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controleurs.MenuControleur;

/**
 *
 * @author Clément DOSDA, Louis FRIEDRICH, Loïc STEINMETZ, Julien TAVERNIER
 *
 */
public class MenuVue extends JPanel implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int LARGEUR = 220;
	public static final int HAUTEUR = 500;
	
	
	private JButton carre;
	private JButton triangle;
	private JButton cercle;
	private JButton polygone;
	private JButton translater;
	private JButton modifier;
    private JComboBox listeCouleur;

    /**
	 * Constructeur qui génére le menu de l'application.
	 * */
	public MenuVue() {
		//la liste des couleur de la JComboBox
		Object[] elements = new Object[]{"Noir", "jaune", "vert", "bleu", "rouge","rose","gris","marron"};
		
		
		this.setBackground(Color.pink);
		Font font = new Font("Courier", Font.BOLD,24);
		
		JLabel labelCreation = new JLabel("Création : ");
		labelCreation.setFont(font);
		
		JLabel labelModification = new JLabel("Modification : ");
		labelModification.setFont(font);
		
	    //création des items
		this.carre    = new JButton("Carre");
	    this.triangle = new JButton("Triangle");
	    this.cercle   = new JButton("Cercle");
	    this.polygone = new JButton("Polygone");
	    this.translater = new JButton("Translater");
	    this.modifier = new JButton("Modifier");
	    this.listeCouleur = new JComboBox(elements);
	    
	    //parametrage de la taille des items
	    this.carre.setPreferredSize(new Dimension(200,50));
	    this.triangle.setPreferredSize(new Dimension(200,50));
	    this.cercle.setPreferredSize(new Dimension(200,50));
	    this.polygone.setPreferredSize(new Dimension(200,50));
	    this.translater.setPreferredSize(new Dimension(200,50));
	    this.modifier.setPreferredSize(new Dimension(200,50));
	    this.listeCouleur.setPreferredSize(new Dimension(200,50));
	    
	    //ajout des items
	    this.add(labelCreation);
	    this.add(this.carre);
	    this.add(this.triangle);
	    this.add(this.cercle);
	    this.add(this.polygone);
	    this.add(labelModification);
	    this.add(this.translater);
	    this.add(this.modifier);
	    this.add(this.listeCouleur);
	    
	    this.setPreferredSize(new Dimension(LARGEUR,HAUTEUR));
	}
	
	/**
	 * Pérmet la récupération des événements de la vue, par le controller.
	 * */
	public void setButtonListener(MenuControleur controller) {
		this.carre.addActionListener(controller);
		this.triangle.addActionListener(controller);
		this.cercle.addActionListener(controller);
		this.polygone.addActionListener(controller);
		this.modifier.addActionListener(controller);
		this.listeCouleur.addItemListener(controller);

	}
	/**
	 * Permet de déterminer quel bouton est le parametre @param button,
	 * et retourne un numéro.
	 * */
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
		
		if(button == this.translater) {
			return 5;
		}
		
		if(button == this.modifier) {
			return 6;
		}
		
		return -1;
	}
	/**
	 * Permet de déterminer quel numéro est le parametre @param button,
	 * et retourne un bouton.
	 * */
	private JButton whoIsNumber(int button) {
		switch(button) {
			case 1:
				return this.carre;
				
			case 2:
				return this.triangle;
				
			case 3:
				return this.cercle;
				
			case 4:
				return this.polygone;
				
			case 5:
				return this.translater;
				
			case 6:
				return this.modifier;
				
			default:
				return null;
		}	
	}
	/**
	 * Permet de mettre à jour le caneva
	 * */
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
