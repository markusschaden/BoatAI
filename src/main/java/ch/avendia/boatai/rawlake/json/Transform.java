
package ch.avendia.boatai.rawlake.json;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Transform {

    @Expose
    private List<Double> scale = new ArrayList<Double>();
    @Expose
    private List<Double> translate = new ArrayList<Double>();

    /**
     * 
     * @return
     *     The scale
     */
    public List<Double> getScale() {
        return scale;
    }

    /**
     * 
     * @param scale
     *     The scale
     */
    public void setScale(List<Double> scale) {
        this.scale = scale;
    }

    public Transform withScale(List<Double> scale) {
        this.scale = scale;
        return this;
    }

    /**
     * 
     * @return
     *     The translate
     */
    public List<Double> getTranslate() {
        return translate;
    }

    /**
     * 
     * @param translate
     *     The translate
     */
    public void setTranslate(List<Double> translate) {
        this.translate = translate;
    }

    public Transform withTranslate(List<Double> translate) {
        this.translate = translate;
        return this;
    }

}
