package vues;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import controleurs.MenuControleur;
import modeles.Caneva;

/**
 * Gestion de l'affichage du menu
 * @author Clément DOSDA, Louis FRIEDRICH, Loïc STEINMETZ, Julien TAVERNIER
 *
 */
public class MenuVue extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	public static final Color BACKGROUND = Color.PINK;
	public static final int LARGEUR = 220;
	
	
	private JButton rectangle;
	private JButton triangle;
	private JButton cercle;
	private JButton polygone;
	private JButton plein;
	private JButton selection;
	private JButton effacer;
	private JButton effacerUn;

    private JComboBox<Object> listeCouleur;

    /**
	 * Constructeur affichant le menu de l'application
	 */
	public MenuVue() {
		
		//la liste des couleur de la JComboBox
		Object[] elements = new Object[]{"Noir", "jaune", "vert", "bleu", "rouge","rose","gris","gris foncé"};
		
		
		this.setBackground(BACKGROUND);
		Font font = new Font("Courier", Font.BOLD,24);
		
		JLabel labelCreation = new JLabel("Création :");
		labelCreation.setFont(font);
		
		JLabel labelModification = new JLabel("Modification :");
		labelModification.setFont(font);
		
	    //création des items
		this.rectangle    = new JButton("Rectangle");
	    this.triangle = new JButton("Triangle");
	    this.cercle   = new JButton("Cercle");
	    this.polygone = new JButton("Polygone");
	    this.selection = new JButton("Selectionner");
	    this.plein = new JButton("Plein");
	    this.effacer = new JButton("Tout effacer");
	    this.effacerUn = new JButton("Effacer");
	    
	    this.listeCouleur = new JComboBox<Object>(elements);
	    
	    //parametrage de la taille des items
	    this.rectangle.setPreferredSize(new Dimension(200,50));
	    this.triangle.setPreferredSize(new Dimension(200,50));
	    this.cercle.setPreferredSize(new Dimension(200,50));
	    this.polygone.setPreferredSize(new Dimension(200,50));
	    this.plein.setPreferredSize(new Dimension(200,50));
	    this.selection.setPreferredSize(new Dimension(200,50));
	    this.listeCouleur.setPreferredSize(new Dimension(200,50));
	    this.effacer.setPreferredSize(new Dimension(200,50));
	    this.effacerUn.setPreferredSize(new Dimension(200,50));


	    //ajout des items
	    this.add(labelCreation);
	    this.add(this.rectangle);
	    this.add(this.triangle);
	    this.add(this.cercle);
	    this.add(this.polygone);
	    this.add(labelModification);
	    this.add(this.selection);
	    this.add(this.plein);
	    this.add(this.effacerUn);
	    this.add(this.effacer);
	    this.add(this.listeCouleur);
	    this.effacerUn.setEnabled(false);
	    this.effacer.setEnabled(false);
	    this.selection.setEnabled(false);

	    
	    new MenuControleur(this);
	}
	
	/**
	 * Récupère les événements de la vue
	 * @param controller controleur associé
	 */
	public void setButtonListener(MenuControleur controller) {
		this.rectangle.addActionListener(controller);
		this.triangle.addActionListener(controller);
		this.cercle.addActionListener(controller);
		this.polygone.addActionListener(controller);
		this.selection.addActionListener(controller);
		this.listeCouleur.addItemListener(controller);
		this.effacer.addActionListener(controller);
		this.plein.addActionListener(controller);
		this.effacerUn.addActionListener(controller);
		
		this.plein.setFocusable(false);
		this.rectangle.addFocusListener(controller);
		this.triangle.addFocusListener(controller);
		this.cercle.addFocusListener(controller);
		this.polygone.addFocusListener(controller);

	}
	/**
	 * Détermine quel est le bouton indiqué
	 * @param button bouton à définir
	 */
	public int whoIsButton(Object button) {
		if(button == this.rectangle) {
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
		
		if(button == this.plein) {
			return 5;
		}
		
		if(button == this.selection) {
			return 6;
		}
		
		if(button == this.effacer) {
			return 7;
		}
		
		if(button == this.effacerUn) {
			return 8;
		}
		
		return -1;
	}
	
	/**
	 * Met à jour le caneva
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		Caneva caneva = (Caneva) arg0;
		
		if(caneva.getSelection() == null) {
		    this.effacerUn.setEnabled(false);
		}
		else {
		    this.effacerUn.setEnabled(true);
		    
		    if(caneva.getSelection().isPlein()) {
		    	this.plein.setBorder(new MatteBorder(3, 3, 3, 3, Color.DARK_GRAY));
			} 
		    else {
		    	this.plein.setBorder(new MatteBorder(1, 1, 1, 1, Color.GRAY));
		    }
		}
		
		if(caneva.getFigures().isEmpty() == false) {
		    this.effacer.setEnabled(true);
		    this.selection.setEnabled(true);
		}
		else {
		    this.effacer.setEnabled(false);
		    this.selection.setEnabled(true);
		}
	}
}
