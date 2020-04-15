package dao;

import entity.ParameterEntity;
import java.util.Collection;
import javax.ejb.Local;

@Local
public interface DbManagerLocal {
    void createParameter(ParameterEntity param);
    Collection<ParameterEntity> getAllParameters();
    Collection<ParameterEntity> getParameterByName(String name);
    Collection<ParameterEntity> getParametersByNameTemplate(String nameTemplate);
    Collection<ParameterEntity> getParametersByValInterval(int lowerBound, int upperBound);
}
