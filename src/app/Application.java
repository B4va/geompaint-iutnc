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
			JPanel pMenu = new JPanel();
			JPanel pDessin = new JPanel();
			
		    f.setLayout(new BorderLayout());
		    /*
		    //proposition d affichage plus simple
		    dVue.setPreferredSize(new Dimension(dVue.LARGEUR, dVue.HAUTEUR));
		    mVue.setPreferredSize(new Dimension(mVue.LARGEUR, mVue.HAUTEUR));
			f.add(mVue,BorderLayout.WEST);
		    f.add(dVue,BorderLayout.CENTER);
			*/
		    
		    //pMenu.setLayout(new BoxLayout(pMenu, BoxLayout.Y_AXIS));
			//pMenu.add(mVue);
			//pMenu.setPreferredSize(new Dimension(MenuVue.LARGEUR, MenuVue.HAUTEUR));
			
		    pDessin.setLayout(new BoxLayout(pDessin, BoxLayout.Y_AXIS));
			pDessin.add(dVue);
			pDessin.setPreferredSize(new Dimension(DessinVue.LARGEUR, DessinVue.HAUTEUR));
		    
			// génère l'affichage
			//f.setContentPane(pMenu);
			f.setContentPane(pDessin);
			
			
		    
			f.setVisible(true);
			f.pack();		
	}
}
