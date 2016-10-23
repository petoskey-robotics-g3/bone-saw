package org.firstinspires.ftc.robotcontroller.internal.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Administrator on 9/29/2016.
 */
public class RcDrive extends OpMode {

    DcMotor leftDrive;
    DcMotor rightDrive;

    @Override
    public void init() {
        leftDrive = hardwareMap.dcMotor.get("left_drive");
        rightDrive = hardwareMap.dcMotor.get("right_drive");
    }

    @Override
    public void loop() {
        float leftY = -gamepad1.left_stick_y;
        float rightY = -gamepad1.right_stick_y;

        final double MIN_TURN = .5;
        double joysticX;
        double turnWith = joysticX * MIN_TURN;
        double right;
        double left;
        int joystick;
        double joystickY;
        double forwardDirection = (joystick == 0)  ? 0 : (joystickY / Math.abs(joystickY))
        double joystickX;
        double turnDirection = (joystickX == 0) ? 0 : (joystickX / Math.abs (joystickX))

        double leftPower;
        leftDrive.setPower(leftPower);
        double rightPower;
        rightDrive.setPower(rightPower);