package pl.edu.pw.ii.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Klasa realizuj¹ca funkcje kontrolera, który obs³uguje zapytania wysy³ane
 * poprzez przegl¹darkê od u¿ytkowników, zwi¹zane z logowaniem.
 * 
 * @author £ukasz Kruk
 * @version 1.0
 */
@Controller
public class LoginController {

	/**
	 * Metoda obs³uguj¹ca ¿¹danie /login typu GET. W przypadku kiedy w rz¹dniu
	 * jest przekazywany opcjonalny parametr error, do modelu jest dodawany
	 * atrybut error, nios¹cy informacjê o problemach z logowaniem. Je¿eli w
	 * rz¹daniu jest przekazywany parametr logout, do modelu jest przekazywany
	 * atrybut msg nios¹cy informacjê o wylogowaniu. Metoda zwraca nazwê widoku
	 * do wygenerowania w odpowiedzi
	 * 
	 * @param error
	 *            parametr rz¹dania
	 * @param logout
	 *            parametr rz¹dania
	 * @param model
	 *            interfejs, Spring dostarcza implementacjê. Holder dla
	 *            atrybutów modelu w MVC.
	 * @return nazwa widoku
	 */
	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {

		if (error != null) {
			model.addAttribute("error", "Niepoprawny login lub has³o.");
		}
		if (logout != null) {
			model.addAttribute("msg", "Wylogowano pomyœlnie.");
		}
		return "login";
	}
}
