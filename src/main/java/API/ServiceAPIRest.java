package API;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import org.codehaus.jackson.map.ObjectMapper;

import DAO.InfosDAOImpl;


@Path("/Service")
public class ServiceAPIRest {

    private static final Logger log = Logger.getLogger(ServiceAPIRest.class);

    InfosDAOImpl dao = new InfosDAOImpl();
    
    public static void init() {
        if(log.getLevel() == null) {
            BasicConfigurator.configure();
            log.setLevel(Level.DEBUG);
        }
    }

    @GET
    @Path("/test")
    @Produces("application/json")
    public Response get() {
        init();
        log.info("ENTREE DANS LA METHODE GET EN GET");
        ArrayList<String> res;
		try {
			res = dao.read();
			return Response.status(200).entity(res).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).entity(e).build();
		}
    }
}
