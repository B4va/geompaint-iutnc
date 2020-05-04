package modeles;

import java.util.ArrayList;

/**
 * Modélise un cercle
 * @author Clément DOSDA, Louis FRIEDRICH, Loïc STEINMETZ, Julien TAVERNIER
 *
 */
public class UnCercle extends FigureGeom {

	/**
	 * Constructeur
	 * @param pointsConstruction points permettant de construire la figure
	 */
	public UnCercle(ArrayList<UnPoint> pointsConstruction) {
		super(pointsConstruction);
	}
	
	@Override
	/**
	 * Enregistre les points de saisie
	 */
	protected void iniPointsSaisie() {
		// modifier
		pointsSaisie = null;
	}
}
