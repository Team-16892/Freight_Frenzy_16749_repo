package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
/**
 * This OpMode represents the basic drive opMode
 *
 */
@TeleOp(name = "MainMovement(Tele-Op)", group = "Tele-Op")
public class MainMovement extends LinearOpMode {

    public void runOpMode(){
        //Motors
         Motor blm = hardwareMap.dcMotor.get("blm");
         Motor flm = hardwareMap.dcMotor.get("flm");
         Motor brm = hardwareMap.dcMotor.get("brm");
         Motor frm = hardwareMap.dcMotor.get("frm");
         Motor intake = hardwareMap.dcMotor.get("intakeMotor");
        //Servos
         Servo intakeClaw = hardwareMap.servo.get("intakeClaw");



        //Motor Settings
        blm.setDirection(DcMotor.Direction.REVERSE);
        flm.setDirection(DcMotor.Direction.REVERSE);
//        m1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        m2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        m3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        m4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        m1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        m2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        m3.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        m4.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //Servo Settings
        public final static double intakeClaw_HOME = 0.2;// Starting Postion of the servo.
        public final static double intakeClaw_MIN_RANGE = 0.0;//Minimum range of the servo.
        public final static double intakeClaw_MAX_RANGE = 0.7;//Maximum range of the servo.
        public final static double intakeClaw_SPEED = 0.1;//Servo speed
        public final static double intakeClaw_POSITION = intakeClaw_HOME;//Servo speed

        intakeClaw.setPosition(intakeClaw_HOME);
        gamepad1.setJoystickDeadzone(0.05f);

        waitForStart();
        public static void main(String[] args){
        while (opModeIsActive()){
            double px = gamepad1.left_stick_x;
            double py = -gamepad1.left_stick_y;
            double pa = gamepad1.left_trigger - gamepad1.right_trigger;
            if (Math.abs(pa) < 0.05) pa = 0;
            double p1 = -px + py - pa;
            double p2 = px + py + -pa;
            double p3 = -px + py + pa;
            double p4 = px + py + pa;
            double max = Math.max(1.0, Math.abs(p1));
            max = Math.max(max, Math.abs(p2));
            max = Math.max(max, Math.abs(p3));
            max = Math.max(max, Math.abs(p4));
            p1 /= max;
            p2 /= max;
            p3 /= max;
            p4 /= max;
            m1.setPower(p1);
            m2.setPower(p2);
            m3.setPower(p3);
            m4.setPower(p4);
            intakeClaw_POSITION = Range.clip(intakeClaw_POSITION, intakeClaw_MIN_RANGE, intakeClaw_MAX_RANGE);
            if(gamepad1.x) {
                intakeClaw_HOME += intakeClaw_SPEED;
            }else{
                intakeClaw_HOME -= intakeClaw_SPEED;
            }

            m1.setPower(0);
            m2.setPower(0);
            m3.setPower(0);
            m4.setPower(0);
            }
        }
    }

}