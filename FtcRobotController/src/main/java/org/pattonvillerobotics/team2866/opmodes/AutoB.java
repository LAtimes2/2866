package org.pattonvillerobotics.team2866.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.pattonvillerobotics.team2866.robotclasses.ClimbAssist;
import org.pattonvillerobotics.team2866.robotclasses.ClimberDumper;
import org.pattonvillerobotics.team2866.robotclasses.DirectionEnum;
import org.pattonvillerobotics.team2866.robotclasses.Drive;
import org.pattonvillerobotics.team2866.robotclasses.OpMode;

/**
 * Created by Kevin Stewart & James McMahon on 10/15/15.
 */
@OpMode("Blue Autonomous")
public class AutoB extends LinearOpMode {

    public static final String TAG = "TestAutonomous";

    @Override
    public void runOpMode() throws InterruptedException {

        Drive drive = new Drive(hardwareMap, this);
        ClimberDumper climberDumper = new ClimberDumper(hardwareMap);
        ClimbAssist climbAssist = new ClimbAssist(hardwareMap);

        waitForStart();

        drive.moveInches(DirectionEnum.BACKWARDS, 30, 1); //66
        drive.rotateDegreesGyro(DirectionEnum.RIGHT, 45, 1); //Make sure this goes at a 45˚ angle!
        drive.moveInches(DirectionEnum.BACKWARDS, 72, 1); //92 inches or w/e up to the rescue bit
        drive.rotateDegreesGyro(DirectionEnum.RIGHT, 45, 1);
        CommonAutonomous.dumpClimber(drive,climberDumper);
        drive.rotateDegreesGyro(DirectionEnum.LEFT, 45, 1);
        drive.moveInches(DirectionEnum.FORWARDS, 18, 1);
        drive.rotateDegreesGyro(DirectionEnum.LEFT, 90, 1);
        drive.moveInches(DirectionEnum.FORWARDS, 60, 1); //Measurement required
        //climbAssist.moveChain(1);
        //climbAssist.moveChain(0);
        drive.stop();
    }
}