package com.everyset.testcases;

import java.util.List;
import org.testng.TestNG;
import java.util.ArrayList;
import com.everyset.utilities.Constant_Paths;

public class FailedTestRunner {
public static void Runner() {
	TestNG runner=new TestNG();
	List<String>list=new ArrayList<String>();
	list.add(Constant_Paths.FailedTestcasepath);
	runner.setTestSuites(list);
	runner.run();

}
}
