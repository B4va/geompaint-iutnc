package app;

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

	/**
	 * Méthode éxécutable
	 * @param args
	 */
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
		
		// configure l'affichage
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.LINE_AXIS));
		p.add(mVue);
		p.add(dVue);
		p.setPreferredSize(new Dimension(MenuVue.LARGEUR + DessinVue.LARGEUR, HAUTEUR));
		mVue.setPreferredSize(new Dimension(MenuVue.LARGEUR, HAUTEUR));
		dVue.setPreferredSize(new Dimension(DessinVue.LARGEUR, HAUTEUR));
		
		// génère l'affichage
		f.setContentPane(p);
		f.setVisible(true);
		f.pack();	
	}
}
