package org.motechproject.telco;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;

import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuartzLauncher {

    Logger log = Logger.getLogger(QuartzLauncher.class.getName());

    Job quartzJob;
    private SimpleJobLauncher simpleJobLauncher;

    public QuartzLauncher(Job quartzJob, SimpleJobLauncher simpleJobLauncher) {
        this.quartzJob = quartzJob;
        this.simpleJobLauncher = simpleJobLauncher;
    }

    public void run() {
        log.entering(this.getClass().getName(), "run");
        final HashMap<String, JobParameter> parameters = new HashMap<String, JobParameter>();
        parameters.put("id", new JobParameter("" + new Random().nextLong()));
        JobParameters jobParameters = new JobParameters(parameters);
        try {
            simpleJobLauncher.run(quartzJob, jobParameters);
        } catch (Exception e) {
            log.log(Level.WARNING, e.getMessage(), e);
        }
        log.exiting(this.getClass().getName(), "run");
    }
}
