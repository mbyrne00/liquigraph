package org.liquigraph.maven;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.liquigraph.core.configuration.ConfigurationBuilder;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Simulates Liquigraph execution and persists results in ${project.build.directory}/output.cypher.
 */
@Mojo(name = "dry-run", defaultPhase = LifecyclePhase.PREPARE_PACKAGE, threadSafe = true)
public class DryRunMojo extends LiquigraphMojoBase {

    @Override
    protected ConfigurationBuilder withExecutionMode(ConfigurationBuilder configurationBuilder) {
        Path outputDirectory = Paths.get(project.getBuild().getDirectory());
        return configurationBuilder.withDryRunMode(outputDirectory);
    }
}
