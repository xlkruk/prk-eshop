package pl.edu.pw.ii.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Klasa realizująca funkcje kontrolera, który obsługuje zapytania wysyłane
 * poprzez przeglądarkę od użytkowników, związane z logowaniem.
 * 
 * @author Łukasz Kruk
 * @version 1.0
 */
@Controller
public class LoginController {

	/**
	 * Metoda obsługująca żądanie /login typu GET. W przypadku kiedy w żądaniu
	 * jest przekazywany opcjonalny parametr error, do modelu jest dodawany
	 * atrybut error, niosący informację o problemach z logowaniem. Jeżeli w
	 * żądaniu jest przekazywany parametr logout, do modelu jest przekazywany
	 * atrybut msg niosący informację o wylogowaniu. Metoda zwraca nazwę widoku
	 * do wygenerowania w odpowiedzi
	 * 
	 * @param error
	 *            parametr żądania
	 * @param logout
	 *            parametr żądania
	 * @param model
	 *            interfejs, Spring dostarcza implementację. Holder dla
	 *            atrybutów modelu w MVC.
	 * @return nazwa widoku
	 */
	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {

		if (error != null) {
			model.addAttribute("error", "Niepoprawny login lub hasło.");
		}
		if (logout != null) {
			model.addAttribute("msg", "Wylogowano pomyślnie.");
		}
		return "login";
	}
}
