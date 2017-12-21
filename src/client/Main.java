/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.swing.JFrame;

/**
 *
 * @author gbojan
 */
public class Main {
    
    public static void main(String[] args) {
        // TODO code application logic here
       
        LogInForm login = new LogInForm();
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setLocationRelativeTo(null);
        login.show();
        
    }
}
