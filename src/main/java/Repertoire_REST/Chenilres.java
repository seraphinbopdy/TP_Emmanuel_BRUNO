package Repertoire_REST;

import Controller.ControllerChenil;
import Entites.Chenil;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("chenilresource")
public class Chenilres {

    ControllerChenil controllerChenil = new ControllerChenil();
    @GET
    @Path("persist")
    public void AddChenil()  {
        controllerChenil.addChenil();
        System.out.println("Reussi");

    }

    @GET
    @Path("allChenil")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Chenil> getListChenil() {
        return controllerChenil.getList();
    }


    @GET
    @Path("chenil/{id : \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Chenil GetChenilByID(@PathParam("id") int id) throws NotFoundException {
        return controllerChenil.getChenilByID(id);
    }





}
