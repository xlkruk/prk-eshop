package pl.edu.pw.ii.eshop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Klasa realizuj¹ca funkcje kontrolera, który obs³uguje zapytania wysy³ane
 * poprzez przegl¹darkê od u¿ytkowników.
 * 
 * @author £ukasz Kruk
 * @version 1.0
 */
@Controller
public class ErrorController {

	/**
	 * Metoda realizuj¹ca przekierowanie na stronê errorPage.jsp w przypadku
	 * odpowiedzi HTTP reprezentj¹cej niepowodzenie obs³ugi ¿¹dania.
	 * 
	 * @param httpRequest
	 *            obiekt rz¹dania {@link HttpServletRequest}
	 * @return nazwa widoku generowanego w przypadku b³êdu.
	 */
	@RequestMapping(value = "errors", method = RequestMethod.GET)
	public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {
		ModelAndView errorPage = new ModelAndView("errorPage");
		String errorMsg = "";
		int httpErrorCode = getErrorCode(httpRequest);
		switch (httpErrorCode) {
		case 400: {
			errorMsg = "Http Error Code: 400. Bad Request";
			break;
		}
		case 401: {
			errorMsg = "Http Error Code: 401. Unauthorized";
			break;
		}
		case 413: {
			errorMsg = "Http Error Code: 413. Unauthorized";
			break;
		}
		case 404: {
			errorMsg = "Http Error Code: 404. Resource not found";
			break;
		}
		case 405: {
			errorMsg = "Http Error Code: 405. Method not allowed";
			break;
		}
		case 500: {
			errorMsg = "Http Error Code: 500. Internal Server Error";
			break;
		}
		}
		errorPage.addObject("errorMsg", errorMsg);
		return errorPage;
	}

	/**
	 * Metoda realizuj¹ca przekierowanie na stronê errorPage.jsp w przypadku
	 * odpowiedzi HTTP reprezentj¹cej niepowodzenie obs³ugi ¿¹dania POST.
	 * 
	 * @param httpRequest
	 *            obiekt rz¹dania {@link HttpServletRequest}
	 * @return nazwa widoku generowanego w przypadku b³êdu.
	 */
	@RequestMapping(value = "errors", method = RequestMethod.POST)
	public ModelAndView renderErrorPagePOST(HttpServletRequest httpRequest) {
		ModelAndView errorPage = new ModelAndView("errorPage");
		String errorMsg = "";
		int httpErrorCode = getErrorCode(httpRequest);
		switch (httpErrorCode) {
		case 400: {
			errorMsg = "Http Error Code: 400. Bad Request";
			break;
		}
		case 401: {
			errorMsg = "Http Error Code: 401. Unauthorized";
			break;
		}
		case 413: {
			errorMsg = "Http Error Code: 413. Unauthorized";
			break;
		}
		case 404: {
			errorMsg = "Http Error Code: 404. Resource not found";
			break;
		}
		case 405: {
			errorMsg = "Http Error Code: 405. Method not allowed";
			break;
		}
		case 500: {
			errorMsg = "Http Error Code: 500. Internal Server Error";
			break;
		}
		}
		errorPage.addObject("errorMsg", errorMsg);
		return errorPage;
	}

	private int getErrorCode(HttpServletRequest httpRequest) {
		return (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
	}
}