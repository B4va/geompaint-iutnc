package modeles;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Modélisation abstraite d'une figure géométrique
 * @author Clément DOSDA, Louis FRIEDRICH, Loïc STEINMETZ, Julien TAVERNIER
 *
 */
public abstract class FigureGeom {

	protected ArrayList<UnPoint> pointsSaisie;
	protected ArrayList<UnPoint> pointsMemoire;
	protected Color couleur;
	protected boolean plein;
	
	/**
	 * Constructeur d'une figure géométrique
	 * @param pointsConstruction points permettant de construire la figure
	 */
	public FigureGeom(ArrayList<UnPoint> pointsConstruction) {
		pointsSaisie = new ArrayList<UnPoint>();
		for (UnPoint p : pointsConstruction) pointsSaisie.add(p);
		iniPointsMemoire();
		couleur = Caneva.getCaneva().getCouleur();
		plein = Caneva.getCaneva().isPlein();
	}
	
	/**
	 * Déplace un point
	 * @param x le déplacement en abcisse
	 * @param y le déplacement en ordonnée
	 */
	public void translater(int x, int y) {
		for(UnPoint p : pointsSaisie) p.translater(x, y);
		for(UnPoint p : pointsMemoire) p.translater(x, y);
	}

	/**
	 * Enregistre les points de mémoire
	 */
	abstract protected void iniPointsMemoire();
	
	/**
	 * Getter de la liste de points de saisie
	 * @return pointsSaisie
	 */
	public ArrayList<UnPoint> getPointsSaisie() {
		return pointsSaisie;
	}

	/**
	 * Getter de la liste de points de mémoire
	 * @return pointsMemoire
	 */
	public ArrayList<UnPoint> getPointsMemoire() {
		return pointsMemoire;
	}

	/**
	 * Getter de la couleur
	 * @return couleur
	 */
	public Color getCouleur() {
		return couleur;
	}

	/**
	 * Setter de la couleur
	 * @param couleur
	 */
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	
	/**
	 * Getter de l'état plein
	 * @return plein
	 */
	public boolean isPlein() {
		return plein;
	}
	
	/**
	 * Setter de l'état plein
	 * @param plein
	 */
	public void setPlein(boolean plein) {
		this.plein = plein;
	}
	
	
}
