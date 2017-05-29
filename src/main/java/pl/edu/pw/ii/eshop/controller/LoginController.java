package pl.edu.pw.ii.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Klasa realizuj�ca funkcje kontrolera, kt�ry obs�uguje zapytania wysy�ane
 * poprzez przegl�dark� od u�ytkownik�w, zwi�zane z logowaniem.
 * 
 * @author �ukasz Kruk
 * @version 1.0
 */
@Controller
public class LoginController {

	/**
	 * Metoda obs�uguj�ca ��danie /login typu GET. W przypadku kiedy w rz�dniu
	 * jest przekazywany opcjonalny parametr error, do modelu jest dodawany
	 * atrybut error, nios�cy informacj� o problemach z logowaniem. Je�eli w
	 * rz�daniu jest przekazywany parametr logout, do modelu jest przekazywany
	 * atrybut msg nios�cy informacj� o wylogowaniu. Metoda zwraca nazw� widoku
	 * do wygenerowania w odpowiedzi
	 * 
	 * @param error
	 *            parametr rz�dania
	 * @param logout
	 *            parametr rz�dania
	 * @param model
	 *            interfejs, Spring dostarcza implementacj�. Holder dla
	 *            atrybut�w modelu w MVC.
	 * @return nazwa widoku
	 */
	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {

		if (error != null) {
			model.addAttribute("error", "Niepoprawny login lub has�o.");
		}
		if (logout != null) {
			model.addAttribute("msg", "Wylogowano pomy�lnie.");
		}
		return "login";
	}
}
