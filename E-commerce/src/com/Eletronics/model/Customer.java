package com.Eletronics.model;

import com.Eletronics.repository.CustomerDAO;
import com.Eletronics.services.CustomerServices;
import com.Eletronics.services.exceptions.Exception_Data;
import com.Eletronics.services.tools.Warning;
import java.sql.SQLException;

public class Customer extends User {
    private String telephone;
    private String address;

    
    public Customer(String name, String userId, String CPF, String password, String telephone, String address){
        super(name, userId, CPF, password);
        this.telephone = telephone;
        this.address = address;
    }
    public Customer(String name, String userId, String CPF, String password) {
        super(name, userId, CPF, password);
    }
    public Customer(){
        super();
    }
    
    @Override
    public void registerUser(User customer) {
        try {
            if (!(CustomerServices.verifyUser(customer)))
                CustomerDAO.register(customer);
        } catch (Exception_Data e) {
            Warning warning = new Warning(e.getMessage());
            warning.setVisible(true);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro ao cadastrar.");
            warning.setVisible(true);
        }
    }
    
    @Override
    public boolean logInto(String userId, String password) {
        try {
            return CustomerDAO.logInto(userId, password);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro ao entrar.");
            warning.setVisible(true);
            return false;
        }
    }

    public String getTelephone() {
        return telephone;
    }
    public String getAddress() {
        return address;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
