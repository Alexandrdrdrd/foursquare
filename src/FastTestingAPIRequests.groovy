import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper

//static JsonNode request_foursquareAPI() {
//    def json_request = new URL("https://api.foursquare.com/v2/venues/explore?ll=51.51445293541919,-0.12672058870931455&&radius=100&openNow=1&sortByDistance=1&section=food&client_id=S1RRXELVBKHDP20EPG1YHNXVZ1UBMAKZ5RGU4J05GHLAMYNL&client_secret=O3BALPN4VBE1ILHBGSVEP3XCPBDBC1LMHIMUJHHXIJXRUMIZ&v=20190425")
////    return new ObjectMapper().readTree(json_request)}
////a=request_foursquareAPI()
////println(a.get("response").get("groups").get(0).get("items"))
////"https://api.foursquare.com/v2/venues/explore?ll=51.51445293541919,-0.12672058870931455&&radius=100&openNow=1&sortByDistance=1&section=food&client_id=S1RRXELVBKHDP20EPG1YHNXVZ1UBMAKZ5RGU4J05GHLAMYNL&client_secret=O3BALPN4VBE1ILHBGSVEP3XCPBDBC1LMHIMUJHHXIJXRUMIZ&v=20190425")
URL url = new URL("https://api.foursquare.com/v2/checkins/add?client_id=S1RRXELVBKHDP20EPG1YHNXVZ1UBMAKZ5RGU4J05GHLAMYNL&client_secret=O3BALPN4VBE1ILHBGSVEP3XCPBDBC1LMHIMUJHHXIJXRUMIZ&v=20190425&ll=1.2787325314969156,103.843473196638d");
URLConnection con = url.openConnection();
HttpURLConnection http = (HttpURLConnection)con;
http.setRequestMethod("POST"); // PUT is another valid option
http.setDoOutput(true);