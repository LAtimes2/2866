package org.pattonvillerobotics.team2866.opmodes.testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.pattonvillerobotics.team2866.robotclasses.Direction;
import org.pattonvillerobotics.team2866.robotclasses.OpMode;
import org.pattonvillerobotics.team2866.robotclasses.controllables.Drive;

/**
 * Created by skaggsm on 11/19/15.
 */
@OpMode("Movement Test")
public class MovementTest extends LinearOpMode {

    enum TestType {
        ForwardDistance,
        TurnWithEncoders,
        TurnWithGyro
    }

    public static final String TAG = MovementTest.class.getSimpleName();

    @Override
    public void runOpMode() throws InterruptedException {

        Drive drive = new Drive(this.hardwareMap, this);
        waitForStart();


        final TestType test = TestType.TurnWithGyro;
        //noinspection ConstantConditions
        if (test == TestType.ForwardDistance) {
            telemetry.addData(TAG, "Moving 100 inches...");
            drive.moveInches(Direction.FORWARDS, 100, 1);
            telemetry.addData(TAG, "Finished moving.");
        } else if (test == TestType.TurnWithEncoders) {
            telemetry.addData(TAG, "Rotating 4 times (1440 deg)...");
            drive.rotateDegrees(Direction.RIGHT, 1440, 1);
            telemetry.addData(TAG, "Finished rotation.");
        } else if (test == TestType.TurnWithGyro) {
            telemetry.addData(TAG, "Rotating 90 degrees and back...");
            telemetry.addData("Heading ", drive.gyro.gyro.getIntegratedZValue());
            drive.rotateDegreesGyro(Direction.RIGHT, 90, 1);
            telemetry.addData("Heading ", drive.gyro.gyro.getIntegratedZValue());
            sleep(3000);
            drive.rotateDegreesGyro(Direction.LEFT, 90, 1);
            telemetry.addData("Heading ", drive.gyro.gyro.getIntegratedZValue());
            telemetry.addData(TAG, "Finished rotation.");
            sleep (60000);
        }
    }
}
