/*
 * Service to get the active profile
 */

package sampleprojectusingprofile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;


import sampleprojectusingprofile.domain.ProfileProperties;

@Service
public class ActiveProfileService {
	
	@Value("${profile.title}")
	String profileTitle;
	
	
	@Autowired
	ProfileProperties profileproperties;
	//ProfileProperties p =new ProfileProperties();
	@Autowired
	Environment env;
	public String getActiveProfileName() {
		return profileproperties.getTitle()+" "+env.getProperty("profile.title");
	}
	
}
