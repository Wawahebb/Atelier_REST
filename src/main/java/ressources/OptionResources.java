package ressources;

import entities.Option;
import metiers.OptionBusiness;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("options")
public class OptionResources {

    public static OptionBusiness optionBusiness = new OptionBusiness();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Option> getAll() {
        return optionBusiness.getListeOptions();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOption(Option o) {
        if (optionBusiness.addOption(o))
            return Response.status(Status.OK).build();
        return Response.status(Status.NOT_FOUND).build();
    }
}