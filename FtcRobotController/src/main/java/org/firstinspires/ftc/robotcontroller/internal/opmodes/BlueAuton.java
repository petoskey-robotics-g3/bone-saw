package org.firstinspires.ftc.robotcontroller.internal.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;

/**
 * Created by Administrator on 10/23/2016.
 */
public class BlueAuton extends LinearOpMode {
    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private final double SPEED = 0.25;
    private final double ENCODER_COUNTS_PER_MOTOR_REV = 1440;    // eg: TETRIX Motor Encoder
    private final double DRIVE_GEAR_REDUCTION = 0.5;     // This is < 1.0 if geared UP
    private final double WHEEL_DIAMETER_INCHES = 4.0;     // For figuring circumference
    private final double COUNTS_PER_INCH = (ENCODER_COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) / (WHEEL_DIAMETER_INCHES * 3.1415);
    private final double WHEEL_CIRCUMFERENCE_INCHES = WHEEL_DIAMETER_INCHES * Math.PI;
    private final double AUTON_DISTANCE = 5; //TODO: change this to the correct number
    private GyroSensor gyroSensor;
    private final double TURN_DEGREES = 45;
}

    @Override
    public void runOpMode() throws InterruptedException {

        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");

        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        gyroSensor = hardwareMap.gyroSensor.get("gyro");
        waitForStart();  //this will not start until our drivers say so
        calibrateGyro();
        turn(degrees,direction);

    }

public  void calibrateGyro() throws InterruptedException{
        gyroSensor.calibrate();
        while(gyroSensor.isCalibrating()) {
            Thread.sleep(50);
            idle();
        }

    public double convertDistanceToRevs(double distance){

        double revolutions = distance / WHEEL_CIRCUMFERENCE_INCHES;
        return revolutions;

    }

    public double convertWheelRevsToMotorRevs(double revolutions){

        double motorRevs = revolutions * DRIVE_GEAR_REDUCTION;
        return motorRevs;

    }

    public double encoderCounts(double motorRevs){

        double counts = motorRevs * ENCODER_COUNTS_PER_MOTOR_REV;
        return counts;

    }

    public void driveStraight(double distance){

        double revolutions = convertDistanceToRevs(distance);
        double motorRevs = convertWheelRevsToMotorRevs(revolutions);
        double counts = encoderCounts(motorRevs);
        
    leftMotor.setTargetPosition((int)counts);
    rightMotor.setTargetPosition((int)counts);

    leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    leftMotor.setPower(0.5);
    rightMotor.setPower(0.5);

    telemetry.addData("Motor Target",counts);
    telemetry.addData("Left Motor", leftMotor.getCurrentPosition());
    telemetry.addData("Right Motor", rightMotor.getCurrentPosition());
    }
}
