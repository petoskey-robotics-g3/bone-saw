package org.firstinspires.ftc.robotcontroller.internal.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
<<<<<<< HEAD

/**
 * Created by Administrator on 9/29/2016.
=======
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by Administrator on 10/2/2016.
>>>>>>> 1bbf8bef0b8ccd32effb29f414fd98e08ce18404
 */
public class RcDrive extends OpMode {

    DcMotor leftDrive;
    DcMotor rightDrive;

    @Override
    public void init() {
        leftDrive = hardwareMap.dcMotor.get("left_drive");
        rightDrive = hardwareMap.dcMotor.get("right_drive");

        rightDrive.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        double joystickY = -gamepad1.left_stick_y;
        double joystickX = gamepad1.right_stick_x;

        final double MIN_TURN = .5;
        double turnWidth = joystickX * MIN_TURN;
        double rightPower;
        double leftPower;
        double forwardDirection = (joystickY == 0) ? 1 : (joystickY / Math.abs(joystickY));
        double turnDirection = (joystickX == 0) ? 0 : (joystickX / Math.abs(joystickX));

        leftPower = joystickY + ((forwardDirection * turnDirection) * Math.abs(turnWidth));
        rightPower = joystickY - ((forwardDirection * turnDirection) * Math.abs(turnWidth));

        if (rightPower > 1) {
            double shiftValue = (rightPower - 1);
            rightPower -= shiftValue ;
            leftPower -= shiftValue;
        } else if (leftPower > 1) {
            double shiftValue = (leftPower - 1);
            leftPower -= shiftValue;
            rightPower -= shiftValue;
        } else if (rightPower < -1) {
            rightPower -= (rightPower + 1);
            leftPower -= (rightPower + 1);
        } else if (leftPower < -1) {
            leftPower -= (leftPower + 1);
            rightPower -= (leftPower + 1);
        }

        leftDrive.setPower(leftPower);
        rightDrive.setPower(rightPower);

        telemetry.addData("joystick x", joystickX);
        telemetry.addData("left power", leftPower);
        telemetry.addData("right power", rightPower);
    }
}
//will was here