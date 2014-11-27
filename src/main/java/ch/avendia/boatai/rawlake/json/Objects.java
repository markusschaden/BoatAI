
package ch.avendia.boatai.rawlake.json;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Objects {

    @Expose
    private Lakes lakes;

    /**
     * 
     * @return
     *     The lakes
     */
    public Lakes getLakes() {
        return lakes;
    }

    /**
     * 
     * @param lakes
     *     The lakes
     */
    public void setLakes(Lakes lakes) {
        this.lakes = lakes;
    }

    public Objects withLakes(Lakes lakes) {
        this.lakes = lakes;
        return this;
    }

}
