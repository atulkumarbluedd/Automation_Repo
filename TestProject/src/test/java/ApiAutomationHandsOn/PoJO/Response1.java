package ApiAutomationHandsOn.PoJO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response1 {
    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    @JsonProperty("data")
    private Data  data;
    @JsonProperty("support")
    private Support support;
}
