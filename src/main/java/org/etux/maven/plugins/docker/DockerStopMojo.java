package org.etux.maven.plugins.docker;

import com.kpelykh.docker.client.DockerException;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * Enables maven to stop the current Docker container.
 * @author <a href="mailto:eduardo.devera@gmail.com">Eduardo de Vera</a>
 */
@Mojo(name = "stopContainer")
public class DockerStopMojo extends DockerMojo{

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        try {
            stopContainer();
            removeContainer();
        } catch (DockerException e) {
            throw new MojoExecutionException(
                    String.format("Error while trying to remove container %s", getContainerId()), e);
        }
    }
}
