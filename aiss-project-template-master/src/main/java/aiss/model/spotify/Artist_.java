
package aiss.model.spotify;

import java.util.HashMap;
import java.util.Map;

public class Artist_ {

    private ExternalUrls___ externalUrls;
    private String href;
    private String id;
    private String name;
    private String type;
    private String uri;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public ExternalUrls___ getExternalUrls() {
        return externalUrls;
    }

    public void setExternalUrls(ExternalUrls___ externalUrls) {
        this.externalUrls = externalUrls;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
