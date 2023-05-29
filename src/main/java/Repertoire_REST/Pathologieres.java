package Repertoire_REST;

import Controller.ControllerPathologie;
import FichierSerialisationJson.ConvertToJson;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("pathologieresource")
public class Pathologieres {



    ControllerPathologie controllerPathologie = new ControllerPathologie();
    ConvertToJson json = new ConvertToJson();
    @GET
    @Path("persist")
    public void AddPatahologie()  {
        controllerPathologie.insertPathologie();
    }

    @GET
    @Path("allPatho")
    @Produces(MediaType.APPLICATION_JSON)
    public String getListPatho() {
        String asToString = json.SerialiserPathologieList(controllerPathologie.getList());
        return asToString;
    }

    @GET
    @Path("pathologie/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String GetPathologieByID(@PathParam("id") int id) throws NotFoundException {
        String asToString = json.SerialiserPathologieById(controllerPathologie.getPathologieByID(id));
        return asToString;
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
