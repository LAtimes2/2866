package org.pattonvillerobotics.team2866.robotclasses.controllables;

import com.qualcomm.hardware.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.pattonvillerobotics.team2866.robotclasses.GamepadData;
import org.pattonvillerobotics.team2866.robotclasses.controller.GamepadFeature;

/**
 * Created by skaggsm on 11/14/15.
 */
public class MRGyroHelper implements Controllable {

    public static final String TAG = "GYROHELPER";
    private static final float DEGREE_DRIFT_PER_SECOND = -2 / 3f;
    public final ModernRoboticsI2cGyro gyro;
    private final LinearOpMode linearOpMode;
    private long lastCalibrationTime = System.nanoTime();

    public MRGyroHelper(ModernRoboticsI2cGyro gyro, LinearOpMode linearOpMode) {
        this.gyro = gyro;
        this.linearOpMode = linearOpMode;
    }

    public void preciseCalibration() throws InterruptedException {
        this.calibrateAndWait();
    }

    public void calibrateAndWait() throws InterruptedException {
        linearOpMode.telemetry.addData(TAG, "Starting calibration...");
        gyro.calibrate();
        while (gyro.isCalibrating()) {
            linearOpMode.waitForNextHardwareCycle();
        }
        Thread.sleep(3000);
        lastCalibrationTime = System.nanoTime();
        linearOpMode.telemetry.addData(TAG, "Calibration complete!");
    }

    public int getIntegratedZValue() {
        return gyro.getIntegratedZValue() + this.getCurrentDrift();
    }

    public int getCurrentDrift() {
        return Math.round(DEGREE_DRIFT_PER_SECOND * (System.nanoTime() - lastCalibrationTime) / 1000000000f);
    }

    @Override
    public boolean sendGamepadData(GamepadData gamepad1DataCurrent, GamepadData gamepad1DataHistory, GamepadData gamepad2DataCurrent, GamepadData gamepad2DataHistory) {
        if (gamepad1DataCurrent.b && !gamepad1DataHistory.b) {
            this.calibrate();
        }
        return true;
    }

    public void calibrate() {
        this.gyro.calibrate();
    }

    @Override
    public GamepadFeature[] requestFeatures() {
        return new GamepadFeature[]{GamepadFeature.GAMEPAD_1_BUTTON_B};
    }
}
