package sample.plugin;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;

import java.io.File;

public class HelloTest extends AbstractMojoTestCase {

    public void testHello() throws Exception {
        File testPom = new File( getBasedir(),
                "src/test/resources/hellotest/pom.xml" );
        Hello hello = (Hello) lookupMojo("hello", testPom);
        assertNotNull(hello);
        hello.execute();
    }
}
