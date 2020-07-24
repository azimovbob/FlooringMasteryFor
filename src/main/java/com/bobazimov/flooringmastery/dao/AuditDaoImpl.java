/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class AuditDaoImpl implements AuditDao {
    
    public final static String  AUDIT_TXT = "orderaudit.txt";
             
    @Override
    public void writeAuditEntry(String message) throws OrderPersistenceException {
        PrintWriter out;
        try{
            out = new PrintWriter(new FileWriter(AUDIT_TXT, true));
        }catch(IOException ex){
            throw new OrderPersistenceException("Could not write to file");
        }

        LocalDateTime timeStamp = LocalDateTime.now();
           String timeStampStr = timeStamp.format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss"));
           out.println(timeStampStr + " " + message);
           out.flush();
           out.close();
            
    }
    
}
