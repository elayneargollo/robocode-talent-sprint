package elayne;

import robocode.AdvancedRobot;
import robocode.BulletHitEvent;
import robocode.BulletMissedEvent;
import robocode.DeathEvent;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;
import robocode.WinEvent;

import static robocode.util.Utils.normalRelativeAngleDegrees;

import java.awt.Color;

public class WarRobot extends AdvancedRobot {
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

	public void onScannedRobot(ScannedRobotEvent inimigo) {

		mira(inimigo.getBearing());

		if (inimigo.getEnergy() < 12 && getEnergy() > 50) {

			setBulletColor(Color.blue);
			tiroFatal(inimigo.getEnergy());

		} else if (inimigo.getEnergy() > 16 && inimigo.getDistance() > 50) {

			setBulletColor(Color.pink);
			fire(2);

		} else if (inimigo.getEnergy() > 200 || getEnergy() < 15) {

			setBulletColor(Color.orange);
			fire(1);

		}

		turnRight(90);
		ahead(100);

	}

	public void onHitRobot(HitRobotEvent inimigo) {

		double anguloInimigo = inimigo.getBearing();

		if (anguloInimigo > -90 && anguloInimigo < 90) {

			mira(inimigo.getBearing());
			fire(2);
			back(150);

		} else {

			turnRight(anguloInimigo);
			fire(3);
			ahead(150);
		}

		scan();

	}

	public void onHitByBullet(HitByBulletEvent inimigo) {

		turnRight(normalRelativeAngleDegrees(90 - (getHeading() - inimigo.getHeading())));
		ahead(100);

		scan();

	}

	public void onHitWall(HitWallEvent inimigo) {

		if (deslocamento()) {
			back(100);
		} else {
			ahead(100);
		}
	}

	public void onBulletHit(BulletHitEvent inimigo) {

		scan();

		if (inimigo.getEnergy() < 50 && getEnergy() > 60 && getGunHeat() > 50) {
			fire(3);
			ahead(this.getHeading() + 100);
		}
	}

	public void onBulletMissed(BulletMissedEvent inimigo) {

		scan();

	}

	public void tiroFatal(double energiaDoInimigo) {

		double shot = (energiaDoInimigo / 4) + .1;
		fire(shot);

	}

	public boolean deslocamento() {

		return (getX() < 50 || getX() > getBattleFieldWidth() - 50 || getY() < 50
				|| getY() > getBattleFieldHeight() - 50);

	}

	public void mira(double anguloInimigo) {

		double turnGunAmt = normalRelativeAngleDegrees(anguloInimigo + getHeading() - getGunHeading());
		turnGunRight(turnGunAmt);

	}

	public void onWin(WinEvent inimigo) {

		for (int i = 0; i < 50; i++) {
			turnRight(30);
			turnLeft(30);
		}
	}

	public void onDeath(DeathEvent inimigo) {

		System.out.println(getName() + " morreu!");
		System.out.println("Quantidade de inimigos ainda vivos: " + getOthers());

	}

}
