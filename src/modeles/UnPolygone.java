package modeles;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Modélise un polygone quelconque
 * @author Clément DOSDA, Louis FRIEDRICH, Loïc STEINMETZ, Julien TAVERNIER
 *
 */
public class UnPolygone extends FigureGeom {

	/**
	 * Constructeur
	 * @param couleur
	 * @param plein
	 */
	public UnPolygone(ArrayList<UnPoint> pointsConstruction, Color couleur, boolean plein) {
		super(pointsConstruction, couleur, plein);
	}

	@Override
	/**
	 * Enregistre les points de saisie
	 */
	protected void iniPointsSaisie() {
		pointsSaisie = pointsMemoire;
	}

}
