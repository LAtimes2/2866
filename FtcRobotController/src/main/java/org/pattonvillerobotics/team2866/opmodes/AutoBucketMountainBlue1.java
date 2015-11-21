package org.pattonvillerobotics.team2866.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.pattonvillerobotics.team2866.robotclasses.ClimbAssist;
import org.pattonvillerobotics.team2866.robotclasses.ClimberDumper;
import org.pattonvillerobotics.team2866.robotclasses.Direction;
import org.pattonvillerobotics.team2866.robotclasses.Drive;
import org.pattonvillerobotics.team2866.robotclasses.OpMode;
import org.pattonvillerobotics.team2866.robotclasses.ZipRelease;

/**
 * Created by Kevin Stewart & James McMahon on 10/15/15.
 */
@OpMode("Blue Mountain 1")
public class AutoBucketMountainBlue1 extends LinearOpMode {

    public static final String TAG = "TestAutonomous";

    @Override
    public void runOpMode() throws InterruptedException {

        Drive drive = new Drive(hardwareMap, this);
        ClimberDumper climberDumper = new ClimberDumper(hardwareMap);
        ClimbAssist climbAssist = new ClimbAssist(hardwareMap);
        ZipRelease zipRelease = new ZipRelease(hardwareMap);

        zipRelease.moveLeft(Direction.DOWN);
        zipRelease.moveRight(Direction.DOWN);
        climberDumper.move(Direction.DOWN);

        waitForStart();

        drive.moveInches(Direction.BACKWARDS, 30, 1); //66
        drive.rotateDegrees(Direction.RIGHT, 45, .5); //Make sure this goes at a 45˚ angle!
        drive.moveInches(Direction.BACKWARDS, 62, 1); //92 inches or w/e up to the rescue bit
        drive.rotateDegrees(Direction.RIGHT, 45, .5);
        CommonAutonomous.dumpClimber(drive,climberDumper);
        drive.rotateDegrees(Direction.LEFT, 45, .5);
        drive.moveInches(Direction.FORWARDS, 19, 1);
        drive.rotateDegrees(Direction.LEFT, 90, .4);
        drive.moveInches(Direction.FORWARDS, 50, 1); //Measurement required
        //climbAssist.moveChain(1);
        //climbAssist.moveChain(0);
        drive.stop();
    }
}