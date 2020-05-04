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
	protected boolean selection;
	protected boolean plein;
	
	/**
	 * Constructeur d'une figure géométrique
	 * @param couleur
	 * @param plein
	 */
	public FigureGeom(ArrayList<UnPoint> pointsConstruction, Color couleur, boolean plein) {
		pointsMemoire = pointsConstruction;
		iniPointsSaisie();
		this.couleur = couleur;
		this.plein = plein;
		selection = true;
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
	 * Enregistre les points de saisie
	 */
	abstract protected void iniPointsSaisie();
	
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
	 * Getter de l'état de sélection
	 * @return selection
	 */
	public boolean isSelection() {
		return selection;
	}

	/**
	 * Setter de l'état de sélection
	 * @param selection
	 */
	public void setSelection(boolean selection) {
		this.selection = selection;
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
