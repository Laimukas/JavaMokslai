package lt.bit.Exercise16;

public enum Runner {
    BEGGINER(41, Integer.MAX_VALUE),
    INTERMEDIATE(20, 40),
    ADVANCED(1, 19),
    UNDEFINED(0,0);


    private int minMinutes, maxMinutes;

    Runner(int minMinutes, int maxMinutes) {
        this.minMinutes = minMinutes;
        this.maxMinutes = maxMinutes;
    }

    public static Runner getFitnessLevel(int minutes) {
        if (BEGGINER.minMinutes <= minutes && minutes <= BEGGINER.maxMinutes) {
            return BEGGINER;
        }
        if (INTERMEDIATE.minMinutes <= minutes && minutes <= INTERMEDIATE.maxMinutes) {
            return INTERMEDIATE;
        }
        if (ADVANCED.minMinutes <= minutes && minutes <= ADVANCED.maxMinutes) {
            return ADVANCED;
        }
        return UNDEFINED;
    }
}
