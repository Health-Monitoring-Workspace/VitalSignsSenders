package generators;


import java.util.Random;

public class Generator {

    private static final Integer MIN_PULSE_VALUE = 10;
    private static final Integer MAX_PULSE_VALUE = 180;
    private static final Integer MIN_BLOOD_PRESSURE_SYSTOLIC = 90;
    private static final Integer MAX_BLOOD_PRESSURE_SYSTOLIC = 180;
    private static final Integer MIN_BLOOD_PRESSURE_DIASTOLIC = 40;
    private static final Integer MAX_BLOOD_PRESSURE_DIASTOLIC = 120;
    private static final Integer MAX_OXYGEN_IN_BLOOD = 100;
    private static final Integer MIN_OXYGEN_IN_BLOOD = 60;
    private static final Double MAX_BODY_TEMPERATURE = 44.0;
    private static final Double MIN_BODY_TEMPERATURE = 34.0;

    public static Integer generatePulse() {
        Random random = new Random();

        return random.nextInt(MAX_PULSE_VALUE - MIN_PULSE_VALUE + 1) + MIN_PULSE_VALUE;
    }

    public static String generateBloodPressure() {
        Random random = new Random();
        int systolic = random.nextInt(MAX_BLOOD_PRESSURE_SYSTOLIC - MIN_BLOOD_PRESSURE_SYSTOLIC + 1) + MIN_BLOOD_PRESSURE_SYSTOLIC;
        int diastolic = random.nextInt(MAX_BLOOD_PRESSURE_DIASTOLIC - MIN_BLOOD_PRESSURE_DIASTOLIC + 1) + MIN_BLOOD_PRESSURE_DIASTOLIC;

        return systolic + "/" + diastolic;
    }

    public static Integer generateOxygenInBlood() {
        Random random = new Random();

        return random.nextInt(MAX_OXYGEN_IN_BLOOD - MIN_OXYGEN_IN_BLOOD + 1) + MIN_OXYGEN_IN_BLOOD;
    }

    public static Double generateBodyTemperature() {
        Random random = new Random();

        return MIN_BODY_TEMPERATURE + (MAX_BODY_TEMPERATURE - MIN_BODY_TEMPERATURE) * random.nextDouble();

    }

}
