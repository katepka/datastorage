package bean;

import javax.ejb.Local;

@Local
public interface SelectBeanLocal {
    String selectAll();
    String selectByNameTemplate(String nameTemplate);
    String selectByValInterval(int lowerBound, int upperBound);
}
