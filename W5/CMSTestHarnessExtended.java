package app;

import cms.app.CMSTestHarness;
import cms.model.aircraft.Aircraft;
import cms.model.interfaces.Vehicle;
import cms.model.vehicle.Truck;
import cms.model.vehicle.Van;

/**
 * TestHarness which tests the following functionalities
 * 
 * 1. Tests adding, retrieving LandVehicles and Aircrafts
 * 
 * 2. Tests scheduling a Job to a Land Vehicle (Van, Truck)
 * 
 * 3. Tests Scheduling a Job to an Aircraft
 * 
 * 4. Tests Servicing a Vehicle
 * 
 *  Original author unknown: refactored by Caspar s1 2018
 *  
 *  extends last weeks test harness to reuse the testSchedule method
 */
public class CMSTestHarnessExtended extends CMSTestHarness
{
	// Van and Truck constructors same as last week
	// Aircraft(id, make, model, year, averageSpeed, maxFlights, flightHours, serviceInterval (in hours))
	private static Vehicle[] testVehicles = new Vehicle[]
	{ new Van("v1", "Toyota", "Sienna", 1998, 0.0, 500.0), new Van("v2", "Volkswagen", "Routan S", 2009, 0.0, 1000.0),
			new Truck("t1", "Peterbilt", "379 ", 1990, 0.0, 2000.0, 3000), new Truck("t2", "Peterbilt", "386", 2005,
					0.0, 2000.0, 3500), new Aircraft("a1", "Boeing", "747", 2003, 1000, 6, 0.0, 30.0), new Aircraft(
							"a2", "Boeing", "707", 1979, 1000.0, 6, 0.0, 20.0), new Aircraft("a3", "Lockheed",
									"L188C Electra", 1957, 1000.0, 3, 0.0, 10.0) };

	/**
	 * Tests adding, retrieving and removing LandVehicles and Aircrafts
	 * 
	 * @return true if the test succeeds false otherwise
	 */
	private static boolean test1()
	{

		displayFormattedTestTitle("Test1(Add, Get and Remove Vehicles)");
		// Add all testVehicles
		for (Vehicle testVehicle : testVehicles)
		{
			cms.addVehicle(testVehicle);
			// check whether vehicle has been added
			Vehicle v = cms.getVehicle(testVehicle.getReg());
			if (!v.equals(testVehicle))
			{
				System.out.println("FAILED to add vehicle " + testVehicle.getReg());
				// exit early if test fails
				return false;
			}
		}

		// Remove ALL vehicles
		for (Vehicle testVehicle : testVehicles)
		{
			cms.removeVehicle(testVehicle.getReg());
			// test whether vehicle has been removed
			if (cms.getVehicle(testVehicle.getReg()) != null)
			{
				System.out.println("FAILED to remove vehicle " + testVehicle.getReg());
				return false;
			}
		}
		return true;
	}

	/**
	 * Tests scheduling a Jobs to a Land Vehicle (Van)
	 * 
	 * @return true if the test succeeds false otherwise
	 */
	private static boolean test2()
	{
		displayFormattedTestTitle("Test2(Scheduling jobs to a Land Vehicle(Van)");
		cms.addVehicle(testVehicles[1]);
		String reg = testVehicles[1].getReg();
		// start with true then boolean 'AND' every subsequent subtest
		boolean passed = true;
		passed &= testSchedule(reg, 700, true);
		passed &= !testSchedule(reg, 500, false); // note the NOT '!' since it should reject
		passed &= testSchedule(reg, 100, true);
		passed &= !testSchedule(reg, 300, false);
		if (!passed)
			System.out.println("FAILED to correctly schedule one or more jobs to a Van");
		cms.removeVehicle("v2");
		return passed;
	}

	/**
	 * Tests Scheduling a Jobs to an Aircraft
	 * 
	 * @return true if the test succeeds false otherwise
	 */
	private static boolean test3()
	{
		displayFormattedTestTitle("Test3(Scheduling jobs to an Aircraft");
		cms.addVehicle(testVehicles[6]);
		String reg = testVehicles[6].getReg();
		boolean passed = true;
		passed &= testSchedule(reg, 4000, true);
		passed &= testSchedule(reg, 5000, true);
		passed &= !testSchedule(reg, 3000, false); // should reject, exceeds flightHours
		passed &= testSchedule(reg, 500, true);
		passed &= !testSchedule(reg, 3000, false); // should reject, exceeds flightCount
		if (!passed)
			System.out.println("FAILED to accurately schedule  OR reject one or more jobs to an aircraft;");
		cms.removeVehicle("a3");
		return passed;
	}

	/**
	 * Tests Servicing a Vehicle
	 * 
	 * @return true if the test succeeds false otherwise
	 */
	private static boolean test4()
	{
		displayFormattedTestTitle("Test4 (Servicing Land Vehicle(Van) and Aircraft)");
		cms.addVehicle(testVehicles[0]);
		String reg = testVehicles[0].getReg();
		boolean passed = true;
		passed &= testSchedule(reg, 400, true);
		passed &= !testSchedule(reg, 400, false); // reject
		cms.serviceVehicle(reg); // service
		passed &= testSchedule(reg, 400, true); // scheduled after service

		if (!passed)
		{
			System.out.println("FAILED to correctly Service Van");
			return false;
		}

		// reset test flag
		passed = true;
		cms.addVehicle(testVehicles[5]);
		reg = testVehicles[5].getReg();
		passed &= testSchedule(reg, 15000, true);
		passed &= !testSchedule(reg, 15000, false);
		cms.serviceVehicle("a2");
		passed &= testSchedule(reg, 15000, true); // scheduled after service
		if (!passed)
			System.out.println("FAILED to correctly service an Aircraft");
		return passed;
	}

	// run all tests and return aggregate result
	private static boolean testAll()
	{
		boolean allPass = true;
		if ((allPass &= test1()))
			System.out.println("PASSED");
		if ((allPass &= test2()))
			System.out.println("PASSED");
		if ((allPass &= test3()))
			System.out.println("PASSED");
		if ((allPass &= test4()))
			System.out.println("PASSED");
		return allPass;
	}

	private static void displayFormattedTestTitle(String title)
	{
		// Caspar: I didn't write this but is an interesting use of format so kept it :)
		System.out.println(String.format("%010d%s%010d", 0, title, 0).replace("0", "-"));
	}

	public static void main(String[] args)
	{
		// the logging is fairly concise .. add displayAllJobs() and displayAllVehicles() as needed to debug :) 
		System.out.printf("\nAGGREGATE RESULT: %s\n", testAll() ? "ALL TESTS PASSED!" : "SOME TESTS FAILED!");
	}
}
