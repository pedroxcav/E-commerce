package com.Eletronics.model;

import com.Eletronics.repository.AdministratorDAO;
import com.Eletronics.services.AdministratorServices;
import com.Eletronics.services.exceptions.Exception_Data;
import com.Eletronics.services.tools.Warning;
import java.sql.SQLException;

public class Administrator extends User {
    
    public Administrator(String name, String userId, String CPF, String password) {
        super(name, userId, CPF, password);
    }
    public Administrator(){
        super();
    }
    
    @Override
    public void registerUser(User administrator) {
        try {
            if (!(AdministratorServices.verifyUser(administrator)))
                AdministratorDAO.register(administrator);
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
            return AdministratorDAO.LogInto(userId, password);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro ao entrar.");
            warning.setVisible(true);
            return false;
        }
    }
}
