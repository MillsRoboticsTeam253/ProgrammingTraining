package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {

    private XboxController xboxcontroller; 

    @Override
    protected void initialize() {
        xboxcontroller = new XboxController(1);

        requires(Robot.drivetrain);
    }

    @Override 
    protected void execute(){
        double left = xboxcontroller.getY(Hand.kLeft);
        double right = xboxcontroller.getY(Hand.kRight);

        Robot.drivetrain.drive(left, right);
    }

    @Override
    protected void end(){
        Robot.drivetrain.drive(0, 0);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}