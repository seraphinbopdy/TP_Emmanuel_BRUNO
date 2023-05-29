package FichierSerialisationJson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import Entites.Chenil;
import Entites.Chien;
import Entites.Pathologie;
import Entites.Personne;
import lombok.extern.java.Log;

import java.util.List;

@Log
public class ConvertToJson {


    public String serialiserChien(List<Chien> listeChien){
        String objectToString = null;
        ObjectMapper objectMapper = new ObjectMapper()
                .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
                .enable(SerializationFeature.INDENT_OUTPUT)
                .findAndRegisterModules();
        try {
            objectToString = objectMapper.writeValueAsString(listeChien);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return objectToString;
    }
    public String serialiserChienById(Chien chien){
        String objectToString = null;
        ObjectMapper objectMapper = new ObjectMapper()
                .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
                .enable(SerializationFeature.INDENT_OUTPUT)
                .findAndRegisterModules();
        try {
            objectToString = objectMapper.writeValueAsString(chien);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return objectToString;
    }


    public  String SerialiserPathologieById(Pathologie pathologie){
        String objectToString = null;
        ObjectMapper objectMapper = new ObjectMapper()
                .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
                .enable(SerializationFeature.INDENT_OUTPUT)
                .findAndRegisterModules();
        try {
            objectToString = objectMapper.writeValueAsString(pathologie);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return objectToString;
    }


    public String SerialiserPathologieList(List<Pathologie> listPatho){
        String objectToString = null;
        ObjectMapper objectMapper = new ObjectMapper()
                .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
                .enable(SerializationFeature.INDENT_OUTPUT)
                .findAndRegisterModules();
        try {
            objectToString = objectMapper.writeValueAsString(listPatho);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return objectToString;
    }




    public  String SerialiserPersonneById(Personne personne){
        String objectString = null;
        ObjectMapper objectMapper = new ObjectMapper()
                .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
                .enable(SerializationFeature.INDENT_OUTPUT)
                .findAndRegisterModules();
        try {
            objectString = objectMapper.writeValueAsString(personne);
            System.err.println("Insertion des personnes  avec success!!");
            System.err.println(objectMapper.writeValueAsString("SUCCESS!!"));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.err.println("Insertion des personnes échoués !!");
        }
        return  objectString;
    }

    public String SerialiserPersonneList(List<Personne> listPersonne){
        String objectString = null;
        ObjectMapper objectMapper = new ObjectMapper()
                .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
                .enable(SerializationFeature.INDENT_OUTPUT)
                .findAndRegisterModules();
        try {
            objectString = objectMapper.writeValueAsString(listPersonne);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return objectString;
    }


    public String SerialiserChenilList(List<Chenil> listChenil){
        String objectString = null;
        ObjectMapper objectMapper = new ObjectMapper()
                .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
                .enable(SerializationFeature.INDENT_OUTPUT)
                .findAndRegisterModules();
        try {
            objectString = objectMapper.writeValueAsString(listChenil);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return objectString;
    }


    public  String SerialiserChenilById(Chenil chenil){
        String objectString = null;
        ObjectMapper objectMapper = new ObjectMapper()
                .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
                .enable(SerializationFeature.INDENT_OUTPUT)
                .findAndRegisterModules();
        try {
            objectString = objectMapper.writeValueAsString(chenil);
            System.err.println("Insertion des chenil  avec success!!");
            System.err.println(objectMapper.writeValueAsString("SUCCESS!!"));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.err.println("Insertion des chenil échoués !!");
        }
        return  objectString;
    }





}
