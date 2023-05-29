package Repertoire_REST;

import Controller.ControllerChenil;
import FichierSerialisationJson.ConvertToJson;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("chenilresource")
public class Chenilres {

    ControllerChenil controllerChenil = new ControllerChenil();
    private ConvertToJson json = new ConvertToJson();
    @GET
    @Path("persist")
    public void AddChenil()  {
        controllerChenil.addChenil();
        System.out.println("Reussi");

    }

    @GET
    @Path("allChenil")
    @Produces(MediaType.APPLICATION_JSON)
    public String getListChenil() {
        String asToString = json.SerialiserChenilList(controllerChenil.getList());
        return asToString;
    }


    @GET
    @Path("chenil/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String GetChenilByID(@PathParam("id") int id) throws NotFoundException {
        return json.SerialiserChenilById(controllerChenil.getChenilByID(id));
    }





}
