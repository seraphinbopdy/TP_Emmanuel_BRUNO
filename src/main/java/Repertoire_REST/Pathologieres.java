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
    }

    @GET
    @Path("allPatho")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pathologie> getListPatho() {
        return controllerPathologie.getList();
    }

    @GET
    @Path("pathologie/{id:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pathologie GetPathologieByID( @PathParam("id") int id) throws NotFoundException {
        return controllerPathologie.getPathologieByID(id);
    }


    /*
    *  @PUT
    @Path ("deletePatho/{id}")
    public void deletePatahologie(@PathParam("id") long id){
        patologieController.deletePathoById(id);
    }
    *
    * */





}
