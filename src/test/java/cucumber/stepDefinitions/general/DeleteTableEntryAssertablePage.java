package cucumber.stepDefinitions.general;

import exceptions.TableRowDoesNotExistException;

import java.util.Map;

public interface DeleteTableEntryAssertablePage {

    void assertIncorrectTableContents(Map<String, String> fieldDataFromPage) throws TableRowDoesNotExistException;

}
