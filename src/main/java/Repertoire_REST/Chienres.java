package Repertoire_REST;

import Controller.ControllerChien;
import FichierSerialisationJson.ConvertToJson;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("chienresource")
public class Chienres {

  private ControllerChien controllerChien = new ControllerChien();
    private ConvertToJson json = new ConvertToJson();
    @PUT
    @Path ("persist")
    public void AddChien()  {
        controllerChien.insertChien();
    }

    @GET
    @Path("allChien")
    @Produces(MediaType.APPLICATION_JSON)
    public String getListPerson() {
        String asToString = json.serialiserChien(controllerChien.getList());
        return asToString;
    }


    @GET
    @Path("chien/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String GetChienByID(@PathParam("id") int id) throws NotFoundException{
        String asToString = json.serialiserChienById(controllerChien.getChienByID(id));
        return asToString;
    }


}
