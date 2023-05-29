package Repertoire_REST;

import Controller.ControllerPersonne;
import FichierSerialisationJson.ConvertToJson;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
@Path("personneresource")
public class Personneres {


   private ControllerPersonne controllerPersonne = new ControllerPersonne();
    private ConvertToJson json =  new ConvertToJson();

    @GET
    @Path("persist")
    public void AddPerson()  {
        controllerPersonne.insertPersonne();
        System.out.println("persist personne working!!");
    }



    @GET
    @Path("allPerson")
    @Produces(MediaType.APPLICATION_JSON)
    public String getListPerson() {
        String asToString = json.SerialiserPersonneList(controllerPersonne.getList());
        return asToString;
    }


    @GET
    @Path("person/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String GetPersonByID(@PathParam("id") int id) throws NotFoundException {
        String asToString = json.SerialiserPersonneById(controllerPersonne.getPersonByID(id));
        return asToString;
    }


      /*
    @PUT
    @Path("updatePerson")
    public void updatePerson( @QueryParam("id") int id,
                              @QueryParam("nom") String nom,
                              @QueryParam("prenom") String prenom){

        controller.updatePerson(id, nom, prenom);
        System.out.println("update is ok!");
    }

    /*
    @PUT
    @Path("deleteChienPerson/{idPersonne}")
    public void deleteChien( @PathParam("idPersonne") int idPersonne){
        controller.deleteChienPersonnne(idPersonne);

    }


     */





}
