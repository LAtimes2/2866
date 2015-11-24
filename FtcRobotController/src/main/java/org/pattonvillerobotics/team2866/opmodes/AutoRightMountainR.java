package org.pattonvillerobotics.team2866.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.pattonvillerobotics.team2866.robotclasses.ClimbAssist;
import org.pattonvillerobotics.team2866.robotclasses.ClimberDumper;
import org.pattonvillerobotics.team2866.robotclasses.Direction;
import org.pattonvillerobotics.team2866.robotclasses.Drive;

/**
 * Created by mcmahonj on 11/12/15.
 */
public class AutoRightMountainR extends LinearOpMode {
    public static final String TAG = "AutoLongMountainRed";

    @Override
    public void runOpMode() throws InterruptedException {

        Drive drive = new Drive(hardwareMap, this);
        ClimberDumper climberDumper = new ClimberDumper(hardwareMap);
        ClimbAssist climbAssist = new ClimbAssist(hardwareMap);

        waitForStart();
        drive.moveInches(Direction.BACKWARDS, 69, 1); //66
        drive.rotateDegrees(Direction.LEFT, 45, 1); //Make sure this goes at a 45˚ angle!
        drive.moveInches(Direction.BACKWARDS, 24, 1); //92 inches or w/e up to the rescue bit
        drive.rotateDegrees(Direction.LEFT, 45, 1);
        drive.moveInches(Direction.BACKWARDS, 18, 1); //18 inches: NIN*2
        climberDumper.move(Direction.UP); //Moves the servo to dump the lil guys into the basket
        climberDumper.move(Direction.DOWN);
        drive.moveInches(Direction.FORWARDS, 18, 1);
        drive.rotateDegrees(Direction.LEFT, 135, 1);
        drive.moveInches(Direction.FORWARDS, 12, 1);
        drive.rotateDegrees(Direction.RIGHT, 90, 1);
        drive.moveInches(Direction.FORWARDS, 52, 1);
        climbAssist.moveChain(1);
        drive.moveInches(Direction.FORWARDS, 60, 1); //Measurement required
        climbAssist.moveChain(0);
        drive.stop();
    }
}
