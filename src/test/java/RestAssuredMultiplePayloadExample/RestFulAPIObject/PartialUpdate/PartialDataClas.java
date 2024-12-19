package RestAssuredMultiplePayloadExample.RestFulAPIObject.PartialUpdate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PartialDataClas
{
    @SerializedName("year")
    @Expose
    private Integer year;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("CPUmodel")
    @Expose
    private String cPUmodel;
    @SerializedName("Harddisksize")
    @Expose
    private String harddisksize;
    @SerializedName("color")
    @Expose
    private String color;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCPUmodel() {
        return cPUmodel;
    }

    public void setCPUmodel(String cPUmodel) {
        this.cPUmodel = cPUmodel;
    }

    public String getHarddisksize() {
        return harddisksize;
    }

    public void setHarddisksize(String harddisksize) {
        this.harddisksize = harddisksize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
