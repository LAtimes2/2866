package org.pattonvillerobotics.team2866.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.pattonvillerobotics.team2866.robotclasses.ClimbAssist;
import org.pattonvillerobotics.team2866.robotclasses.ClimberDumper;
import org.pattonvillerobotics.team2866.robotclasses.Direction;
import org.pattonvillerobotics.team2866.robotclasses.Drive;
import org.pattonvillerobotics.team2866.robotclasses.OpMode;

/**
 * Created by Kevin Stewart & James McMahon on 10/15/15.
 *
 * TODO: Walk through values
 * TODO: Initialize servo values
 */
@OpMode("Blue Park 1")
public class AutoBucketParkBlue1 extends LinearOpMode {

    public static final String TAG = "Blue Park Autonomous";

    @Override
    public void runOpMode() throws InterruptedException {

        Drive drive = new Drive(hardwareMap, this);
        ClimberDumper climberDumper = new ClimberDumper(hardwareMap);
        ClimbAssist climbAssist = new ClimbAssist(hardwareMap);

        waitForStart();

        CommonAutonomous.leadPosition1(drive);
        drive.rotateDegrees(Direction.RIGHT, 45, 1); //Make sure this goes at a 45˚ angle!
        drive.moveInches(Direction.BACKWARDS, 72, 1); //92 inches or w/e up to the rescue bit
        drive.rotateDegrees(Direction.RIGHT, 45, 1);
        drive.moveInches(Direction.BACKWARDS, 18, 1); //18 inches: NIN*2
        climberDumper.move(Direction.UP); //Moves the servo to dump the lil guys into the basket
        climberDumper.move(Direction.DOWN);
        drive.stop();
    }
}
