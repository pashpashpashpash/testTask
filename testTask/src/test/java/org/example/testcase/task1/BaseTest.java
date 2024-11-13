package org.example.testcase.task1;

import com.beust.ah.A;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.steps.ApiSteps;
import org.example.util.PropertiesUtil;

public class BaseTest {


    protected ApiSteps apiSteps = new ApiSteps();
    protected static final Logger LOGGER = LogManager.getLogger();
    protected PropertiesUtil propertiesUtil = new PropertiesUtil();

}
