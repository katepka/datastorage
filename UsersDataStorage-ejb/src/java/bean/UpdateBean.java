package bean;

import dao.DbManagerLocal;
import entity.ParameterEntity;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import util.IncorrectParamFormatException;

@Stateless
public class UpdateBean implements UpdateBeanLocal {

    @EJB
    private DbManagerLocal dbManager;  

    @Override
    public boolean addParameter(String name, String value) {
        ParameterEntity param = new ParameterEntity();
        try {
            param = this.validate(name, value);
        } catch (IncorrectParamFormatException ex) {
            Logger.getLogger(UpdateBean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        System.out.println("UpdateBean.addParameter() started");
        dbManager.createParameter(param);
        return true;
    }

    @Override
    public boolean updateParameter(String name, String value) {
        try {
            this.validate(name, value);
        } catch (IncorrectParamFormatException ex) {
            Logger.getLogger(UpdateBean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        // TODO: Logic here
        System.out.println("UpdateBean.updateParameter() started");
        return true;
    }

    @Override
    public boolean deleteParameter(String name, String value) {
        try {
            this.validate(name, value);
        } catch (IncorrectParamFormatException ex) {
            Logger.getLogger(UpdateBean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        // TODO: Logic here
        System.out.println("UpdateBean.deleteParameter() started");
        return true;
    }
    
    private ParameterEntity validate(String name, String value) 
                                    throws IncorrectParamFormatException {
        ParameterEntity validParam = new ParameterEntity();
        String n = name.trim();
        int val;
        if (n != null && !n.isEmpty() && n.length() < 256) {
            validParam.setName(n);
        } else {
            throw new IncorrectParamFormatException("Incorrect param's name format");
        }
        try {
            val = Integer.parseInt(value);
            validParam.setValue(val);
        } catch (NumberFormatException nfe) {
            throw new IncorrectParamFormatException("Incorrect value format");
        }
        return validParam;
    }

}
