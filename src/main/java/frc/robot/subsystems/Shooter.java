// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.lang.module.Configuration;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.Shoot;
import static frc.robot.Constants.ShooterConstants.*;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public class Shooter extends SubsystemBase {
  private double flywheelSpeed;
  private double turretRotation;
  //private double hoodRotation;

  private final SparkMax flywheelSpeedMotor;
  private final SparkMax turretRotationMotor;
  //private final SparkMax hoodRotationMotor;

  public Shooter() {
    flywheelSpeed = 1.0;
    turretRotation = 0.0;
    //hoodRotation = 0.0;
    
    flywheelSpeedMotor = new SparkMax(FLYWHEEL_SPEED_MOTOR_ID, MotorType.kBrushless);
    turretRotationMotor = new SparkMax(TURRET_ROTATION_MOTOR_ID, MotorType.kBrushless);
    //hoodRotationMotor = new SparkMax(HOOD_ROTATION_MOTOR_ID, MotorType.kBrushless);

    SparkMaxConfig config = new SparkMaxConfig();
    config.voltageCompensation(12);
    config.smartCurrentLimit(DRIVE_MOTOR_CURRENT_LIMIT);
  }

  public void setFlywheelSpeed(double newFlywheelSpeed){
    flywheelSpeedMotor.set(newFlywheelSpeed);
  }
  public void setTurretRotation(double newTurretRotation){//settering i think
    turretRotationMotor.set(newTurretRotation);
  }
  //public void setHoodRotation(double newHoodRotation){
    //hoodRotationMotor.set(newHoodRotation);// ja
  // }

  public double getFlywheelSpeed(){
    return flywheelSpeed;
  }//     
  public double getTurretRotation(){//gettering i think
    return turretRotation;
  }

  public Command shoot() {
    return Commands.run(() -> setFlywheelSpeed(0.5));
  }

  public Command stop() {
    return Commands.run(() -> setFlywheelSpeed(0.0));
}
 // public double getHoodRotation(){
   // return hoodRotation;
  
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}


