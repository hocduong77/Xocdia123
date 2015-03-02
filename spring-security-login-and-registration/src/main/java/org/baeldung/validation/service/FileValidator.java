package org.baeldung.validation.service;

import org.baeldung.persistence.service.File;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



public class FileValidator implements Validator {
	public boolean supports(Class<?> paramClass) {
		return File.class.equals(paramClass);
	}

	public void validate(Object obj, Errors errors) {
		File file = (File) obj;
		System.out.println(file.toString());
		  if (file.getFile().getSize() == 0) {
		   errors.rejectValue("file", "valid.file");
		  }
	}
}
