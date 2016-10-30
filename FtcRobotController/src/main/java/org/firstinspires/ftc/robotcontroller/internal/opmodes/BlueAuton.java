package org.firstinspires.ftc.robotcontroller.internal.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Administrator on 10/23/2016.
 */
public class BlueAuton extends LinearOpMode {

    DcMotor leftMotor;
    DcMotor rightMotor;
    private final double COUNTS_PER_MOTOR_REV = 1440;      // eg: TETRIX Motor Encoder
    private final double WHEEL_DIAMETER_METRIC = 10.0012;
    private final double WHEEL_CIRCUMFERENCE_METRIC = (2*Math.PI)*(1/2*WHEEL_DIAMETER_METRIC);

    @Override
    public void runOpMode() throws InterruptedException {
        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        waitForStart();  //this will not start until our drivers say so 
    }

    public double getRevsPerCounts(double counts){

        double revolutions = counts / COUNTS_PER_MOTOR_REV;
        return revolutions;

    }

    public double getCentimetersRevs (double revolutions){

        double centimeters = revolutions * WHEEL_CIRCUMFERENCE_METRIC;
        return centimeters;

    }
}
