
package com.spotonresponse.nagios.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class GeoJson {

    @Expose
    private String type;
    @Expose
    private Metadata metadata;
    @Expose
    private List<Feature> features = new ArrayList<Feature>();

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

    public GeoJson withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * 
     * @return
     *     The metadata
     */
    public Metadata getMetadata() {
        return metadata;
    }

    /**
     * 
     * @param metadata
     *     The metadata
     */
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public GeoJson withMetadata(Metadata metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * 
     * @return
     *     The features
     */
    public List<Feature> getFeatures() {
        return features;
    }

    /**
     * 
     * @param features
     *     The features
     */
    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public GeoJson withFeatures(List<Feature> features) {
        this.features = features;
        return this;
    }

}
