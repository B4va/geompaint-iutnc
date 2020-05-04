package modeles;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Modélise Singleton du caneva de dessins
 * @author Clément DOSDA, Louis FRIEDRICH, Loïc STEINMETZ, Julien TAVERNIER
 *
 */
@SuppressWarnings("deprecation")
public class Caneva extends Observable {
	
	private static Caneva CANEVA = new Caneva();
	private ArrayList<FigureGeom> figures;
	private ArrayList<UnPoint> pointsConstruction;

	/**
	 * Constructeur du singleton
	 */
	private Caneva() {
		
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
}
