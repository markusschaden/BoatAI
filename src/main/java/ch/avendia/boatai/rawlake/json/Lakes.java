
package ch.avendia.boatai.rawlake.json;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Lakes {

    @Expose
    private String type;
    @Expose
    private List<Geometry> geometries = new ArrayList<Geometry>();

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    public Lakes withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * 
     * @return
     *     The geometries
     */
    public List<Geometry> getGeometries() {
        return geometries;
    }

    /**
     * 
     * @param geometries
     *     The geometries
     */
    public void setGeometries(List<Geometry> geometries) {
        this.geometries = geometries;
    }

    public Lakes withGeometries(List<Geometry> geometries) {
        this.geometries = geometries;
        return this;
    }

}
