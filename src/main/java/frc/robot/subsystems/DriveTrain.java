/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {

  private Spark m_leftFrontMotor = new Spark(Constants.LEFT_FRONT_MOTOR_PORT);
  private Spark m_leftBackMotor = new Spark(Constants.LEFT_BACK_MOTOR_PORT);
  private Spark m_rightFrontMotor = new Spark(Constants.RIGHT_FRONT_MOTOR_PORT);
  private Spark m_rightBackMotor = new Spark(Constants.RIGHT_BACK_MOTOR_PORT);

  private SpeedControllerGroup m_leftGroup = new SpeedControllerGroup(m_leftFrontMotor, m_leftBackMotor);
  private SpeedControllerGroup m_rightGroup = new SpeedControllerGroup(m_rightFrontMotor, m_rightBackMotor);

  private DifferentialDrive m_differentialDrive = new DifferentialDrive(m_leftGroup, m_rightGroup);

  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {
    //m_leftGroup.setInverted(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void tankDrive(double left, double right)
  {
    m_differentialDrive.tankDrive(-left, right);
  }

  public void stop() {
    m_differentialDrive.stopMotor();
  }
}
