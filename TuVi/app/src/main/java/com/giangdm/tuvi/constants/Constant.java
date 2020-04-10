package com.giangdm.tuvi.constants;

public class Constant {

    public long timestamp = 0;
    private static final int THRESHOLD = 1000;

    public boolean isOverThreashold(long now) {
        return now - timestamp > THRESHOLD;
    }
}
