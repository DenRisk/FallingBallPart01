package sample;

public class Frames {
    private static final long[] frameTimes = new long[100];
    private static int frameTimeIndex = 0 ;

    public static long[] getFrameTimes() {
        return frameTimes;
    }

    public static int getFrameTimeIndex() {
        return frameTimeIndex;
    }

    public static void setFrameTimeIndex(int frameTimeIndex) {
        Frames.frameTimeIndex = frameTimeIndex;
    }

    public static boolean isArrayFilled() {
        return arrayFilled;
    }

    public static void setArrayFilled(boolean arrayFilled) {
        Frames.arrayFilled = arrayFilled;
    }

    private static boolean arrayFilled = false ;


}
