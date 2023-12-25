package test;
import io.cucumber.java.en.*;
import car.Appointment;
import car.Installer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static car.Appointment.*;
import static org.example.Main.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminAppointment {
    private String CarModel;
    private String CarDate;
    private String installerNumber;
    private String appointmentDate;
    Appointment appointment;
    Installer installer;
    Installer installer111= new Installer(1, "installerrdeema", "deema@najah.edu","111","installer","12/12/2023");
    Installer installer222= new Installer(222, "installerrRRdeema", "deema@najah.edu","111","installer","12/12/2023");
    public static List<Appointment> appointmentList=new ArrayList<>();
    public static List<Installer> installersDatabase = new ArrayList<>();
    Appointment appointment111=new Appointment("DEEMA","12/12/2002","LL","2020");


    private static Logger logger = Logger.getLogger(AdminAppointment.class.getName());

    @Given("admin choose Schedule Appointment")
    public void adminChooseScheduleAppointment() {
        addToIntallerList(installer111);
        appointment.setChooseSchedule(true);
        assertTrue(isChooseSchedule());
       }
    @When("car model is {string}")
    public void carModelIs(String string) {
        this.CarModel=string;
       }
    @When("car date is {string}")
    public void carDateIs(String string) {this.CarDate=string;
        this.appointmentDate=string; }
    @Then("Available Installers will be shown")
    public void availableInstallersWillBeShown() {
       }
    @When("installer number is {string}")
    public void installerNumberIs(String string) {
        this.installerNumber=string;
        }
    @When("appointment date is {string}")
    public void appointmentDateIs(String string) {
      }
    @Then("the appointment should be scheduled successfully")
    public void theAppointmentShouldBeScheduledSuccessfully() {
        appointment=new Appointment("laith",appointmentDate,CarModel,CarDate);
        appointmentList.add(appointment);
        List<Installer> installersDatabase=getInstallersDatabase();
        scheduleAppointment(CarModel,CarDate,installer111.getId(),installersDatabase);
        scheduleAppointment(CarModel,CarDate,installer222.getId(),installersDatabase);
    }
    @Given("admin choose List Appointments")
    public void adminChooseListAppointments() {
        }
    @Then("they should see a list of scheduled appointments")
    public void theyShouldSeeAListOfScheduledAppointments() {
         }

}
