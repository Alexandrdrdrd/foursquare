import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper

class FoursquareAPIhttpClient {
    private final ApplicationProperties applicationProperties
    private static final FOURSQUARE_URL_SORT_BY_DISTANCE = 'https://api.foursquare.com/v2/venues/explore?ll=%s,%s&&radius=300&openNow=1&sortByDistance=1&section=%s&client_id=%s&client_secret=%s&v=20190425'
    private static final FOURSQUARE_URL_SORT_BY_POP = 'https://api.foursquare.com/v2/venues/explore?ll=%s,%s&&radius=%d&openNow=1&sortByPopularity=1&limit=1&client_id=%s&client_secret=%s&v=20190425'

    public FoursquareAPIhttpClient() {
        applicationProperties = new ApplicationProperties()
    }


    public JsonNode findVenuesByDistance(String[] coordinatesAndSection) {
        def properties = applicationProperties.getParams()
        def json_request = new URL(String.format(FOURSQUARE_URL_SORT_BY_DISTANCE
                , coordinatesAndSection[0], coordinatesAndSection[1],coordinatesAndSection[2],
                properties.Client_Id
                , properties.client_secret))
        return new ObjectMapper().readTree(json_request);
    }

    public JsonNode findVenuesByPopularity(String[] coordinates, Integer radius) {
        def properties = applicationProperties.getParams()
        def json_request = new URL(String.format(FOURSQUARE_URL_SORT_BY_POP
                , coordinates[0], coordinates[1],radius, properties.Client_Id
                , properties.client_secret))
        return new ObjectMapper().readTree(json_request);
    }

}
