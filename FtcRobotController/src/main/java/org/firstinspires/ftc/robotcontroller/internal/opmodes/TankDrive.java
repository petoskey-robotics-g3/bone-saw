package org.firstinspires.ftc.robotcontroller.internal.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by Administrator on 9/29/2016.
 */
public class TankDrive extends OpMode {

    DcMotor leftDrive;
    DcMotor rightDrive;

    @Override
    public void init() {
        leftDrive = hardwareMap.dcMotor.get("left_drive");
        rightDrive = hardwareMap.dcMotor.get("right_drive");

        leftDrive.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        //re-flip these values?
        float leftY = gamepad1.left_stick_y;
        float rightY = gamepad1.right_stick_y;

        leftDrive.setPower(leftY);
        rightDrive.setPower(rightY);
    }
}