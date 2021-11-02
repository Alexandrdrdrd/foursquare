import com.fasterxml.jackson.databind.JsonNode

class VenueService {
    private final FoursquareAPIhttpClient foursquareAPIhttpClient

    public VenueService() {
        foursquareAPIhttpClient = new FoursquareAPIhttpClient()
    }

    public void find_nearest_venue(String[] coordinatesAndSection) {
        JsonNode json_result = foursquareAPIhttpClient.findVenuesByDistance(coordinatesAndSection)
        if (json_result.get("response").get("groups").get(0).get("items").size() == 0) {
            println("There is no venues on current coordinates")
            return
        }
        int min_distance = json_result.get("response").get("groups").get(0).get("items").get(0).get("venue").get("location").get("distance").asInt()

        Map<String, Integer> result_map = new HashMap<>()
        for (int i = 0; i < json_result.get("response").get("groups").get(0).get("items").size(); i++) {

            if (min_distance == json_result.get("response").get("groups").get(0).get("items").get(i + 1).get("venue").get("location").get("distance").asInt()) {

                json_result = foursquareAPIhttpClient.findVenuesByPopularity(coordinatesAndSection, min_distance)
                result_map.put(json_result.get("response").get("groups").get(0).get("items").get(i).get("venue").get("name").asText()
                        , json_result.get("response").get("groups").get(0).get("items").get(i).get("venue").get("location").get("distance").asInt())
                break

            } else {

                result_map.put(json_result.get("response").get("groups").get(0).get("items").get(i).get("venue").get("name").asText()
                        , json_result.get("response").get("groups").get(0).get("items").get(i).get("venue").get("location").get("distance").asInt())

                break
            }
        }

        print_result(min_distance, result_map)

    }

    private void print_result(int min_distance, Map<String, Integer> result_map) {
        if (min_distance > 50) {
            println("places not found")
        } else {

            println(result_map.keySet())
        }
    }
}
