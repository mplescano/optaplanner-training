package org.optaplanner.persistence.jaxb.impl.domain.solution;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.optaplanner.persistence.common.api.domain.solution.SolutionFileIO;

import com.sun.xml.bind.IDResolver;

public class CustomJaxbSolutionFileIO<Solution_> implements SolutionFileIO<Solution_> {

    private final Marshaller marshaller;
    
    private final Unmarshaller unmarshaller;
    
    public CustomJaxbSolutionFileIO(Class... jaxbAnnotatedClasses) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(jaxbAnnotatedClasses);
            marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            unmarshaller = jaxbContext.createUnmarshaller();
        } catch (JAXBException e) {
            throw new IllegalArgumentException("JAXB creation for classes (" + Arrays.toString(jaxbAnnotatedClasses)
                    + ") has failed.", e);
        }
    }

    @Override
    public String getInputFileExtension() {
        return "xml";
    }

    @Override
    public Solution_ read(File inputSolutionFile) {
        try (Reader reader = new InputStreamReader(new FileInputStream(inputSolutionFile), "UTF-8")) {
            unmarshaller.setProperty(IDResolver.class.getName(), new IDResolverExtension());
            return (Solution_) unmarshaller.unmarshal(reader);
        } catch (IOException | JAXBException e) {
            throw new IllegalArgumentException("Failed reading inputSolutionFile (" + inputSolutionFile + ").", e);
        }
    }

    @Override
    public void write(Solution_ solution, File outputSolutionFile) {
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(outputSolutionFile), "UTF-8")) {
            marshaller.marshal(solution, writer);
        } catch (IOException | JAXBException e) {
            throw new IllegalArgumentException("Failed writing outputSolutionFile (" + outputSolutionFile + ").", e);
        }
    }
}
