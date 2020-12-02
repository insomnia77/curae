package ru.sbtqa.tag.stepdefs.en;

import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkingWithTablesStepDefs {

    /**
     * Check that there is any row in the table
     *
     * @param table_id
     * @param fieldNames
     * @param fieldValues
     * @throws Exception
     */
    @When("^user checks in table \"([^\"]*)\" fields \"([^\"]*)\" with values \"([^\"]*)\"$")
    public void check_values_in_table(String table_id, String fieldNames, String fieldValues) throws Exception {
        boolean result = check_values_in_table_result(table_id, fieldNames, fieldValues, true);
        Assert.assertTrue(result);

    }


    public boolean check_values_in_table_result(String table_id, String headersList, String values, boolean exist) throws Exception {
        List<WebElement> tables = Waits.waitAndGetElements("//table[@id='" + table_id + "']", Waits.medium_wait, Waits.pollingTime);
        Assert.assertTrue(tables.size() > 0);
        if (tables.size() == 0) {
            throw new Exception("Table [" + table_id + "] not found.");
        }

        List<String> headerNames = Arrays.asList(headersList.replace(", ", ",").split(",", -1));

        String[] vals = values.split(",", -1);
        for (int i = 0; i < vals.length; i++) {
            vals[i] = vals[i].replaceAll("\\[|\\]|\"", "").trim();
        }
        values = String.join(",", vals);

        Assert.assertEquals("Invalid input data. Count " + headersList + " must be " + values + ".", headerNames.size(), values.split(",", -1).length);

        List<WebElement> headers = Waits.waitAndGetElements("//table[@id='" + table_id + "']//th", Waits.medium_wait, Waits.pollingTime);
        List<String> colNums = new ArrayList<String>();
        List<String> colNames = new ArrayList<String>();
        for (int i = 0; i < headerNames.size(); i++) {
            for (int k = 0; i < headers.size(); k++) {
                String headerText = headers.get(k).getText();
                if (headerText.equals(headerNames.get(i))) {
                    colNums.add(String.valueOf(k + 1));
                    colNames.add(headers.get(k).getText().replace("\t", ""));
                    break;
                }
            }
        }
        if (colNums.size() != headerNames.size()) {
            throw new Exception("Some columns not found. Table:" + table_id + "Expected columns: " + headersList + "Actual columns: " + colNames);
        }
        ArrayList<String> rows = new ArrayList<String>();
        for (String col : colNums) {
            List<WebElement> cells = Waits.waitAndGetElements("//table[@id='" + table_id + "']//tr/td[" + col + "]", Waits.medium_wait, Waits.pollingTime);
            if (rows.size() == 0) {
                for (int i = 0; i < cells.size(); i++) {
                    rows.add(cells.get(i).getText());
                }
            } else {
                for (int i = 0; i < cells.size(); i++) {
                    rows.set(i, rows.get(i) + "," + cells.get(i).getText().replace(",", "`").replace("\n", "")).replaceAll("(?<=\\d)\\s(?=\\d)", "");
                }
            }
        }

        if (rows.contains(values) == exist) {
            return true;
        } else {
            System.out.println("Expected row " + (exist ? "exists" : "not exists"));
            return false;
        }

    }


}