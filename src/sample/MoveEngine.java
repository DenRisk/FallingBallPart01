package sample;


public class MoveEngine{

    private double gravity = 2000;
    private static boolean change = true;
    public MoveEngine(){
        if (change){
            Zeit.curTime = System.currentTimeMillis();
            change = false;
        }
        updateTime();
        summieren();
        kords();
    }

    public void updateTime() {

        Zeit.lastTime = Zeit.curTime;
        Zeit.curTime = System.currentTimeMillis();
        Zeit.timePassed = (Zeit.curTime - Zeit.lastTime);
        Zeit.timeFraction = (Zeit.timePassed / 1000.0);
//        System.out.println(Zeit.timeFraction);
    }

    public void showFPS(long now) {
        long oldFrameTime = Frames.getFrameTimes()[Frames.getFrameTimeIndex()];
        Frames.getFrameTimes()[Frames.getFrameTimeIndex()] = now;
        Frames.setFrameTimeIndex((Frames.getFrameTimeIndex() + 1) % Frames.getFrameTimes().length);
        if (Frames.getFrameTimeIndex() == 0) {
            Frames.setArrayFilled(true);
        }
        if (Frames.isArrayFilled()) {
            long elapsedNanos = now - oldFrameTime ;
            long elapsedNanosPerFrame = elapsedNanos /  Frames.getFrameTimes().length ;
            int frameRate = (int) (1_000_000_000.0 / elapsedNanosPerFrame);
        }
    }

    private void summieren(){
        // Wichtige Formel
        double vx = Geschwindigkeit.getStartVx() + (0 * Zeit.timeFraction);
        double vy = Geschwindigkeit.getStartVy() + (gravity * Zeit.timeFraction);

        // Wichtige Formel
        double drag = 1.0 - (Zeit.timeFraction * 0.4);

        Geschwindigkeit.setStartVx(vx * drag);
        Geschwindigkeit.setStartVy(vy);
    }

    private void kords(){
        double oldX = Koordinaten.getStartX();
        double oldY = Koordinaten.getStartY();

        // Wichtig Formel
        double newX = oldX + (Geschwindigkeit.getStartVx() * Zeit.timeFraction);
        double newY = oldY + (Geschwindigkeit.getStartVy() * Zeit.timeFraction);

        Koordinaten.setStartX((float) newX);
        Koordinaten.setStartY((float) newY);

        checkGround(newY);
        checkWall(newX);
    }

    private void checkGround(double groundY){
        if (groundY > 670){
            Koordinaten.setStartY(670);

            // Wichtige Formel
            Geschwindigkeit.setStartVy(-Geschwindigkeit.getStartVy() * 0.6);
        }
    }

    private void checkWall(double wallX){
        if (wallX>770){
            Koordinaten.setStartX(770);
            Geschwindigkeit.setStartVx(-Geschwindigkeit.getStartVx() * 0.6);
        }
        if (wallX < 30){
            Koordinaten.setStartX(30);
            Geschwindigkeit.setStartVx(-Geschwindigkeit.getStartVx() * 0.6);
        }
    }
}
