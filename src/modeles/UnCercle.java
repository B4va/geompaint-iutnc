package modeles;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Modélise un cercle
 * @author Clément DOSDA, Louis FRIEDRICH, Loïc STEINMETZ, Julien TAVERNIER
 *
 */
public class UnCercle extends FigureGeom {

	/**
	 * Constructeur
	 * @param couleur
	 * @param plein
	 */
	public UnCercle(ArrayList<UnPoint> pointsConstruction, Color couleur, boolean plein) {
		super(pointsConstruction, couleur, plein);
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
