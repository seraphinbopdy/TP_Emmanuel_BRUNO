package Repertoire_REST;

import Controller.ControllerChien;
import Entites.Chien;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("chienresource")
public class Chienres {

  private ControllerChien controllerChien = new ControllerChien();
    @GET
    @Path ("persist")
    public String AddChien()  {
        controllerChien.insertChien();
        return null + "System.out.println(\"Insertion Reussi\");\n";

    }

    @GET
    @Path("allChien")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Chien> getListPerson() {
         return controllerChien.getList();
    }


    @GET
    @Path("chien/{id:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Chien GetChienByID( @PathParam("id") int id) throws NotFoundException{
        return controllerChien.getChienByID(id);
    }


    @DELETE
    @Path("delete/{id}")
    public void deleteChien(@PathParam("id") int id){
        controllerChien.removeChien(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("update")
    public void updateChien(Chien chien){
        controllerChien.updateChien(chien);
    }

}
