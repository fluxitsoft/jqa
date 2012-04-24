package ar.com.fluxit.jqa;

import java.io.Reader;

import org.sonar.api.profiles.ProfileImporter;
import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.utils.ValidationMessages;

public class JQAProfileImporter extends ProfileImporter {

	protected JQAProfileImporter(String key, String name) {
		super(key, name);
	}

	@Override
	public RulesProfile importProfile(Reader reader, ValidationMessages messages) {
		return null;
	}

}
