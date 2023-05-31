package Repertoire_REST;

import Controller.ControllerPathologie;
import Entites.Pathologie;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("pathologieresource")
public class Pathologieres {



    ControllerPathologie controllerPathologie = new ControllerPathologie();
    @GET
    @Path("persist")
    public void AddPatahologie()  {
        controllerPathologie.insertPathologie();
        System.out.println(" Insertion Pathologie Reussi");

    }

    @GET
    @Path("allPatho")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pathologie> getListPatho() {
        return controllerPathologie.getList();
    }

    @GET
    @Path("pathologie/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pathologie GetPathologieByID( @PathParam("id") int id) throws NotFoundException {
        return controllerPathologie.getPathologieByID(id);
    }


    @DELETE
    @Path("delete/{id}")
    public void deletePathologie(@PathParam("id") int id){
        controllerPathologie.removePathologie(id);
    }

    @PUT
    @Path("update/{id}")
    public void updatePathologie(@PathParam("id") int id){
        controllerPathologie.updatePathologie(id);
    }


}
