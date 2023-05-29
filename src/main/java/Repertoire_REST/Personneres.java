package Repertoire_REST;

import Controller.ControllerPersonne;
import Entites.Personne;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("personneresource")
public class Personneres {


   private ControllerPersonne controllerPersonne = new ControllerPersonne();

    @GET
    @Path("persist")
    public void AddPerson()  {
        controllerPersonne.insertPersonne();
        System.out.println("persist personne working!!");
    }



    @GET
    @Path("allPerson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Personne> getListPerson() {
          return controllerPersonne.getList();
    }


    @GET
    @Path("person/{id: \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Personne GetPersonByID(@PathParam("id") int id) throws NotFoundException {
      return controllerPersonne.getPersonByID(id);
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
