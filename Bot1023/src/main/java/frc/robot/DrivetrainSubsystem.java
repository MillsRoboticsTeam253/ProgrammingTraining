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

        rightMotorA.setInverted(true);
        rightMotorB.setInverted(true);
    }

    public void drive(double leftY, double rightY, double leftX, double rightX) {
        if (Math.abs(leftY) > 0.2 && Math.abs(rightY) > 0.2){
            leftMotorA.set(ControlMode.PercentOutput, leftY / 2);
            rightMotorA.set(ControlMode.PercentOutput, rightY / 2);
        } else{
            leftMotorA.set(ControlMode.PercentOutput, (leftY + leftX) / 2);
            rightMotorA.set(ControlMode.PercentOutput, -(rightY + rightX) / 2);
        }
    }
}
