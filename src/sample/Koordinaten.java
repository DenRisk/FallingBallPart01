package sample;

public class Koordinaten {
    public static float getStartX() {
        return startX;
    }

    public static void setStartX(float startX) {
        Koordinaten.startX = startX;
    }

    public static float getStartY() {
        return startY;
    }

    public static void setStartY(float startY) {
        Koordinaten.startY = startY;
    }

    private static float startX = 400, startY = 200;
}
