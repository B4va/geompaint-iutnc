package vues;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import controleurs.DessinControleur;
import modeles.Caneva;
import modeles.FigureGeom;
import modeles.UnCercle;
import modeles.UnPoint;
import modeles.UnPolygone;
import modeles.UnRectange;
import modeles.UnTriangle;

/**
 * Gestion de l'affichage l'interface de dessin
 * @author Clément DOSDA, Louis FRIEDRICH, Loïc STEINMETZ, Julien TAVERNIER
 *
 */
public class DessinVue extends JPanel implements Observer {
	
	private static final int TAILLE_POINTS = 10;
	
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
		for (FigureGeom f : caneva.getFigures()) {
			g.setColor(f.getCouleur());
			if (f instanceof UnCercle) {
				tracerCercle(f);
			} else {
				tracerPolygone(f);
			}
			if (f.isSelection()) tracerPointsSaisie(f);
		}
		for (UnPoint p : caneva.getPointsContruction()) {
			tracerPointConstruction(p);
		}
	}
	
	/**
	 * Trace un cercle
	 * @param f cercle à tracer
	 */
	private void tracerCercle(UnCercle f) {
		Graphics g = getGraphics();
		int width = f.getPointsMemoire().get(1).getX() - f.getPointsMemoire().get(0).getX();
		int height = f.getPointsMemoire().get(1).getY() - f.getPointsMemoire().get(0).getY();
		if (f.isPlein()) {
			g.fillOval(f.getPointsMemoire().get(0).getX(), f.getPointsMemoire().get(0).getY(), width, height);
		} else {
			g.drawOval(f.getPointsMemoire().get(0).getX(), f.getPointsMemoire().get(0).getY(), width, height);
		}
	}
	
	/**
	 * Trace un polygone
	 * @param p polygone
	 */
	private void tracerPolygone(UnPolygone p) {
		Graphics g = getGraphics();
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
		Graphics g = getGraphics();
		g.setColor(Color.GRAY);
		for (UnPoint p : f.getPointsSaisie()) {			
			g.fillRect(
					p.getX() - TAILLE_POINTS / 2,
					p.getY() - TAILLE_POINTS / 2, 
					TAILLE_POINTS, TAILLE_POINTS
			);
		}
	}
	
	/**
	 * Trace un point de consctruction
	 * @param p point à tracer
	 */
	private void tracerPointConstruction(UnPoint p) {
		Graphics g = getGraphics();
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
	}

}
