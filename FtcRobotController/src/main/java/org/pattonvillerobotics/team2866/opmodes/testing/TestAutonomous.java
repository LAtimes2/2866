package org.pattonvillerobotics.team2866.opmodes.testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.pattonvillerobotics.team2866.robotclasses.Direction;
import org.pattonvillerobotics.team2866.robotclasses.OpMode;
import org.pattonvillerobotics.team2866.robotclasses.controllables.ClimbAssist;
import org.pattonvillerobotics.team2866.robotclasses.controllables.ClimberDumper;
import org.pattonvillerobotics.team2866.robotclasses.controllables.Drive;
import org.pattonvillerobotics.team2866.robotclasses.controllables.SuperBlocker;
import org.pattonvillerobotics.team2866.robotclasses.controllables.ZipRelease;

/**
 * Created by mcmahonj on 11/10/15.
 */
@OpMode("Test Autonomous")
public class TestAutonomous extends LinearOpMode {

    public static final String TAG = "TestAutonomous";

    @SuppressWarnings("MagicNumber")
    @Override
    public void runOpMode() throws InterruptedException {

        Drive drive = new Drive(hardwareMap, this);
        ClimberDumper climberDumper = new ClimberDumper(hardwareMap);
        ClimbAssist climbAssist = new ClimbAssist(hardwareMap);
        ZipRelease zipRelease = new ZipRelease(hardwareMap);
        SuperBlocker superBlocker = new SuperBlocker(hardwareMap);

        waitForStart();

        drive.moveInches(Direction.BACKWARDS, 100, .75);
    }
}