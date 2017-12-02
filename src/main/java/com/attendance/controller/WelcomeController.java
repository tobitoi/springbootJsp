package com.attendance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("headingAttendance", "What is Attendance?");
		model.addAttribute("headingAttendancePolicy", "What is Attendance Policy?");
		model.addAttribute("descAttendancePolicy", "An attendance policy provides the guidelines and expectations for employee attendance at work as defined, written, disseminated, and implemented by an organization.\n" +
				"\n" +
				"Attendance policies exist most frequently for hourly or nonexempt employees for whom an organization must generally track hours and pay for overtime over 40 hours.\n" +
				"\n" +
				"Time at work record keeping is required by the Fair Labor Standards Act (FLSA) that governs the payment of overtime.\n" +
				"Additionally, employees for whom attendance is tracked often perform jobs that are interdependent on other employees being in attendance. Such jobs include production line work in a manufacturing facility.\n" +
				"\n" +
				"An attendance policy is sometimes used interchangeably with an absenteeism policy. My WEB-INF is that an attendance policy is much more narrowly defined and limited to attendance, as opposed to absenteeism policies which address absenteeism management issues and more.");
		model.addAttribute("description", "Attendance is the act or fact of attending (being present at) work. Attendance is also used to define the number of persons present on a particular day at work. As mentioned, it most frequently refers to jobs of hourly paid employees.\n" +
				"\n" +
				"Attendance is also referred to as present at work or presenteeism.");

		model.addAttribute("sample","A Sample No-Fault Attendance System");
		model.addAttribute("descSampel","A No-Fault Point System is one example of an effective attendance policy. The goal is to reward good attendance and eliminate the employment of people with poor attendance. It uses a point system and does not excuse absences.\n" +
				"\n" +
				"\n" +
				"This leaves managers and supervisors out of the role of judges, a role they hate to play. It places maximum accountability and responsibility for attendance on the employee which is where it ought to be.\n" +
				"\n" +
				"In a no-fault attendance system, absences are recorded similar to this:\n" +
				"\n" +
				"\n Each absence = 1 point (no multi-day occurrences)\n" +
				"\n Each late-in (tardy) or early-out = 1/2 point\n" +
				"\n Each no-show for work = 2 points\n" +
				"\n Each return with no prior call = 1 point\n" +
				"\n Each absence-free quarter eliminates all points and rewards the employee with a day off with pay.\n" +
				"\n Each employee starts fresh, with no points, each year.\n" +
				"Progressive disciplinary action accompanies a no-fault attendance system. If an employee earns so many points, they receive a warning that progressively worsens. A system like this allows both the employer and employee to know exactly what the consequences will be for poor attendance.\n" +
				"\n" +
				"\n 7 points = verbal warning\n" +
				"\n 8 points = written warning\n" +
				"\n 9 points = 3 day suspension\n" +
				"\n 10 points = termination\n" +
				"Here is a detailed attendance policy to review. It includes rewards and penalties for hourly employee attendance.");
		return "welcome";
	}
}
