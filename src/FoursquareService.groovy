import com.fasterxml.jackson.databind.JsonNode

class FoursquareService {
    private final CoordinateScannerService coordinateScannerService


    private final VenueService venueService
    public FoursquareService() {
        coordinateScannerService = new CoordinateScannerService()

        venueService = new VenueService()
    }

    public void run() {


        String[] coordinates = coordinateScannerService.getCoordinates()


        venueService.find_nearest_venue(coordinates)

    }
}
//51.51453310076461, -0.1264620142104317