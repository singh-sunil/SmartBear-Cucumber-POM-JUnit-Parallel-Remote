package com.smartbear.junitparalleltests;

import com.smartbear.base.GridParallelTestBase;
import com.smartbear.base.Parallelized;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Platform;
@RunWith(Parallelized.class)
public class GridParallelTest extends GridParallelTestBase {
    //Constructor
    public GridParallelTest(String browserName) {
        super(browserName);
    }
    @Test
    public void parallelGridTest() throws Exception {
        //Set Platform Name
        setPlatform(Platform.WIN10);
        //Go to Amazon.com
        System.out.println("Test is started for: "+ browserName);
        driver.get("http://www.yahoo.com");
        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Test is finished for: "+ browserName);
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
