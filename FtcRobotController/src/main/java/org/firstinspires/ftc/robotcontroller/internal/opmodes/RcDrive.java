package org.firstinspires.ftc.robotcontroller.internal.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Administrator on 10/2/2016.
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
        float joystickY = -gamepad1.left_stick_y;
        float joystickX = -gamepad1.right_stick_x;

        final double MIN_TURN = .5;
        double turnWidth = joystickX * MIN_TURN;
        double rightPower;
        double leftPower;
        double forwardDirection = (joystickY == 0) ? 0 : (joystickY / Math.abs(joystickY));
        double turnDirection = (joystickX == 0) ? 0 : (joystickX / Math.abs(joystickX));

        leftPower = joystickY + ((forwardDirection * turnDirection) * Math.abs(turnWidth));
        rightPower = joystickY - ((forwardDirection * turnDirection) * Math.abs(turnWidth));

        leftDrive.setPower(leftPower);
        rightDrive.setPower(rightPower);
    }
}
