 package org.firstinspires.ftc.teamcode;

        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
/**
 * This OpMode represents the basic drive opMode
 *
 */
@TeleOp(name = "MainMovement(Tele-Op)", group = "Tele-Op")
public class MainMovement extends LinearOpMode {

    public void runOpMode(){
        DcMotor m1 = hardwareMap.dcMotor.get("blm");
        DcMotor m2 = hardwareMap.dcMotor.get("flm");
        DcMotor m3 = hardwareMap.dcMotor.get("brm");
        DcMotor m4 = hardwareMap.dcMotor.get("frm");
        DcMotor intake = hardwareMap.dcMotor.get("Intake");
        m1.setDirection(DcMotor.Direction.REVERSE);
        m2.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

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
                if(gamepad1.x) {

                }

                m1.setPower(0);
                m2.setPower(0);
                m3.setPower(0);
                m4.setPower(0);

            }

    }

}