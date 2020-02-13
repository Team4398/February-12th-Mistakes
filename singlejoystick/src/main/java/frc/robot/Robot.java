/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
//package edu.wpi.first.wpilibj.examples.tankdrive;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
//import edu.wpi.first.phoenix.CANVictorSPX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
//import edu.wpi.first.wpilibj.XboxController.Button;
//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot; 
  //new DifferentialDrive(new WPI_VictorSPX(0), new WPI_VictorSPX(1));
  //private final DifferentialDrive m_robotDrive =
  // new DifferentialDrive(new Spark(0), new Spark(1));
  //private final Joystick m_stick = new Joystick(0);
  private Joystick m_leftStick;
  private Joystick m_rightStick;
  public JoystickButton m_button;
  public Command holdCommand;
  Boolean flip;
  //private final Timer m_timer = new Timer();
  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_myRobot = new DifferentialDrive(new WPI_VictorSPX(0), new WPI_VictorSPX(1));
    m_leftStick = new Joystick(0);
    m_rightStick = new Joystick(1);
    //JoystickButton m_button;
    //Boolean flip;
    m_button = new JoystickButton(m_rightStick, 0);
  }

  @Override
public void autonomousInit() {
    //m_timer.reset();
    //m_timer.start();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
public void autonomousPeriodic() {
    // Drive for 2 seconds
    //if (m_timer.get() < 2.0) {
      //  m_robotDrive.arcadeDrive(0.5, 0.0); // drive forwards half speed
    //} else {
      //  m_robotDrive.stopMotor();} // stop robot
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  
  /**
   * This function is called periodically during autonomous.
   */

  /**
   * This function is called periodically during operator control.
   */
  @Override
    public void teleopInit() {
}

  /**
   * This function is called periodically during test mode.
   */
  @Override
   public void teleopPeriodic() {
    //m_robotDrive.arcadeDrive(m_stick.getY(), m_stick.getX());
    m_myRobot.tankDrive(m_leftStick.getY()*-.5, m_rightStick.getY()*-.5);
    if((m_button).whenPressed(holdCommand));
      flip = !flip;
    if(!flip);

}
}