package bean;

import javax.ejb.Local;

@Local
public interface UpdateBeanLocal {
    boolean addParameter(String name, String value);
    boolean updateParameter(String name, String value);
    boolean deleteParameter(String name, String value);
}
