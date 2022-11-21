package com.example.backendUX;

//import java.net.UnknownHostException;

//import org.bson.types.ObjectId;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.example.backendUX.repository.FacturaRepository;
//import com.example.backendUX.service.FacturaService;
//import com.mongodb.BasicDBObject;
//import com.mongodb.MongoException;



@SpringBootApplication
public class BackendUxApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendUxApplication.class, args);

		// Insertar datos
		/* 
		try {
			FacturaService servicios = new FacturaService()

			BasicDBObject document = new BasicDBObject();
			document.put("id", new ObjectId());
			document.put("nombre_acreedor", "Horacio");
			document.put("fecha", "23/01/2022");
			document.put("monto", 300000);
			document.put("mensaje", "Para los niños");
			document.put("correo_acreedor", "Horacio.jara@gmail.com");



		} catch (MongoException e){
			e.printStackTrace();
		}
		*/
		
	}

}
