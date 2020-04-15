package data;

import java.util.ArrayList;
import java.util.Collection;

public class Attribute {
    private static Collection<Parameter> params;

    public Attribute(Collection<Parameter> params) {
        this.params = params;
    }

    public Attribute() {
    }

    /**
     * Provides 2.2.2.1
     * @return 
     */
    public static Collection<Parameter> getParams() {
        return params;
    }
    
    public static void setParam(Parameter param) {
        if (params == null) {
            params = new ArrayList<>();
        }
        params.add(param);
    }

    public static void setParams(Collection<Parameter> paramsList) {
        params = paramsList;
    }
    
    /**
     * Provides 2.2.2.2
     * @param name
     * @return 
     */
    public static Collection<Parameter> getParamsListByName(String name) {
        Collection<Parameter> list = new ArrayList<>();
        for (Parameter param : params) {
            if (param.getName().matches(name)) {
                list.add(param);
            }
        }
        return list;
    }
    
    /**
     * Provides 2.2.2.3
     * @param lowerBound
     * @param upperBound
     * @return 
     */
    public static Collection<Parameter> getParamsListByVal(int lowerBound, 
                                                    int upperBound) {
        Collection<Parameter> list = new ArrayList<>();
        for (Parameter param : params) {
            if (param.getValue() <= upperBound && param.getValue() >= lowerBound) {
                list.add(param);
            }
        }
        return list;
    }    
    

    
}
