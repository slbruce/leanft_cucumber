package com.microfocus.leanft;

import com.hpe.alm.octane.OctaneCucumber;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import com.hp.lft.sdk.*;
import com.hp.lft.verifications.*;

import unittesting.*;

@RunWith(OctaneCucumber.class)
@CucumberOptions(plugin={"junit:junitResult.xml","com.hp.lft.report.CucumberReporter"},
        features="src/main/java/com/microfocus/leanft")
//@RunWith(Cucumber.class)
//@CucumberOptions(plugin = {"com.hp.lft.report.CucumberReporter"},
//                 features = "src/main/java/com/microfocus/leanft")
public class LeanFtTest extends UnitTestClassBase {

    public LeanFtTest() {
        //Change this constructor to private if you supply your own public constructor
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        instance = new LeanFtTest();
        globalSetup(LeanFtTest.class);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }

    @Test
    public void test() throws GeneralLeanFtException {
    }

}