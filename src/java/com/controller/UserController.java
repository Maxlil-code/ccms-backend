package com.controller;

import com.model.ModelUser;
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
@Path("usercontroller")
public class UserController {

    @GET
    @Path("/ccmsuser")
    @Produces({"application/json"})
    public ArrayList<ModelUser> listuser() throws Exception {
        ArrayList<ModelUser> listu = new ArrayList<>();
        try {
            Statement etat = com.connexion.Connexion.seconnecter().createStatement();
            ResultSet rs = etat.executeQuery("select * from ccmsuser");
            while (rs.next()) {
                ModelUser oneuser = new ModelUser();
                oneuser.setIduser(rs.getInt("iduser"));
                oneuser.setName(rs.getString("name"));
                oneuser.setEmail(rs.getString("email"));               
                oneuser.setLogin(rs.getString("login"));
                oneuser.setPassword(rs.getString("password"));
                oneuser.setDob(rs.getTimestamp("dob"));
                oneuser.setCity(rs.getString("city"));
                oneuser.setCountry(rs.getString("country"));
                oneuser.setStatus(rs.getString("status"));
                

                listu.add(oneuser);
            }
            etat.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("error loading data :" + e.getMessage());
        }
        return listu;
    }
    
    @POST
    @Path("/ccmsuser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    public ModelUser createUser(ModelUser user){
        try {
            String sqlStatment= "Insert into ccmsuser (name,email,login,password,dob,city,country,status) "+ "values (?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = com.connexion.Connexion.seconnecter().prepareStatement(sqlStatment);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());         
            pstmt.setString(3, user.getLogin());
            pstmt.setString(4, user.getPassword());
            pstmt.setTimestamp(5, user.getDob());
            pstmt.setString(6, user.getCity());
            pstmt.setString(7, user.getCountry());
            pstmt.setString(8, user.getStatus());
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("error in querry" + e.getMessage());
        }
        return user;
    }
    
    @PUT
    @Path("/ccmsuser/{userid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    public ModelUser updateUser(@PathParam("userid") int userid, ModelUser user){
        try {
           String sqlStatment= "update ccmsuser set name=?,email=?,login=?,password=?,dob=?,city=?,country=?,status=? where iduser =" + userid;
            PreparedStatement pstmt = com.connexion.Connexion.seconnecter().prepareStatement(sqlStatment);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());         
            pstmt.setString(3, user.getLogin());
            pstmt.setString(4, user.getPassword());
            pstmt.setTimestamp(5, user.getDob());
            pstmt.setString(6, user.getCity());
            pstmt.setString(7, user.getCountry());
            pstmt.setString(8, user.getStatus());
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("error in querry" + e.getMessage());
        }
        return user;
    }
    
    @DELETE
    @Path("/ccmsuser/{userid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    public String deleteUser(@PathParam("userid") int userid){
        try {
            String sqlStatment= "delete from ccmsuser where iduser =" + userid;
             PreparedStatement pstmt = com.connexion.Connexion.seconnecter().prepareStatement(sqlStatment);
             pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("error in querry" + e.getMessage());
        }
        return "Deleted Successfully";
    }
    
    
    // Login / Authentication
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    public ModelUser loginUser (ModelUser user) throws Exception {
        ModelUser model = new ModelUser();
        try{
            String sql = "select * from ccmsuser";
            Statement st = com.connexion.Connexion.seconnecter().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                if(rs.getString("email").equals(user.getEmail()) && rs.getString("password").equals(user.getPassword())) {
                    model.setIduser(rs.getInt("iduser"));
                    model.setName(rs.getString("name"));
                    model.setEmail(rs.getString("email"));
                    model.setLogin(rs.getString("login"));
                    model.setCity(rs.getString("city"));
                    model.setCountry(rs.getString("country"));
                    model.setStatus(rs.getString("status"));
                }
            }
        }catch(Exception e){
            System.out.println("error in query" + e.getMessage());
        }
        
        return model;
    }
}
