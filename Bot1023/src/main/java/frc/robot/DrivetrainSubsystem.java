package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DrivetrainSubsystem extends Subsystem {

    private VictorSPX
        leftMotorA = new VictorSPX(Constants.leftMotorA),
        leftMotorB = new VictorSPX(Constants.leftMotorB),
        rightMotorA = new VictorSPX(Constants.rightMotorA),
        rightMotorB = new VictorSPX(Constants.rightMotorB);
        

    private static DrivetrainSubsystem instance;
    public static DrivetrainSubsystem getInstance(){
        if(instance == null) instance = new DrivetrainSubsystem();
        return instance;
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new Drive());
    }

    private DrivetrainSubsystem() {
        leftMotorB.follow(leftMotorA);
        rightMotorB.follow(rightMotorA);
    }

    public void drive(double left, double right) {
        leftMotorA.set(ControlMode.PercentOutput, left);
        rightMotorA.set(ControlMode.PercentOutput, right);
           
    }
}
