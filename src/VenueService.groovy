import com.fasterxml.jackson.databind.JsonNode

class VenueService {
    private final FoursquareAPIhttpClient foursquareAPIhttpClient

    public VenueService() {
        foursquareAPIhttpClient = new FoursquareAPIhttpClient()
    }

    public void find_nearest_venue(String[] coordinatesAndSection) throws IOException {
        try{
            JsonNode json_result = foursquareAPIhttpClient.findVenuesByDistance(coordinatesAndSection)
            if (json_result.get("response").get("groups").get(0).get("items").size() == 0) {
                println("There is no venues on current coordinates")
                return
            }
            int min_distance = json_result.get("response").get("groups").get(0).get("items").get(0).get("venue").get("location").get("distance").asInt()
            def result_list = []

            for (int i = 0; i<json_result.get("response").get("groups").get(0).get("items").size();i++){
                Map<String, Integer> result_map = new HashMap<>()
                result_map.put(json_result.get("response").get("groups").get(0).get("items").get(i).get("venue").get("name").asText()
                        , json_result.get("response").get("groups").get(0).get("items").get(i).get("venue").get("location").get("distance").asInt())
                result_list.add(result_map)}
            print_result(min_distance, result_list)
        }catch (IOException e){
            println(e.getMessage())
            println("Pleas, try again")
        }

        }





    private void print_result(int min_distance, List result_list) {
        if (min_distance > 50) {
            println("places not found")
        } else {

            println(result_list[0])
        }
    }
}
//51.51453310076461, -0.1264620142104317