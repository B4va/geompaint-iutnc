package app;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modeles.Caneva;
import vues.DessinVue;
import vues.MenuVue;

/**
 * Classe exécutable
 * @author Clément DOSDA, Louis FRIEDRICH, Loïc STEINMETZ, Julien TAVERNIER
 *
 */
public class Application {
	
	public static final int HAUTEUR = 800;

	public static void main(String[] args) {
		// configure les paramètres généraux de la fenêtre
			JFrame f = new JFrame();
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setTitle("GéomPaint");
			
			// initialise les vues
			DessinVue dVue = new DessinVue();
			MenuVue mVue = new MenuVue();
			
			// initialise les modèles et les associe aux vues
			Caneva caneva = Caneva.getCaneva();
			caneva.addObserver(dVue);
			caneva.addObserver(mVue);
			
			// génère l'affichage
			JPanel p = new JPanel();
		    p.setPreferredSize(new Dimension(MenuVue.LARGEUR + DessinVue.LARGEUR, HAUTEUR));
			f.setContentPane(p);		    		
			f.setVisible(true);
			f.pack();
			p.setLayout(new BorderLayout());
		    p.add(mVue, BorderLayout.WEST);
		    p.add(dVue, BorderLayout.EAST);
		    mVue.setPreferredSize(new Dimension(MenuVue.LARGEUR, HAUTEUR));
		    mVue.setMaximumSize(new Dimension(MenuVue.LARGEUR, dVue.getHeight()));
		    mVue.setMinimumSize(new Dimension(MenuVue.LARGEUR, dVue.getHeight()));
	}
}
