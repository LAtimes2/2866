package org.pattonvillerobotics.team2866.opmodes.testing;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.pattonvillerobotics.team2866.robotclasses.OpMode;
import org.pattonvillerobotics.team2866.robotclasses.controllables.Drive;

/**
 * Created by skaggsm on 1/28/16.
 */
@OpMode("GyroTest")
public class GyroTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Drive drive = new Drive(hardwareMap, this);

        telemetry.addData("Heading ", drive.gyro.gyro.getIntegratedZValue());

        waitForStart();

        while (opModeIsActive()) {
            telemetry.addData("Heading ", drive.gyro.gyro.getIntegratedZValue());

            sleep(100);
        }
    }
}
