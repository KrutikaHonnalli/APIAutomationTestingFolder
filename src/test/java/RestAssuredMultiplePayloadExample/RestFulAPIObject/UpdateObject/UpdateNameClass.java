package RestAssuredMultiplePayloadExample.RestFulAPIObject.UpdateObject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateNameClass
{
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("data")
    @Expose
    private UpdateDataClas data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UpdateDataClas getData() {
        return data;
    }

    public void setData(UpdateDataClas data) {
        this.data = data;
    }


}
