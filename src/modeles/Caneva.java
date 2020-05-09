package modeles;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Modélisation du singleton associé au caneva
 * @author Clément DOSDA, Louis FRIEDRICH, Loïc STEINMETZ, Julien TAVERNIER
 *
 */
public class Caneva extends Observable {
	
	private static Caneva CANEVA = new Caneva();
	private ArrayList<FigureGeom> figures;
	private ArrayList<UnPoint> pointsConstruction;
	private FigureGeom figureConstruction;
	private Forme forme;
	private Color couleur;
	private FigureGeom selection;
	private boolean plein;

	/**
	 * Constructeur du singleton
	 */
	private Caneva() {
		figures = new ArrayList<FigureGeom>();
		pointsConstruction = new ArrayList<UnPoint>();
		couleur = Color.BLACK;
		forme = Forme.RECTANGLE;
	}
	
	/**
	 * Retourne l'instance de caneva
	 * @return caneva singleton
	 */
	public static Caneva getCaneva() {
		if(CANEVA == null) {
			CANEVA = new Caneva();
		}
		return CANEVA;
	}
	
	/**
	 * Affiche le caneva mis à jour
	 */
	public void display() {
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Retourne la liste de figures
	 * @return figures ensemble des figures
	 */
	public ArrayList<FigureGeom> getFigures() {
		return figures;
	}
	
	/**
	 * Efface la figure séléctionnée
	 */
	public void clearSelecFigures() {
		int index = this.figures.indexOf(this.selection);
		this.figures.remove(index);
		this.selection = null;
	}
	
	/**
	 * Efface toutes les figures de la liste
	 */
	public void clearFigures() {
		figures = new ArrayList<FigureGeom>();
	}
	
	/**
	 * Retourne la liste des points de construction
	 * @return liste des points de contruction 
	 */
	public ArrayList<UnPoint> getPointsConstruction() {
		return pointsConstruction;
	}
	
	/**
	 * Retourne la forme sélectionnée
	 * @return forme séléctionnée
	 */
	public Forme getForme() {
		return forme;
	}
	
	/**
	 * Retourne la courleur sélectionnée
	 * @return couleur sélectionnée
	 */
	public Color getCouleur() {
		return couleur;
	}
	
	/**
	 * Retourne la figure sélectionnée
	 * @return figure séléctionnée
	 */
	public FigureGeom getSelection() {
		return selection;
	}
	
	/**
	 * Retourne la figure en construction
	 * @return figure en construction
	 */
	public FigureGeom getFigureConstruction() {
		return figureConstruction;
	}
	
	/**
	 * Indique si 'plein' est sélectionné
	 * @return true si plein est sélectionné
	 */
	public boolean isPlein() {
		return plein;
	}
	
	/**
	 * Modifie la valeur de plein
	 * @param p true si plein est sélectionné
	 */
	public void setPlein(boolean p) {
		plein = p;
	}
	
	/**
	 * Modifie la forme sélectionnée
	 * @param f forme sélectionnée
	 */
	public void setForme(Forme f) {
		forme = f;
	}

	/**
	 * Modifie la couleur sélectionnée
	 * @param c couleur sélectionnée
	 */
	public void setCouleur(Color c) {
		couleur = c;
	}
	
	/**
	 * Modifie la figure sélectionnée
	 * @param f figure sélectionnée
	 */
	public void setSelection(FigureGeom f) {
		selection = f;
	}
	
	/**
	 * Modifie la figure en construction
	 * @param f figure en construction
	 */
	public void setFigureConstruction(FigureGeom f) {
		figureConstruction = f;
	}
}
