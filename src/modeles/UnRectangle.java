package modeles;

import java.util.ArrayList;

/**
 * Modélisation d'un rectangle
 * @author Clément DOSDA, Louis FRIEDRICH, Loïc STEINMETZ, Julien TAVERNIER
 *
 */
public class UnRectangle extends UnPolygone {

	/**
	 * Constructeur
	 * @param pointsConstruction points permettant de construire la figure
	 */
	public UnRectangle(ArrayList<UnPoint> pointsConstruction) {
		super(pointsConstruction);
	}

	@Override
	/**
	 * Enregistre les points de mémoire
	 */
	protected void iniPointsMemoire() {
		pointsMemoire = new ArrayList<>();
		UnPoint a = pointsSaisie.get(0);
		UnPoint b = pointsSaisie.get(1);
		UnPoint c, d;
		int xA = a.getX();
		int yA = a.getY();
		int xB = b.getX();
		int yB = b.getY();
		if(xA > xB && yA > yB || xA < xB && yA < yB) {
			c = new UnPoint(xA > xB ? xA : xB, yA < yB ? yA : yB);
			d = new UnPoint(xA < xB ? xA : xB, yA > yB ? yA : yB);
		} else {
			c = new UnPoint(xA > xB ? xA : xB, yA > yB ? yA : yB);
			d = new UnPoint(xA < xB ? xA : xB, yA < yB ? yA : yB);
		}
		pointsMemoire.add(a);
		pointsMemoire.add(c);
		pointsMemoire.add(b);
		pointsMemoire.add(d);
	}
}
