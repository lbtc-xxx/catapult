package org.rhd.katapult.openshift.impl;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.rhd.katapult.openshift.api.OpenShiftProject;
import org.rhd.katapult.openshift.api.OpenShiftService;
import org.rhd.katapult.openshift.api.OpenShiftServiceFactory;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author <a href="mailto:alr@redhat.com">Andrew Lee Rubinger</a>
 */
public class OpenShiftClientTest {

    private static final Logger log = Logger.getLogger(OpenShiftClientTest.class.getName());

    private static final String URL_OPENSHIFT = "https://localhost:8443";
    private static final String PREFIX_NAME_PROJECT = "test-project-";

    private static OpenShiftService service;

    @BeforeClass
    public static void createService() {
        service = OpenShiftServiceFactory.INSTANCE.create(URL_OPENSHIFT);
    }

    @Test
    public void createProject() {
        final String projectName = PREFIX_NAME_PROJECT + System.currentTimeMillis();
        final OpenShiftProject project = service.createProject(projectName);
        final String displayName = project.getName();
        Assert.assertEquals("returned project did not have expected name", projectName, displayName);
        log.log(Level.INFO, "Created project: \'" + displayName + "\'");
    }

}
