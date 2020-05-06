package controleurs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import modeles.Caneva;
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
	
	private static boolean creation;
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
		vue.setFocusable(true);
		vue.requestFocus();
		vue.addMouseListener(new GestionnaireSouris());
		vue.addMouseMotionListener(new GestionnaireMouvement());
	}
	
	
	/**
	 * Gestionnaire des actions utilisateur réalisées à la souris
	 *
	 */
	private static class GestionnaireSouris implements MouseListener{
		
		/**
		 * Gère les clics souris
		 */
		@Override
		public void mouseClicked(MouseEvent e) {
			Caneva caneva = Caneva.getCaneva();
			if (caneva.getForme() != null) {
				if (e.getButton() == MouseEvent.BUTTON1) {					
					creerFigure(e);
				} else {
					caneva.getPointsConstruction().clear();
					caneva.setFigureConstruction(null);
					creation = false;
					caneva.display();
				}
			} else {
				selectionnerFigure(e);
			}
		}
		
		/**
		 * Crée une figure à partir des points saisis par l'utilisateur
		 * @param e
		 */
		private void creerFigure(MouseEvent e) {
			Caneva caneva = Caneva.getCaneva();
			ArrayList<UnPoint> ptsConst = caneva.getPointsConstruction();
			UnPoint p = new UnPoint(e.getX(), e.getY());
			ptsConst.add(p);
			switch (caneva.getForme()) {
			case RECTANGLE :
				if (ptsConst.size() == 2) {
					UnRectangle r = new UnRectangle(ptsConst);
					caneva.getFigures().add(r);
					ptsConst.clear();
					caneva.setSelection(r);
					creation = false;
					caneva.setFigureConstruction(null);
				} else {
					creation = true;
				}
				break;
			case TRIANGLE :
				if (ptsConst.size() == 3) {
					UnTriangle t = new UnTriangle(ptsConst);
					caneva.getFigures().add(t);
					ptsConst.clear();
					caneva.setSelection(t);
					creation = false;
					caneva.setFigureConstruction(null);
				} else {
					creation = true;
				}
				break;
			case CERCLE :
				/* Points de construction au centre ? */
				if (ptsConst.size() == 2) {
					UnCercle c = new UnCercle(ptsConst);
					caneva.getFigures().add(c);
					ptsConst.clear();
					caneva.setSelection(c);
					creation = false;
					caneva.setFigureConstruction(null);
				} else {
					creation = true;
				}
				break;
			case POLYGONE :
				if (ptsConst.size() > 2 && DessinVue.superposition(p, ptsConst.get(0))) {
					ptsConst.remove(p);
					UnPolygone po = new UnPolygone(ptsConst);
					caneva.getFigures().add(po);
					ptsConst.clear();
					caneva.setSelection(po);
					creation = false;
					caneva.setFigureConstruction(null);
				} else {
					creation = true;
				}
				break;
			}
			caneva.display();
		}
		
		/**
		 * Sélectionne la figure sur laquelle clique l'utilisateur
		 * @param e
		 */
		private void selectionnerFigure(MouseEvent e) {
			
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
	}
	
	/**
	 * Gère les mouvements de souris
	 *
	 */
	private static class GestionnaireMouvement implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {

		}

		/**
		 * Ajoute un pré-rendu de la figure en cours de création
		 */
		@Override
		public void mouseMoved(MouseEvent e) {
			if (creation) {
				Caneva caneva = Caneva.getCaneva();
				ArrayList<UnPoint> ptsConst = caneva.getPointsConstruction();
				ArrayList<UnPoint> arr = new ArrayList<UnPoint>();
				switch (caneva.getForme()) {
				case RECTANGLE : 					
					arr.add(ptsConst.get(0));
					arr.add(new UnPoint(e.getX(), e.getY()));
					caneva.setFigureConstruction(new UnRectangle(arr));
					break;
				case TRIANGLE :
					if (ptsConst.size() == 2) {
						arr.add(ptsConst.get(0));
						arr.add(ptsConst.get(1));
						arr.add(new UnPoint(e.getX(), e.getY()));
						caneva.setFigureConstruction(new UnTriangle(arr));
					}
					break;
				case CERCLE :
					arr.add(ptsConst.get(0));
					arr.add(new UnPoint(e.getX(), e.getY()));
					caneva.setFigureConstruction(new UnCercle(arr));
					break;
				case POLYGONE :
					if (ptsConst.size() >= 2) {
						for(UnPoint p : ptsConst) arr.add(p);
						arr.add(new UnPoint(e.getX(), e.getY()));
						caneva.setFigureConstruction(new UnPolygone(arr));
					}
					break;
				}
				caneva.display();
			}
		}
		
	}

}
