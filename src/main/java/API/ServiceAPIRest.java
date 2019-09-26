package API;

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

import Control.ControlErreur;


@Path("/Service")
public class ServiceAPIRest {

    private static final Logger log = Logger.getLogger(ServiceAPIRest.class);

    private ControlErreur control = new ControlErreur();
   
    public static void init() {
        if(log.getLevel() == null) {
            BasicConfigurator.configure();
            log.setLevel(Level.DEBUG);
        }
    }

    @GET
    @Path("/read")
    @Produces("application/json")
    public Response readErreurs() {
        init();
        log.info("READ ERRORS");
		try {
			return Response.status(200).entity(control.readErrors()).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).entity(e).build();
		}
    }
    
    @GET
    @Path("/findDCI/dci={dci}")
    @Produces("application/json")
    public Response findDCI(@PathParam("dci") String dci) {
        init();
        log.info("READ ERRORS");
		try {
			return Response.status(200).entity(control.findDCI(dci)).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).entity(e).build();
		}
    }
    
    @GET
    @Path("/findATC/atc={atc}")
    @Produces("application/json")
    public Response findATC(@PathParam("atc") String atc) {
        init();
        log.info("READ ERRORS");
		try {
			return Response.status(200).entity(control.findATC(atc)).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).entity(e).build();
		}
    }
    
    @POST
    @Path("/findName")
    @Produces("application/json")
    @Consumes("application/json")
    public Response findName(String name) {
        init();
        System.out.println("name : " + name);
        log.info("READ ERRORS");
		try {
			return Response.status(200).entity(control.findName(name)).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).entity(e).build();
		}
    }
    
    @GET
    @Path("/getName/{cip}")
    @Produces("application/json")
    public Response getName(@PathParam("cip") String cip) {
        init();
        log.info("READ ERRORS");
		try {
			return Response.status(200).entity("{ \"com\" : \""+control.getName(cip)+"\"}").build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).entity(e).build();
		}
    }
}
