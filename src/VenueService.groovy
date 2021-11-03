import com.fasterxml.jackson.databind.JsonNode

class VenueService {
    private final FoursquareAPIhttpClient foursquareAPIhttpClient

    public VenueService() {
        foursquareAPIhttpClient = new FoursquareAPIhttpClient()
    }

    public void find_nearest_venue(String[] coordinatesAndSection)  {
        try {
            JsonNode json_result = foursquareAPIhttpClient.findVenuesByDistance(coordinatesAndSection)

            JsonNode item = json_result.get("response").get("groups").get(0).get("items")
            if (item.size() == 0) {
                println("There is no venues on current coordinates")
                return
            }
            int min_distance = item.get(0).get("venue").get("location").get("distance").asInt()
            def result_list = []

            for (int i = 0; i < item.size(); i++) {
                Map<String, Integer> result_map = new HashMap<>()
                result_map.put(item.get(i).get("venue").get("name").asText()
                        , item.get(i).get("venue").get("location").get("distance").asInt())
                result_list.add(result_map)
            }

            print_result(min_distance, result_list)

        } catch (IOException e) {
            println(e.getMessage())
            println("Pleas, try again")
        }

    }


    private void print_result(int min_distance, List result_list) {
        if (min_distance > 50) {
            println("places not found")
        } else {
            print("Your place is ")
            println(result_list.get(0).keySet())
        }
    }
}
