package RestAssuredHandsOn.PoJO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
    @JsonProperty("data")
    private Data[] data;
    @JsonProperty("support")
    private Support support;

    @JsonProperty("page")
    private int page;
    @JsonProperty("per_page")
    private int per_page;
    @JsonProperty("total_pages")
    private int total_pages;
    @JsonProperty("total")
    private int total;

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


}
