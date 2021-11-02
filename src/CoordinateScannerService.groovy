class CoordinateScannerService {

    private boolean isDigit(String s) throws NumberFormatException {
        try {
            if (s.contains(".")) {
                double num = Double.parseDouble(s);
                return true
            }
        } catch (NumberFormatException e) {
            println(e.getMessage())
            return false
        }
    }

    public String[] getCoordinates() {
        Scanner sc = new Scanner(System.in)
        String longitude
        String latitude
        String[] coordinatesAndSection = new String[3];

        do {
            println("input longitude (double)")
            longitude = sc.nextLine()
            println "input latitude (double)"
            latitude = sc.nextLine()


        } while (!isDigit(longitude) || !isDigit(latitude))
        coordinatesAndSection[0] = longitude
        coordinatesAndSection[1] = latitude
        println "input section (One of food, drinks, coffee, shops, arts, outdoors, sights, trending)"
        coordinatesAndSection[2] = sc.nextLine()
        sc.close()
        return coordinatesAndSection

    }
}
