package org.pattonvillerobotics.team2866.opmodes;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.pattonvillerobotics.team2866.robotclasses.ClimbAssist;
import org.pattonvillerobotics.team2866.robotclasses.ClimberDumper;
import org.pattonvillerobotics.team2866.robotclasses.Direction;
import org.pattonvillerobotics.team2866.robotclasses.Drive;
import org.pattonvillerobotics.team2866.robotclasses.OpMode;

/**
 * Created by skeltonn on 11/20/15.
 * <p/>
 * TODO: Measure and write OpMode
 */
@OpMode("Red Park 1")
public class AutoBucketParkRed1 extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        Drive drive = new Drive(hardwareMap, this);
        ClimberDumper climberDumper = new ClimberDumper(hardwareMap);
        ClimbAssist climbAssist = new ClimbAssist(hardwareMap);

        waitForStart();

        CommonAutonomous.firstPosition1(drive);
        drive.rotateDegrees(Direction.LEFT, 45, 0.5); //Make sure this goes at a 45˚ angle!
        CommonAutonomous.secondPositionTravel(drive);
        drive.rotateDegrees(Direction.LEFT, 45, 0.5);
        CommonAutonomous.dumpClimber(drive);
        drive.stop();

    }
}
