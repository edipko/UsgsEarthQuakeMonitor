
package com.spotonresponse.nagios.beans;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Metadata {

    @Expose
    private String generated;
    @Expose
    private String url;
    @Expose
    private String title;
    @Expose
    private Integer status;
    @Expose
    private String api;
    @Expose
    private Integer count;

    /**
     * 
     * @return
     *     The generated
     */
    public String getGenerated() {
        return generated;
    }

    /**
     * 
     * @param generated
     *     The generated
     */
    public void setGenerated(String generated) {
        this.generated = generated;
    }

    public Metadata withGenerated(String generated) {
        this.generated = generated;
        return this;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    public Metadata withUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public Metadata withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * 
     * @return
     *     The status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    public Metadata withStatus(Integer status) {
        this.status = status;
        return this;
    }

    /**
     * 
     * @return
     *     The api
     */
    public String getApi() {
        return api;
    }

    /**
     * 
     * @param api
     *     The api
     */
    public void setApi(String api) {
        this.api = api;
    }

    public Metadata withApi(String api) {
        this.api = api;
        return this;
    }

    /**
     * 
     * @return
     *     The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 
     * @param count
     *     The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    public Metadata withCount(Integer count) {
        this.count = count;
        return this;
    }

}
