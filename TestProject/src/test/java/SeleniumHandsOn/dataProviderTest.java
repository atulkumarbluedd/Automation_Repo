package SeleniumHandsOn;

import JavaHandsOn.Person;
import JavaHandsOn.PersonSerializableTest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class dataProviderTest {

    @Test(dataProvider = "twoD_Array", description = "run data provider 2 D array !!")
    public void sample(String name, String college) {
        System.out.println(name + " " + college);
    }

    @Test(dataProvider = "oneD_Array", description = "run data provider for 1 D array !!")
    public void sampleRun_1DArray(String name) {
        System.out.println(name);
    }

    @Test(dataProvider = "personDetails", dataProviderClass = Person.class,
            description = "Here we are using data provider from diff class !! ")
    public void runDataProvider_diffClass(Person person) {
        System.out.println(person.getAge());
        System.out.println(person.getName());
    }


    /**
     * Here we can use same number of parameters otherwise it will throw --> org.testng.internal.reflect.MethodMatcherException:
     * 1. one more thing is whenever you are using data provider from diff class then make sure you have data provider method
     * must be static. other wise it will not work !!
     *
     * @return
     */
    @DataProvider
    public Object[][] twoD_Array() {
        return new Object[][]{
                {"sonam", "shyam"},
                {"rohan", "rama"},
                {"preshan atma", "devashish"}
        };
    }

    @DataProvider
    public String[] oneD_Array() {
        return new String[]{"radha", "shyam", "ron"};
    }

    /* *************************************************************************************************************************************/

    /**
     * advanced data provider concept
     */

    @Test(dataProvider = "multiDataProvider", description = "test1 ")
    public void test1(String name) {
        System.out.println(name);
    }

    @Test(dataProvider = "multiDataProvider", description = "test2")
    public void test2(Person person) {
        System.out.println(person.getName() + "::" + person.getAge());
    }

    /**
     * call multiple data provider from here
     */
    @DataProvider
    public static Object[] multiDataProvider(Method method) {
        if (method.getName().equals("test1")) {
            return new String[]{"sreeram", "sohan"};
        } else if (method.getName().equals("test2")) {
            return new Person[]{
                    new Person("sweta", "32"),
                    new Person("sneha", "34")};
        }
        return null;
    }

    /*********** read excel data and use it in data provider **********/
    @Test(dataProvider = "readExcelData", description = "this test is to demonstrate read excel and store it in data provider !!")
    public void readExcelData(String name, String Age, String marks) {
        System.out.println("provide excel and use it  ");
    }

    @DataProvider
    public Object[][] readExcelData() throws Exception {
        FileInputStream fis = new FileInputStream("abc.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("sheet1");
        int rows = sheet.getLastRowNum();
        int collums = sheet.getRow(0).getLastCellNum();
        Object[][] sheetData = new Object[rows][collums];
        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < collums; j++)
                sheetData[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue(); // data[1][0]=
        }

        return sheetData;
    }

    /**
     * ****we can store all data in the hashmap as well and return it as 1d object array as well
     ********/
    public Object[] storeExcelData() throws Exception {

        FileInputStream fis = new FileInputStream("abc.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("sheet1");
        int rows = sheet.getLastRowNum();
        int collums = sheet.getRow(0).getLastCellNum();
        Object[] sheetData = new Object[rows];
        HashMap<String, String> map;
        for (int i = 1; i <= rows; i++) {
            map = new HashMap<String, String>();
            for (int j = 0; j < collums; j++) {
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(j).getStringCellValue();
                map.put(key, value);
                sheetData[i - 1] = map;
            }
        }
        return sheetData;
    }


    @Test(dataProvider = "storeExcelData", description = "use excel and store all data in one d array using map")
    public void ExcelDataprovider(HashMap<String, String> map) {
        System.out.println("use excel and fill it and store it in and fetch data using map");
        /**
         * here key will be first row where all the variables were stored and values are present in the every row in horizontal drection
         */
    }

    /**** data provider with jackson databind and jackson core these 2 jars are required  to read json file******/
    @Test(dataProvider = "jsonDataProvider", description = "use json and store in map using data provider")
    public void jackson_jsonReader(Map<String, Object> map) {
        System.out.println("use this to read json and store in data provider !!");
        map.forEach((k, v) -> System.out.println(k + " :" + v));
    }

    /**
     * Here we are reading json and store in map using jackson core and jackson data bind dependencies
     *
     * @return
     * @throws Exception
     */
    @DataProvider
    public Object[] jsonDataProvider() throws Exception {
        String jsonPath1 = "./Resources/test.json";
        String jsonPath2 = "./Resources/newFile.json";
        HashMap<String, Object> map1 = new ObjectMapper().readValue(new File(jsonPath1),
                HashMap.class);
        /** any thing we can use here like above or like below just make sure what kind of data we are going to store in the map */
        HashMap<String, Object> map2 = new ObjectMapper().readValue(new File(jsonPath2),
                new TypeReference<HashMap<String, Object>>() {
                });

        return new Object[]{map1, map2};
    }

    /**
     * if you want the data provided by data provider to be used in parallel for the method then use like below
     * means  provide parallel=true
     * Note --> one more thing suppose you have 1000 data, and you just provided parallel=true then all 1000 data will be executed in parallel
     * so in this case go to your testng.xml file and there provide *****>>> data-provide-thread-count="3" <<<<**** at the suite level it will execute only 3
     * threads parallel
     */
    @DataProvider(parallel = true)
    public Object[] runTestInParallel() {
        return new Object[]{};
    }


}
