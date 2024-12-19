package RestAssuredMultiplePayloadExample.RestFulAPIObject.PartialUpdate;

import RestAssuredMultiplePayloadExample.RestFulAPIObject.UpdateObject.UpdateDataClas;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NameUpdateClass
{
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("data")
    @Expose
    private PartialDataClas data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PartialDataClas getData() {
        return data;
    }

    public void setData(PartialDataClas data) {
        this.data = data;
    }
}
