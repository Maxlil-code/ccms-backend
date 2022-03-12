/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.ModelPost;
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
@Path("postcontroller")
public class PostController {
    
    @GET
    @Path("/posts")
    @Produces({"application/json"})
    public ArrayList<ModelPost> listposts() throws Exception {
        ArrayList<ModelPost> posts = new ArrayList<>();
        try {
            Statement etat = com.connexion.Connexion.seconnecter().createStatement();
            ResultSet rs = etat.executeQuery("select * from post");
            while (rs.next()) {
                ModelPost singlepost = new ModelPost();
                singlepost.setIdpost(rs.getInt("idpost"));
                singlepost.setPostnumber(rs.getInt("postnumber"));
                singlepost.setDescription(rs.getString("description"));               
                singlepost.setIdcomputer(rs.getInt("idcomputer"));
                singlepost.setIduser(rs.getInt("iduser"));
                singlepost.setStatus(rs.getString("status"));
                

                posts.add(singlepost);
            }
            etat.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("error loading data :" + e.getMessage());
        }
        return posts;
    }
    
    @POST
    @Path("/addPost")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    public ModelPost addPost(ModelPost post){
        try {
            String sqlStatment= "Insert into post (iduser,idcomputer,postnumber,status,description) "+ "values (?,?,?,?,?)";
            PreparedStatement pstmt = com.connexion.Connexion.seconnecter().prepareStatement(sqlStatment);
            pstmt.setInt(1, post.getIduser());
            pstmt.setInt(2, post.getIdcomputer());
            pstmt.setInt(3, post.getPostnumber());
            pstmt.setString(4, post.getStatus());         
            pstmt.setString(5, post.getDescription());
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("error in query" + e.getMessage());
        }
        return post;
    }
    
    @PUT
    @Path("/post/{postid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    
    public ModelPost updatePost (@PathParam("postid") int postid, ModelPost post){
        try {
           String sqlStatment= "update post set iduser=?,idcomputer=?,postnumber=?,description=?,status=? where idpost =" + postid;
            PreparedStatement pstmt = com.connexion.Connexion.seconnecter().prepareStatement(sqlStatment);
            pstmt.setInt(1, post.getIduser());
            pstmt.setInt(2, post.getIdcomputer());
            pstmt.setInt(3, post.getPostnumber());
            pstmt.setString(4, post.getDescription());         
            pstmt.setString(5, post.getStatus());
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("error in querry" + e.getMessage());
        }
        return post;
    }
    
    @DELETE
    @Path("/post/{postid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    public String deleteUser(@PathParam("postid") int postid){
        try {
            String sqlStatment= "delete from ccmsuser where idpost =" + postid;
             PreparedStatement pstmt = com.connexion.Connexion.seconnecter().prepareStatement(sqlStatment);
             pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("error in querry" + e.getMessage());
        }
        return "Deleted Successfully";
    }
}
