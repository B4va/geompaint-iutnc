package modeles;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Modélisation abstraite d'une figure géométrique
 * @author Clément DOSDA, Louis FRIEDRICH, Loïc STEINMETZ, Julien TAVERNIER
 *
 */
public abstract class FigureGeom implements Translatable {

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
	 * @param x déplacement en abscisse
	 * @param y déplacement en ordonnée
	 */
	public void translater(int x, int y) {
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
	 * Retourne la couleur de la figure
	 * @return couleur couleur de la figure
	 */
	public Color getCouleur() {
		return couleur;
	}

	/**
	 * Modifie la couleur de la figure
	 * @param couleur de la figure
	 */
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	
	/**
	 * Indique si la figure est pleine
	 * @return plein true si la figure est pleine
	 */
	public boolean isPlein() {
		return plein;
	}
	
	/**
	 * Modifie l'état de la figure
	 * @param plein true si la figure est pleine
	 */
	public void setPlein(boolean plein) {
		this.plein = plein;
	}
	
	
}
