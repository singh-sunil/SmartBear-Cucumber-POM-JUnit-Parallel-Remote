package com.smartbear.parallel;

import io.cucumber.java.Scenario;

public class ScenarioFactory {

    public static String getFeatureFileNameFromScenarioId(Scenario scenario) {
        String featureName = "Feature ";
        String rawFeatureName = scenario.getId().split(";")[0].replace("-"," ");
        featureName = featureName + rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);

        return featureName;
    }
}
