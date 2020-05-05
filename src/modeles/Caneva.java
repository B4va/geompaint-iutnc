package modeles;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Modélise Singleton du caneva de dessins
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

	/**
	 * Constructeur du singleton
	 */
	private Caneva() {
		figures = new ArrayList<FigureGeom>();
		pointsConstruction = new ArrayList<UnPoint>();
	}
	
	/**
	 * Getter de l'instance de caneva
	 * @return caneva
	 */
	public static Caneva getCaneva() {
		if(CANEVA == null) {
			CANEVA = new Caneva();
		}
		return CANEVA;
	}
	
	public void display() {
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Getter de la liste de figures
	 * @return figures
	 */
	public ArrayList<FigureGeom> getFigures() {
		return figures;
	}
	
	/**
	 * Getter de la liste de points de construction
	 * @return figures
	 */
	public ArrayList<UnPoint> getPointsConstruction() {
		return pointsConstruction;
	}
	
	public Forme getForme() {
		return forme;
	}
	
	public Color getCouleur() {
		return couleur;
	}
	
	public FigureGeom getSelection() {
		return selection;
	}
	
	public FigureGeom getFigureConstruction() {
		return figureConstruction;
	}
	
	public void setForme(Forme f) {
		forme = f;
	}

	public void setCouleur(Color c) {
		couleur = c;
	}
	
	public void setSelection(FigureGeom f) {
		selection = f;
	}
	
	public void setFigureConstruction(FigureGeom f) {
		figureConstruction = f;
	}
}
