package controleurs;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import modeles.Caneva;
import modeles.Forme;
import modeles.UnCercle;
import modeles.UnPoint;
import modeles.UnPolygone;
import modeles.UnRectangle;
import modeles.UnTriangle;
import vues.DessinVue;

/**
 * Gestion de l'interface de dessin
 * @author Clément DOSDA, Louis FRIEDRICH, Loïc STEINMETZ, Julien TAVERNIER
 *
 */
public class DessinControleur {
	
	private DessinVue vue;
	
	/**
	 * Crée le controleur en l'associant à la vue dédiée
	 * @param vue
	 */
	public DessinControleur(DessinVue vue) {
		this.vue = vue;
	}
	
	/**
	 * Initialise le controleur
	 */
	public void init() {
		vue.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				/* A supprimer */
				Caneva.getCaneva().setForme(Forme.POLYGONE);
				Caneva.getCaneva().setCouleur(Color.black);
				/* Fin */
				if (Caneva.getCaneva().getForme() != null) {
					ArrayList<UnPoint> ptsConst = Caneva.getCaneva().getPointsConstruction();
					UnPoint p = new UnPoint(e.getX(), e.getY());
					ptsConst.add(p);
					switch (Caneva.getCaneva().getForme()) {
					case RECTANGLE :
						if (ptsConst.size() == 2) {
							Color c = Caneva.getCaneva().getCouleur();
							UnRectangle r = new UnRectangle(ptsConst, c, true);
							Caneva.getCaneva().getFigures().add(r);
							ptsConst.clear();
						}
						break;
					case TRIANGLE :
						if (ptsConst.size() == 3) {
							Color c = Caneva.getCaneva().getCouleur();
							UnTriangle r = new UnTriangle(ptsConst, c, true);
							Caneva.getCaneva().getFigures().add(r);
							ptsConst.clear();
						}
						break;
					case CERCLE :
						/* Points de construction au centre ? */
						if (ptsConst.size() == 2) {
							Color c = Caneva.getCaneva().getCouleur();
							UnCercle r = new UnCercle(ptsConst, c, true);
							Caneva.getCaneva().getFigures().add(r);
							ptsConst.clear();
						}
						break;
					case POLYGONE :
						if (ptsConst.size() > 2 && DessinVue.superposition(p, ptsConst.get(0))) {
							ptsConst.remove(p);
							Color c = Caneva.getCaneva().getCouleur();
							UnPolygone r = new UnPolygone(ptsConst, c, true);
							Caneva.getCaneva().getFigures().add(r);
							ptsConst.clear();
						}
						break;
					}
					Caneva.getCaneva().display();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {}
			
		});
	}

}
