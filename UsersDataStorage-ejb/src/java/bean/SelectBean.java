package bean;

import dao.DbManagerLocal;
import entity.ParameterEntity;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class SelectBean implements SelectBeanLocal {

    @EJB
    private DbManagerLocal dbManager;

    @Override
    public String selectAll() {
        Collection<ParameterEntity> list = new ArrayList<>();
        System.out.println("SelectBean.selectAll() started");
        list = dbManager.getAllParameters();
        if (list.isEmpty()) {
            return "Searching result is empty";
        }
        StringBuilder sb = new StringBuilder();
        for (ParameterEntity param : list) {
            sb.append(this.convertToListItem(param));
        }
        return sb.toString();
    }

    @Override
    public String selectByNameTemplate(String nameTemplate) {
        Collection<ParameterEntity> list = new ArrayList<>();
        // TODO: add logic here
        System.out.println("SelectBean.selectByNameTemplate() started");
        list = dbManager.getParametersByNameTemplate(nameTemplate);
        if (list.isEmpty()) {
            return "Searching result is empty";
        }
        StringBuilder sb = new StringBuilder();
        for (ParameterEntity param : list) {
            sb.append(this.convertToListItem(param));
        }
        return sb.toString();
    }

    @Override
    public String selectByValInterval(int lowerBound, int upperBound) {
        Collection<ParameterEntity> list = new ArrayList<>();
        // TODO: add logic here
        System.out.println("SelectBean.selectByValInterval() started");
        list = dbManager.getParametersByValInterval(lowerBound, upperBound);
        if (list.isEmpty()) {
            return "Searching result is empty";
        }
        StringBuilder sb = new StringBuilder();
        for (ParameterEntity param : list) {
            sb.append(this.convertToListItem(param));
        }
        return sb.toString();
    }
    
    public String convertToListItem(ParameterEntity param) {
        return "<li>" + param.getName() + " - " + param.getValue() + "</li>";
    }

}
