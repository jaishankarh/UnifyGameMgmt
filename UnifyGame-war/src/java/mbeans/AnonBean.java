/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mbeans;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author jaishankar
 */
@ManagedBean
@RequestScoped
public class AnonBean {
    private List<String> images = new ArrayList<>();  

    public AnonBean() {
        images.add("1.JPG");
        images.add("2.JPG");
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
    
    @PostConstruct
    public void setImages()
    {
        int noImages=16;
        for(Integer i=1; i<noImages+1; i++)
        {
            images.add(i.toString()+".JPG");
        }
    }
}
