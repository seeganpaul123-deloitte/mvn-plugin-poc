package sample.plugin;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.apache.maven.plugin.testing.MojoRule;
import org.apache.maven.plugin.testing.WithoutMojo;
import org.junit.Rule;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class TextFileTest extends AbstractMojoTestCase {

    /**
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception
    {
        // required for mojo lookups to work
        super.setUp();
    }

    public void testTextFile() throws Exception {
        File testPom = new File( getBasedir(),
                "src/test/resources/project-to-test/pom.xml" );
        TextFile textFile = (TextFile) lookupMojo("create-text-file", testPom);
        assertNotNull(textFile);
        textFile.execute();
    }

}
