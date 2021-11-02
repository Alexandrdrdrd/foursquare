import groovy.json.JsonSlurper

class ApplicationProperties {
    private static final PATH_PARAMS = 'C:/Users/1/IdeaProjects/test_week/src/params.json'

    public Object getParams() {

        def jsonSlurper = new JsonSlurper()
        File fl = new File(PATH_PARAMS)
        return jsonSlurper.parse(fl)

    }
}
