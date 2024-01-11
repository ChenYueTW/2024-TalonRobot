package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCmd extends Command {
	private final IntakeSubsystem intakeSubsystem;
	private final XboxController controller;

	public IntakeCmd(IntakeSubsystem intakeSubsystem, XboxController controller) {
		this.intakeSubsystem = intakeSubsystem;
		this.controller = controller;

		addRequirements(this.intakeSubsystem);
	}

	@Override
	public void initialize() {}

	@Override
	public void execute() {
		if (this.controller.getYButton()) {
			this.intakeSubsystem.setSpeed(1.0);
		} else if (this.controller.getXButton()) {
			this.intakeSubsystem.setSpeed(-1.0);
		} else {
			this.intakeSubsystem.stopModules();
		}
	}

	@Override
	public void end(boolean interrupted) {
		this.intakeSubsystem.stopModules();
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}