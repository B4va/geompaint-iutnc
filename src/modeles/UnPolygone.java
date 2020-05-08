package modeles;

import java.util.ArrayList;

/**
 * Modélisation d'un polygone quelconque
 * @author Clément DOSDA, Louis FRIEDRICH, Loïc STEINMETZ, Julien TAVERNIER
 *
 */
public class UnPolygone extends FigureGeom {

	/**
	 * Constructeur
	 * @param pointsConstruction points permettant de construire la figure
	 */
	public UnPolygone(ArrayList<UnPoint> pointsConstruction) {
		super(pointsConstruction);
	}

	/**
	 * Enregistre les points de mémoire
	 */
	@Override
	protected void iniPointsMemoire() {
		pointsMemoire = pointsSaisie;
	}

}
