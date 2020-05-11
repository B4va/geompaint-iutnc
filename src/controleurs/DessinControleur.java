package controleurs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import modeles.Caneva;
import modeles.FigureGeom;
import modeles.Translatable;
import modeles.UnCercle;
import modeles.UnPoint;
import modeles.UnPolygone;
import modeles.UnRectangle;
import modeles.UnTriangle;
import vues.DessinVue;

/**
 * Gestionnaire des événements liés au panneau de dessin
 * @author Clément DOSDA, Louis FRIEDRICH, Loïc STEINMETZ, Julien TAVERNIER
 *
 */
public class DessinControleur {
	
	private static Translatable transObjet;
	private static UnPoint dragOrigin;
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
		vue.addMouseListener(new GestionnaireSouris());
		vue.addMouseMotionListener(new GestionnaireMouvement());
	}
	
	/**
	 * Gestionnaire des inputs utilisateur réalisées à la souris
	 *
	 */
	private static class GestionnaireSouris implements MouseListener{
		
		/**
		 * Gère les clics souris : dessin ou sélection
		 * @param e événement
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
		 * @param e événement
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
					creation = false;
					caneva.setFigureConstruction(null);
				} else {
					creation = true;
				}
				break;
			case CERCLE :
				if (ptsConst.size() == 2) {
					UnCercle c = new UnCercle(ptsConst);
					caneva.getFigures().add(c);
					ptsConst.clear();
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
		 * Initialise les paramètres de translation
		 * @param e événement
		 */
		@Override
		public void mousePressed(MouseEvent e) {
			if (Caneva.getCaneva().getForme() == null) {				
				if (transObjet == null) {
					FigureGeom f = Caneva.getCaneva().getSelection();
					if (f != null) {
						if (f instanceof UnPolygone) {							
							for (UnPoint p : f.getPointsMemoire()) {
								if (DessinVue.superposition(p, new UnPoint(e.getX(), e.getY()))) {
									transObjet = p;
								}
							}
						} else {
							UnPoint p = f.getPointsMemoire().get(1);
							if (DessinVue.superposition(p, new UnPoint(e.getX(), e.getY()))) {
								transObjet = p;
							}
						}
					}
					if (transObjet == null) {
						selectionnerFigure(e);
						f = Caneva.getCaneva().getSelection();
						if (f != null) {
							transObjet = f;
						}
					}
					dragOrigin = new UnPoint(e.getX(), e.getY());
				}
			}
		}
		
		/**
		 * Sélectionne la figure sur laquelle clique l'utilisateur
		 * @param e événement
		 */
		private void selectionnerFigure(MouseEvent e) {
			Caneva c = Caneva.getCaneva();
			ArrayList<FigureGeom> figures = c.getFigures();
			c.setSelection(null);
			for (int i = figures.size() - 1 ; i >= 0 ; i--) {
				if (DessinVue.contient(figures.get(i), e.getX(), e.getY())) {
					c.setSelection(figures.get(i));
					c.setPlein(figures.get(i).isPlein());
					c.setCouleur(figures.get(i).getCouleur());
					break;
				}
			}
			c.display();
		}
		
		/**
		 * Réinitialise les paramètres de translation
		 * @param e événement
		 */
		@Override
		public void mouseReleased(MouseEvent e) {
			dragOrigin = null;
			transObjet = null;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {}
	}
	
	/**
	 * Gestionnaire des mouvements de souris réalisés par l'utilisateur
	 *
	 */
	private static class GestionnaireMouvement implements MouseMotionListener {

		/**
		 * Ajoute un pré-rendu de la figure en cours de création
		 * @param e événement
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
		
		/**
		 * Déplace un point ou une figure
		 * @param e événement
		 */
		@Override
		public void mouseDragged(MouseEvent e) {
			FigureGeom sel = Caneva.getCaneva().getSelection();
			if (sel != null && dragOrigin != null) {
				int x = e.getX() - dragOrigin.getX();
				int y = e.getY() - dragOrigin.getY();
				if (transObjet instanceof UnPoint && sel instanceof UnCercle) {
					transObjet.translater(x, 0);
				} else {					
					transObjet.translater(x, y);
				}
				Caneva.getCaneva().display();
				dragOrigin = new UnPoint(e.getX(), e.getY());
			}
		}
		
	}

}
