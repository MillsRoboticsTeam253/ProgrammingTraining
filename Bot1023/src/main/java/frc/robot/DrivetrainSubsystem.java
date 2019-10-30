package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DrivetrainSubsystem extends Subsystem {

    private TalonSRX
        leftMotorA = new TalonSRX(Constants.leftMotorA),
        leftMotorB = new TalonSRX(Constants.leftMotorB),
        rightMotorA = new TalonSRX(Constants.rightMotorA),
        rightMotorB = new TalonSRX(Constants.rightMotorB);
        

    private static DrivetrainSubsystem instance;
    public static DrivetrainSubsystem getInstance(){
        if(instance == null) instance = new DrivetrainSubsystem();
        return instance;
    }

    @Override
    protected void initDefaultCommand() {

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
