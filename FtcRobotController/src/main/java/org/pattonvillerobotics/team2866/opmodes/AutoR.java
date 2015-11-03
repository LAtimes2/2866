package org.pattonvillerobotics.team2866.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.pattonvillerobotics.team2866.robotclasses.DirectionEnum;
import org.pattonvillerobotics.team2866.robotclasses.Drive;
import org.pattonvillerobotics.team2866.robotclasses.OpMode;

/**
 * Created by skaggsm on 10/17/15.
 */
@OpMode("Red Autonomous")
public class AutoR extends LinearOpMode {

    public static final String TAG = "TestAutonomous";

    @Override
    public void runOpMode() throws InterruptedException {

        Drive drive = new Drive(hardwareMap);

        waitForStart();

        drive.moveInches(DirectionEnum.FORWARDS, 30, 1); //Make sure this doesn't cross over! Go 30 inches
        drive.rotateDegrees(DirectionEnum.LEFT, 45, 1); //Make sure this goes at a 45˚ angle!
        drive.moveInches(DirectionEnum.FORWARDS, 92, 1); //92 inches or w/e up to the rescue bit
        drive.moveInches(DirectionEnum.FORWARDS, 18, 1); //18 inches: NIN*2

    }
}