import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
public class PlayerShip extends Ship {
    boolean playerIsAccel;
    protected PlayerShip() {}
    public PlayerShip(int X, int Y, int sID) {
        // Pass maxVelocity to SpaceObj.
        super(5);
        turnRate = Math.PI / 160;
        baseAccelRate = .2;

        mass = 4;

        maxStructInteg = 150;
        structInteg = maxStructInteg;

        // Hilarious.
        //int numGuns = 300;
        //int numGuns = 1;

        Weapon w = BulletGun.newDefaultWeapon(this);
        // Hilarious.
        //w.setVelocity(w.getVelocity() * 2);
        //w.setTTL(w.getTTL() * 10);
        //w.setReloadTime(w.getReloadTime() / numGuns);
        weapons.add(w);

        shipID = sID;

        angle = .5*Math.PI;
        x = X;
        y = Y;
        dx = 0;
        dy = 0;
        playerIsAccel = false;

        origObjImg = null;
        try {
            origObjImg =
              ImageIO.read(getClass().getResource("playership.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        diam = origObjImg.getWidth();
    }
}
