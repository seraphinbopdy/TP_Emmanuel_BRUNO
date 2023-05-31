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
        System.out.println("Insertion Chenil Reussi");

    }

    @GET
    @Path("allChenil")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Chenil> getListChenil() {
        return controllerChenil.getList();
    }


    @GET
    @Path("chenil/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Chenil GetChenilByID(@PathParam("id") int id) throws NotFoundException {
        return controllerChenil.getChenilByID(id);
    }


    @DELETE
    @Path("delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteChenil(@PathParam("id") int id){

        controllerChenil.removeChenil(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("update/")
    public void updateChenil( Chenil chenil){
        controllerChenil.updateChenil(chenil);
        System.err.println(chenil);
    }


}
