package sample.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * create a txt file in resource folder
 */
@Mojo(name = "create-text-file", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class TextFile extends AbstractMojo {
    /**
     * Name of the text file to create.
     */
    @Parameter(property = "outputFileName", defaultValue = "example.txt")
    private String outputFileName;

    /**
     * Text content to write to the file.
     */
    @Parameter(property = "textContent", defaultValue = "Hello, world!")
    private String textContent;
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

        try{
            File resourcesDir = new File("src/main/resources");
            if (!resourcesDir.exists()) {
                resourcesDir.mkdirs();
            }

            File outputFile = new File(resourcesDir, outputFileName);
            FileWriter writer = new FileWriter(outputFile);
            writer.write(textContent);
            writer.close();

            getLog().info("Created file: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
