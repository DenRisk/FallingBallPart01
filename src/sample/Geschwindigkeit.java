package sample;

public class Geschwindigkeit {
    public static double startVx = Main.startVx;
    public static double startVy = Main.startVy;

    public static double getStartVx() {
        return startVx;
    }

    public static void setStartVx(double startVx) {
        Geschwindigkeit.startVx = startVx;
    }

    public static double getStartVy() {
        return startVy;
    }

    public static void setStartVy(double startVy) {
        Geschwindigkeit.startVy = startVy;
    }

}
