package com.smartbear.junitparalleltests;

import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;

/**
 * Created by Sunil on 7th July 2021
 */
public class GridParallelComputerTest {
    /* ~~~~~~Description~~~~~~
    Run All Test in Parallel with JUnit's ParallelComputer feature.
    By using below logic you can run your junit cases in parallel.
    Class[] cls={test1.class,test2.class,test3.class,test4.class};
    JUnitCore.runClasses(new ParallelComputer(true,true),cls);
    In above method first parameter of ParallelComputer() indicates classes and second one is for methods.
    Here I'm running classes and methods in parallel.
    ParallelComputer Class documentation is below:
    http://junit-team.github.io/junit/javadoc/4.10/org/junit/experimental/ParallelComputer.html
    */
    @Test
    public void runAllTests() {
        Class<?>[] classes = {SmartBearParallelTest1.class,SmartBearParallelTest2.class};
        // ParallelComputer(true,true) will run all classes and methods
        // in parallel.  (First arg for classes, second arg for methods)
        // I set true, true this means classes and methods runs in parallel.
        JUnitCore.runClasses(new ParallelComputer(true, true), classes);
    }
}
