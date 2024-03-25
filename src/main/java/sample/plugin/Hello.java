package sample.plugin;


import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 *  saying hello
 */
@Mojo( name = "hello", defaultPhase = LifecyclePhase.GENERATE_SOURCES )
public class Hello extends AbstractMojo{
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("Hello, How are you?");
    }
}
