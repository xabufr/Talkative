package com.talkative.models;

import org.junit.Test;
import static org.junit.Assert.*;

import com.talkative.resource.InputValidator;

public class InputValidatorTest {

	@Test
	public void canTellIfAPasswordIsValid() {
		assertTrue(InputValidator.isAValidPassword("123456789"));
		assertFalse(InputValidator.isAValidPassword("12345"));
	}

	@Test
	public void canTellIfALoginIsValid() {
		assertTrue(InputValidator.isAValidLogin("toto"));
		assertTrue(InputValidator.isAValidLogin("toto_"));
		assertFalse(InputValidator.isAValidLogin("tot"));
		assertFalse(InputValidator.isAValidLogin("_tot"));
		assertFalse(InputValidator.isAValidLogin("6tot"));
		assertFalse(InputValidator.isAValidLogin("t6ot,"));
	}
	
	@Test
	public void canTellIfAnEMailIsValid() {
		assertTrue(InputValidator.isAValidEMail("toto@toto.fr"));
		assertFalse(InputValidator.isAValidEMail(""));
		assertFalse(InputValidator.isAValidEMail("toto"));
		assertFalse(InputValidator.isAValidEMail("toto@"));
		assertFalse(InputValidator.isAValidEMail("t6ot@toto"));
		assertFalse(InputValidator.isAValidEMail("t6ot@toto.f"));
		assertFalse(InputValidator.isAValidEMail("t6ot@t.fr"));
	}
	
}
