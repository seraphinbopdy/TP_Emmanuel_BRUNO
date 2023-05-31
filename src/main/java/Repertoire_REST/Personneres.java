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
        System.out.println("Insertion Personne Reussi");
    }



    @GET
    @Path("allPerson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Personne> getListPerson() {
          return controllerPersonne.getList();
    }


    @GET
    @Path("person/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Personne GetPersonByID(@PathParam("id") int id) throws NotFoundException {
      return controllerPersonne.getPersonByID(id);
    }


    @DELETE
    @Path("delete/{id}")
    public void deletePersonne(@PathParam("id") int id){
        controllerPersonne.removePersonne(id);
    }

    @PUT
    @Path("update/{id}")
    public void updatePersonne(@PathParam("id") int id){
        controllerPersonne.updatePersonne(id);
    }




}
