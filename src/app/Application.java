package app;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modeles.Caneva;
import vues.DessinVue;

/**
 * Classe exécutable
 * @author Clément DOSDA, Louis FRIEDRICH, Loïc STEINMETZ, Julien TAVERNIER
 *
 */
public class Application {

	public static void main(String[] args) {
		// configure les paramètres généraux de la fenêtre
			JFrame f = new JFrame();
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setTitle("GéomPaint");
			
			// initialise les vues
			DessinVue dVue = new DessinVue();
			MenuVue mVue = new MenuVue();
			
			// initialise les modèles et associe ces derniers aux vues
			Caneva caneva = Caneva.getCaneva();
			caneva.addObserver(dVue);
			caneva.addObserver(mVue);
			
			// configure l'affichage
			JPanel p = new JPanel();
			p.setLayout(new BoxLayout(p, BoxLayout.LINE_AXIS));
			p.add(mVue);
			p.add(dVue);
			p.setPreferredSize(new Dimension(DessinVue.LARGEUR, DessinVue.HAUTEUR));
			
			// génère l'affichage
			f.setContentPane(p);
			f.setVisible(true);
			f.pack();		
	}
}
