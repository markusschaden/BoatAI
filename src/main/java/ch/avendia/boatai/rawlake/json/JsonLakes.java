
package ch.avendia.boatai.rawlake.json;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class JsonLakes {

    @Expose
    private String type;
    @Expose
    private Objects objects;
    @Expose
    private List<List<List<Integer>>> arcs = new ArrayList<List<List<Integer>>>();
    @Expose
    private Transform transform;

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

    public JsonLakes withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * 
     * @return
     *     The objects
     */
    public Objects getObjects() {
        return objects;
    }

    /**
     * 
     * @param objects
     *     The objects
     */
    public void setObjects(Objects objects) {
        this.objects = objects;
    }

    public JsonLakes withObjects(Objects objects) {
        this.objects = objects;
        return this;
    }

    /**
     * 
     * @return
     *     The arcs
     */
    public List<List<List<Integer>>> getArcs() {
        return arcs;
    }

    /**
     * 
     * @param arcs
     *     The arcs
     */
    public void setArcs(List<List<List<Integer>>> arcs) {
        this.arcs = arcs;
    }

    public JsonLakes withArcs(List<List<List<Integer>>> arcs) {
        this.arcs = arcs;
        return this;
    }

    /**
     * 
     * @return
     *     The transform
     */
    public Transform getTransform() {
        return transform;
    }

    /**
     * 
     * @param transform
     *     The transform
     */
    public void setTransform(Transform transform) {
        this.transform = transform;
    }

    public JsonLakes withTransform(Transform transform) {
        this.transform = transform;
        return this;
    }

}
