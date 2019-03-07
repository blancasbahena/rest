package com.mx.service.ServiciosRestFull;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mx.service.ServiciosRestFull.bean.City;
import com.mx.service.ServiciosRestFull.service.CityService;
@RestController
@RequestMapping("/controller")

public class ControllerCity 
{
	 @Value("${Env.Heroku.Host}")
	    private String energy_env;
	@Autowired
	CityService cityService; 
	@RequestMapping(value = "/obtieneCiudades", method = RequestMethod.GET)
    public ResponseEntity<List<City>> obtieneCiudades() 
    {
        List<City> ciudades = cityService.findAll();
        String energy = System.getenv().get("ENERGY");
        System.out.println("Variable  : "+energy);
         
        System.out.println("energy_env  : "+energy_env);
        
        return new ResponseEntity<List<City>>(ciudades, HttpStatus.OK);
    }
	@RequestMapping(value = "/borrarCiudad/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCity(@PathVariable("id") long id) 
    { 
    	City delete1=new City();
    	delete1.setId(id); 
        return new ResponseEntity<String>((new Boolean(true)).toString(), HttpStatus.OK);
    }

}
