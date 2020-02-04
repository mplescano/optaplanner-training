package be.ge0ffrey.coursera;

import java.io.File;

import org.optaplanner.core.api.domain.solution.Solution;

/**
 * Reads or writes a {@link Solution} from or to a {@link File}.<
 * <p/>
 * This class is thread-safe.
 */
public interface ProblemIO {

    /**
     * Every {@link Solution} type potentially has its own file extension.
     * If no specific file extension is defined by the use case, the following are recommended:
     * <ul>
     *     <li>If this {@link ProblemIO} implementation serializes to XML, use file extension "xml".</li>
     *     <li>If this {@link ProblemIO} implementation serializes to text, use file extension "txt".</li>
     *     <li>If this {@link ProblemIO} implementation serializes to binary, use file extension "dat".</li>
     * </ul>
     * <p/>
     * It's good practice that both the input and the output file have the same file extension,
     * because an output file should be able to function as an input file.
     * If that isn't the case, this method should return the output file extension.
     * <p/>
     * The file extension does not include the dot that separates it from the base name.
     * <p/>
     * This method is thread-safe.
     * @return never null, for example "xml"
     */
    String getFileExtension();

    /**
     * This method is thread-safe.
     * @param inputSolutionFile never null
     * @return never null
     */
    Solution read(File inputSolutionFile);

    /**
     * This method is thread-safe.
     * @param solution never null
     * @param outputSolutionFile never null, parent directory already exists
     */
    void write(Solution solution, File outputSolutionFile);

}