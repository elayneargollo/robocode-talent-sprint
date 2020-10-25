package exemplo;

import robocode.AdvancedRobot;
import robocode.BulletHitEvent;
import robocode.BulletMissedEvent;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;
import static robocode.util.Utils.normalRelativeAngleDegrees;

import java.awt.Color;

public class Robotic extends AdvancedRobot {
	int turnDirection = 1;

	public void run() {

		setBodyColor(Color.black);
		setGunColor(Color.cyan);
		setBulletColor(Color.orange);
		setBulletColor(Color.red);

		while (true) {
			turnRight(5 * turnDirection);
		}

	}

	public void onScannedRobot(ScannedRobotEvent e) {

		mira(e.getBearing());

		if (e.getEnergy() < 12 && getEnergy() > 50) {
			setBulletColor(Color.blue);
			tiroFatal(e.getEnergy());
		} else if (e.getEnergy() > 16 && e.getDistance() > 50) {
			setBulletColor(Color.pink);
			fire(2);
		} else if (e.getEnergy() > 200 || getEnergy() < 15) {
			setBulletColor(Color.orange);
			fire(1);
		}

		turnRight(90);
		ahead(100);

		fire(2);
		scan();
	}

	public void tiroFatal(double EnergiaIni) {
		double Tiro = (EnergiaIni / 4) + .1;
		fire(Tiro);
	}

	public void onHitByBullet(HitByBulletEvent e) {

		double angulo = normalRelativeAngleDegrees(90 - (getHeading() - e.getHeading()));

		turnRight(angulo);
		ahead(40);
		scan();

	}

	public void onHitWall(HitWallEvent e) {

		if (pertoParede()) {
			back(100);
		} else {
			ahead(100);
		}
	}

	public boolean pertoParede() {
		return (getX() < 50 || getX() > getBattleFieldWidth() - 50 || getY() < 50
				|| getY() > getBattleFieldHeight() - 50);
	}

	public void mira(double Adv) {

		double A = getHeading() + Adv - getGunHeading();

		if (!(A > -180 && A <= 180)) {
			while (A <= -180) {
				A += 360;
			}
			while (A > 180) {
				A -= 360;
			}
		}

		turnGunRight(A);
	}

	public void onHitRobot(HitRobotEvent e) {

		if (e.getBearing() > -90 && e.getBearing() < 90) {

			fire(2);
			mira(e.getBearing());
			fire(2);
			back(150);

		} else {

			fire(2);
			turnRight(e.getBearing());
			fire(3);
			ahead(150);
		}

		scan();

	}

	public void onBulletHit(BulletHitEvent e) {

		if (e.getLife() < 50 && e.getEnergy() < 50) {
			fire(3);
			ahead(100);
		}
	}

	public void onBulletMissed(BulletMissedEvent e) {
		// O que o robô vai fazer quando o tiro disparado errou o alvo
	}

}
