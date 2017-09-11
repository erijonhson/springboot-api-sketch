package org.sketch;

import javax.servlet.http.HttpServletRequest;

import org.sketch.exception.ConflictRuntimeException;
import org.sketch.exception.Erro;
import org.sketch.exception.GoneRuntimeException;
import org.sketch.exception.NotFoundRuntimeException;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Captura exceções do sistema no contexto do Dispacher Servlet. Ou seja,
 * exceções de {@link FilterRegistrationBean}, ou do gênero, não serão tratadas
 * aqui.
 * 
 * @see https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc
 * 
 * @author Eri Jonhson
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	public GlobalDefaultExceptionHandler() {}

	/**
	 * Captura exceções genéricas e envia {@link Erro} ocorrido.
	 * O cliente receberá resposta com status Requisição Inválida (HTTP 400).
	 * 
	 * @param HttpServletRequest
	 * @param Throwable
	 * @return Erro ocorrido
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = {Throwable.class, Exception.class})
	@ResponseBody
	public Erro defaultErrorHandler(HttpServletRequest req, Throwable t) {
		if (StringUtils.isEmpty(t.getMessage()))
			return new Erro("Erro desconhecido!");
		return new Erro(t.getMessage());
	}

	/**
	 * Captura exceções {@link ConflictRuntimeException} e envia {@link Erro} ocorrido.
	 * O cliente receberá resposta com status Conflito (HTTP 409).
	 * 
	 * @param HttpServletRequest
	 * @param ConflictRuntimeException
	 * @return Erro ocorrido
	 */
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(value = ConflictRuntimeException.class)
	@ResponseBody
	public Erro conflictErrorHandler(HttpServletRequest req, ConflictRuntimeException cre) {
		return new Erro(cre.getMessage());
	}

	/**
	 * Captura exceções {@link NotFoundRuntimeException} e envia {@link Erro} ocorrido.
	 * O cliente receberá resposta com status Não Encontrado (HTTP 404).
	 * 
	 * @param HttpServletRequest
	 * @param NotFoundRuntimeException
	 * @return Erro ocorrido
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = NotFoundRuntimeException.class)
	@ResponseBody
	public Erro noContentErrorHandler(HttpServletRequest req, NotFoundRuntimeException nfre) {
		return new Erro(nfre.getMessage());
	}

	/**
	 * Captura exceções {@link GoneRuntimeException} e envia {@link Erro} ocorrido.
	 * O cliente receberá resposta com status Gone (HTTP 410).
	 * 
	 * @param HttpServletRequest
	 * @param GoneRuntimeException
	 * @return Erro ocorrido
	 */
	@ResponseStatus(HttpStatus.GONE)
	@ExceptionHandler(value = GoneRuntimeException.class)
	@ResponseBody
	public Erro noContentErrorHandler(HttpServletRequest req, GoneRuntimeException nfre) {
		return new Erro(nfre.getMessage());
	}

}
