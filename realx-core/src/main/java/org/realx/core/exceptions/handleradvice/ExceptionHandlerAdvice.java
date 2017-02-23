package org.realx.core.exceptions.handleradvice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionHandlerAdvice {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

	public static Logger getLogger() {
		return LOGGER;
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = BadRequestException.class)
	@ResponseBody
	private ExceptionResponse badRequest(BadRequestException exception, WebRequest webRequest) {
		getLogger().error(exception.toString());
		return new ExceptionResponse().message(exception.getMessage());
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = NotFoundException.class)
	@ResponseBody
	private ExceptionResponse notFound(NotFoundException exception, WebRequest webRequest) {
		getLogger().error(exception.toString());
		return new ExceptionResponse().message(exception.getMessage());
	}

	@ResponseStatus(value = HttpStatus.FORBIDDEN)
	@ExceptionHandler(NoPermissionException.class)
	@ResponseBody
	private ExceptionResponse noPermission(NoPermissionException exception, WebRequest webRequest) {
		getLogger().error(exception.toString());
		return new ExceptionResponse().message(exception.getMessage());
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ServerErrorException.class)
	@ResponseBody
	private ExceptionResponse noPermission(ServerErrorException exception, WebRequest webRequest) {
		getLogger().error(exception.toString());
		return new ExceptionResponse().message(exception.getMessage());
	}

}
