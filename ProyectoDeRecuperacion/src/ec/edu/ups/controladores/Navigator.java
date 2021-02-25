package ec.edu.ups.controladores;

import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

@Named
@RequestScoped
public class Navigator {
	
	public Navigator() {
		
	}
	
	public String reglaRedir( String page ) {
		
		if(page.equals("crear")) {
			return "crear";
		}if(page.equals("Inicio")) {
			return "Inicio";
		}
		
		return page;
	}
}
