package org.hubotek.test.solr;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import org.hubotek.solr.client.service.SolrJPersistenceService;
import org.hubotek.solr.configuration.rdb.SolrConfiguration;
import org.hubotek.solr.configuration.rdb.event.TemporalBaseEvent;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

public abstract class BaseEarModelDeployer {

	
	@Deployment
	public static Archive<?> createDeploymentPackage() throws IOException {

		File[] files = Maven.resolver().loadPomFromFile("src/test/resources/test-pom.xml")
							.importRuntimeDependencies().resolve().withTransitivity().asFile();

		Stream<File> jarFilesStream = Arrays.asList(files).stream();//.forEach(s -> print(s.getName()))

		final EnterpriseArchive ear = ShrinkWrap.create(EnterpriseArchive.class)
												.setApplicationXML("test-application.xml")
												.addAsModule(prepareEjbJarArchive())
												.addAsModule(prepareWarArchive());
//		retrieveModelJavaArchive().stream().forEach(mod -> ear.addAsModule(mod));
		jarFilesStream.forEach(jf -> ear.addAsLibraries(jf));
		return ear;
	}
	
	protected static JavaArchive prepareEjbJarArchive()
	{ 
		JavaArchive ejbJar = ShrinkWrap.create(JavaArchive.class, "ejb-jar.jar")
										.addPackage(org.hubotek.Base.class.getPackage())
										.addPackage(SolrJPersistenceService.class.getPackage())
										.addPackage(SolrConfiguration.class.getPackage())
										.addPackage(TemporalBaseEvent.class.getPackage())
										.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
										.addAsResource("log4j.properties", "log4j.properties")
										.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml");
		
		return ejbJar;
	}
	
	protected static WebArchive prepareWarArchive() {
		return  ShrinkWrap.create(WebArchive.class, "test.war").addClass(BaseEarModelDeployer.class).addClass(TestSolrConfiguration.class).addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
}