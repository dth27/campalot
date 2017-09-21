package is.hi.service;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public interface campSiteService {

    public boolean isPwCorr(String nafn, String lykilorð);
}