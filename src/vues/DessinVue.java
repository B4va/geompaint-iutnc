package vues;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import controleurs.DessinControleur;
import modeles.Caneva;
import modeles.FigureGeom;
import modeles.UnCercle;
import modeles.UnPoint;
import modeles.UnPolygone;
import modeles.UnRectangle;

/**
 * Gestion de l'affichage l'interface de dessin
 * @author Clément DOSDA, Louis FRIEDRICH, Loïc STEINMETZ, Julien TAVERNIER
 *
 */
public class DessinVue extends JPanel implements Observer {
	
	private static final int TAILLE_POINTS = 10;
	private static final int TOLERANCE = 10;
	public static final int LARGEUR = 800;
	public static final int HAUTEUR = 800;
	
	private Caneva caneva;
	
	/**
	 * Constructeur permettant l'initialisation du controleur associé
	 */
	public DessinVue() {
		new DessinControleur(this).init();
	}
	
	/**
	 * Affiche les éléments du dessin
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (caneva != null) {
			for (FigureGeom f : caneva.getFigures()) {
				g.setColor(f.getCouleur());
				if (f instanceof UnCercle) {
					tracerCercle((UnCercle)f, g);
				} else {
					tracerPolygone((UnPolygone)f, g);
				}
				if (f.isSelection()) tracerPointsSaisie(f);
			}
			for (UnPoint p : caneva.getPointsConstruction()) {
				tracerPointConstruction(p, g);
			}
		}
	}
	
	/**
	 * Trace un cercle
	 * @param c cercle à tracer
	 * @param g outil graphique
	 */
	private void tracerCercle(UnCercle c, Graphics g) {
		int width = c.getPointsMemoire().get(1).getX() - c.getPointsMemoire().get(0).getX();
		int height = c.getPointsMemoire().get(1).getY() - c.getPointsMemoire().get(0).getY();
		if (c.isPlein()) {
			g.fillOval(c.getPointsMemoire().get(0).getX(), c.getPointsMemoire().get(0).getY(), width, height);
		} else {
			g.drawOval(c.getPointsMemoire().get(0).getX(), c.getPointsMemoire().get(0).getY(), width, height);
		}
	}
	
	/**
	 * Trace un polygone
	 * @param p polygone à tracer
	 * @param g outil graphique
	 */
	private void tracerPolygone(UnPolygone p, Graphics g) {
		int nPoints = p.getPointsMemoire().size();
		int[] xPoints = new int[nPoints];
		int [] yPoints = new int[nPoints];
		int i = 0;
		for(UnPoint pt : p.getPointsMemoire()) {
			xPoints[i] = pt.getX();
			yPoints[i] = pt.getY();
			i++;
		}
		if (p.isPlein()) {			
			g.fillPolygon(xPoints, yPoints, nPoints);
		} else {
			g.drawPolygon(xPoints, yPoints, nPoints);
		}
	}
	
	/**
	 * Trace les points de saisie d'une figure
	 * @param f figure sélectionnée
	 */
	private void tracerPointsSaisie(FigureGeom f) {
		/*
		Graphics g = getGraphics();
		g.setColor(Color.GRAY);
		for (UnPoint p : f.getPointsSaisie()) {			
			g.fillRect(
					p.getX() - TAILLE_POINTS / 2,
					p.getY() - TAILLE_POINTS / 2, 
					TAILLE_POINTS, TAILLE_POINTS
			);
		}
		*/
	}
	
	/**
	 * Trace un point de consctruction
	 * @param p point à tracer
	 * @param g outil graphique
	 */
	private void tracerPointConstruction(UnPoint p, Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(
				p.getX() - TAILLE_POINTS / 2,
				p.getY() - TAILLE_POINTS / 2, 
				TAILLE_POINTS, TAILLE_POINTS
		);
	}

	/**
	 * Met à jour la vue
	 * @param o modèle lié à la vue
	 * @param arg arguments
	 */
	@Override
	public void update(Observable o, Object arg) {
		caneva = (Caneva) o;
		repaint();
	}
	
	/**
	 * Vérifie la superposition de deux points
	 * @param p1 premier point
	 * @param p2 second point
	 * @return true si les points sont superposés
	 */
	public static boolean superposition(UnPoint p1, UnPoint p2) {
		boolean x = Math.abs(p1.getX() - p2.getX()) < TOLERANCE;
		boolean y = Math.abs(p1.getY() - p2.getY()) < TOLERANCE;
		return x && y;
	}

}
