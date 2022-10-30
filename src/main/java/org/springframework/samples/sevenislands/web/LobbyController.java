package org.springframework.samples.sevenislands.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.samples.sevenislands.user.User;

@Controller
public class LobbyController {

	@GetMapping({ "/lobby" })
	public String welcome(User user) {
		return "views/lobby";
	}
}
