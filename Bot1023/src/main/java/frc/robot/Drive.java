package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {

   private Joystick joystickL;
   private Joystick joystickR;

   public Drive(){
    requires(Robot.drivetrain);
   }

    @Override
    protected void initialize() {
        joystickL = new Joystick(2);
        joystickR = new Joystick(3);

        
    }

    @Override 
    protected void execute(){
        double left = joystickL.getY();
        double right = joystickR.getY();

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