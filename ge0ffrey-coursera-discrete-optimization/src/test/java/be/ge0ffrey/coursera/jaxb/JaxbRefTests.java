package be.ge0ffrey.coursera.jaxb;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.jupiter.api.Test;
import org.optaplanner.examples.common.app.CommonApp;
import org.optaplanner.persistence.jaxb.impl.domain.solution.IDResolverExtension;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.bind.IDResolver;

import be.ge0ffrey.coursera.coloring.app.ColoringApp;
import be.ge0ffrey.coursera.coloring.domain.ColoringSolution;
import be.ge0ffrey.coursera.coloring.persistence.ColoringJaxbXmlDao;
import be.ge0ffrey.coursera.jackson.students.School;
import be.ge0ffrey.coursera.jackson.students.Student;

public class JaxbRefTests {

	
	//see https://stackoverflow.com/questions/23395012/jaxb-binding-the-list-of-references-to-another-element
	//see http://blog.bdoughan.com/2010/10/jaxb-and-shared-references-xmlid-and.html
	//see https://stackoverflow.com/questions/14558367/using-jaxb-to-create-reference-objects-accordingly-to-an-attribute
	//see https://stackoverflow.com/questions/43172836/how-to-use-jaxb-for-nested-pojo-class-to-generate-xml-model-in-java
	
	
	//see http://es.uwenku.com/question/p-synwflff-m.html
	//see https://community.oracle.com/tech/developers/discussion/1627470/jaxb-generating-java-classes-from-elements-with-attributes-id-idref
	//see https://stackoverflow.com/questions/50057419/jaxb-xml-repeating-alternating-xmlelements-without-parent-element
	//see https://stackoverflow.com/questions/12568247/how-to-deal-with-jaxb-complextype-with-mixedcontent-data
	//see https://cloudstack.ninja/raedma/jaxb-marshalling-list-implementation-with-xmlidref/
	//see https://stackoverflow.com/questions/21490247/jaxb-not-unmarshalling-child-object-xmlidref
	//see https://stackoverflow.com/questions/24257815/jaxb-unmarshall-child-xmlidref
	//see https://stackoverflow.com/questions/10794522/element-not-showing-using-jaxb
	//see https://stackoverflow.com/questions/20334460/jaxb-element-without-attribute
	//see https://stackoverflow.com/questions/32603410/jaxb-xml-mashal-with-xmlid-annotations
	//see https://stackoverflow.com/questions/10029228/using-jaxb-with-an-xml-file-with-many-of-the-same-elements
	
	@Test
	public void testUnmarshall() throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(ColoringSolution.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        unmarshaller.setProperty(IDResolver.class.getName(), new IDResolverExtension());
		
		File inputSolutionFile = new File(CommonApp.determineDataDir(ColoringApp.DATA_DIR_NAME + "/" + "unsolved"),
				"gc_50_3.xml");
        if (!inputSolutionFile.exists()) {
            throw new IllegalStateException("The file inputFile (" + inputSolutionFile.getAbsolutePath()
                    + ") does not exist.");
        }

        try (Reader reader = new InputStreamReader(new FileInputStream(inputSolutionFile), "UTF-8")) {
        	ColoringSolution solution = (ColoringSolution) unmarshaller.unmarshal(reader);
    		assertNotNull(solution.getEdgeList().get(0).getLeftNode(), "Expected not null");
    		assertNotNull(solution.getNodeList().get(0).getEdgeList().get(0), "Expected not null");
        } catch (IOException | JAXBException e) {
            throw new IllegalArgumentException("Failed reading inputSolutionFile (" + inputSolutionFile + ").", e);
        }
	}
	
	@Test
	public void testJacksonUnmarshall() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
	    School school = new School(1, "St Magdalene's");
	    Student mary = new Student(1, "Mary", school);
	    Student bob = new Student(2, "Bob", school);
	    Student[] students = new Student[] {mary, bob};

	    // Write out
	    String serialized = mapper.writeValueAsString(students);
	    System.out.println("Serialized: " + serialized);
	    // Read in
	    Student[] deserialized = mapper.readValue(serialized, Student[].class);
	}
}
