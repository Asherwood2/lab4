import java.util.List;

class row_Object {
    private String data_Type;
    private String country;
    private String country_code;
    private List<Double> gdp_Values;

    public row_Object(String data_Type, String country, String country_code, List<Double> gdp_Values) {
        this.data_Type = data_Type;
        this.country = country;
        this.country_code = country_code;
        this.gdp_Values = gdp_Values;
    }
}
