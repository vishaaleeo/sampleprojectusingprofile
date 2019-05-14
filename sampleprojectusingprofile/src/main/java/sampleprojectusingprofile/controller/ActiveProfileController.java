/*
 * Controller to set active profile and display active profile
 */
package sampleprojectusingprofile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sampleprojectusingprofile.service.ActiveProfileService;

@RestController
public class ActiveProfileController {
	
	@Autowired
	ActiveProfileService activeProfileService;
	
	@RequestMapping("/welcome/{profile}")
	public String setActiveProfile(@PathVariable("profile") String profileName) {
		System.setProperty("spring.profiles.active", profileName);
		System.out.println(profileName);
		return "done";
		
	}

	@RequestMapping("/showprofile")
	public String showProfile()
	{
		return "active profile is "+activeProfileService.getActiveProfileName();
	}
	
}
