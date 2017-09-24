package is.hi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


public interface campSiteService {
    ArrayList getCampsites();

}