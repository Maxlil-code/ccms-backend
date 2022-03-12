/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.ModelComputer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Max
 */
@Path("computercontroller")
public class ComputerController {
    
    @GET
    @Path("/computerlist")
    @Produces({"application/json"})
    public ArrayList<ModelComputer> listcomputer() throws Exception {
        ArrayList<ModelComputer> computers = new ArrayList<>();
        try {
            Statement etat = com.connexion.Connexion.seconnecter().createStatement();
            ResultSet rs = etat.executeQuery("select * from computer");
            while (rs.next()) {
                ModelComputer singlecomputer = new ModelComputer();
                singlecomputer.setIdcomputer(rs.getInt("idcomputer"));
                singlecomputer.setName(rs.getString("name"));
                singlecomputer.setDescription(rs.getString("description"));               
                singlecomputer.setCreationdate(rs.getTimestamp("creationdate"));
                singlecomputer.setStatus(rs.getString("status"));
                

                computers.add(singlecomputer);
            }
            etat.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("error loading data :" + e.getMessage());
        }
        return computers;
    }
    
    @POST
    @Path("/addComputer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    public ModelComputer addComputer(ModelComputer computer){
        try {
            String sqlStatment= "Insert into computer (name,description,creationdate,status) "+ "values (?,?,?,?)";
            PreparedStatement pstmt = com.connexion.Connexion.seconnecter().prepareStatement(sqlStatment);
            pstmt.setString(1, computer.getName());
            pstmt.setString(2, computer.getDescription());         
            pstmt.setTimestamp(3, computer.getCreationdate());
            pstmt.setString(4, computer.getStatus());
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("error in query" + e.getMessage());
        }
        return computer;
    }
    
    @PUT
    @Path("/computer/{computerid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    public ModelComputer updateComputer(@PathParam("computerid") int computerid, ModelComputer computer){
        try {
           String sqlStatment= "update computer set name=?,description=?,status=?,creationdate=? where idcomputer =" + computerid;
            PreparedStatement pstmt = com.connexion.Connexion.seconnecter().prepareStatement(sqlStatment);
            pstmt.setString(1, computer.getName());
            pstmt.setString(2, computer.getDescription());         
            pstmt.setString(3, computer.getStatus());;
            pstmt.setTimestamp(4, computer.getCreationdate());
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("error in querry" + e.getMessage());
        }
        return computer;
    }
    
    @DELETE
    @Path("/computer/{computerid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    public String deleteComputer(@PathParam("computerid") int computerid){
        try {
            String sqlStatment= "delete from computer where idcomputer =" + computerid;
             PreparedStatement pstmt = com.connexion.Connexion.seconnecter().prepareStatement(sqlStatment);
             pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("error in querry" + e.getMessage());
        }
        return "Deleted Successfully";
    }
}
