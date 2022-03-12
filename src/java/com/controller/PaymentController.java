/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.ModelPayment;
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
@Path("paymentcontroller")
public class PaymentController {
    
    @POST
    @Path("/payment")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    public ModelPayment createUser(ModelPayment payment){
        try {
            String sqlStatment= "Insert into payment (iduser,name,description,transaction) "+ "values (?,?,?,?)";
            PreparedStatement pstmt = com.connexion.Connexion.seconnecter().prepareStatement(sqlStatment);
            pstmt.setInt(1, payment.getIduser());
            pstmt.setString(2, payment.getName());         
            pstmt.setString(3, payment.getDescription());
            pstmt.setString(4, payment.getTransactionname());
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("error in querry" + e.getMessage());
        }
        return payment;
    }
    
    
}
