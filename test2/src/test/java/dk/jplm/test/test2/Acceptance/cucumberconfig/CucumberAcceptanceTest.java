package dk.jplm.test.test2.Acceptance.cucumberconfig;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(
        key = Constants.GLUE_PROPERTY_NAME,
        value = "dk.jplm.test.test2.Acceptance," +
                "dk.jplm.test.test2.Acceptance.cucumberconfig"
)
@ConfigurationParameter(key = Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true")
public class CucumberAcceptanceTest {
}