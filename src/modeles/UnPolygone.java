package modeles;

import java.util.ArrayList;

/**
 * Modélise un polygone quelconque
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

	@Override
	/**
	 * Enregistre les points de saisie
	 */
	protected void iniPointsSaisie() {
		pointsSaisie = pointsMemoire;
	}

}
