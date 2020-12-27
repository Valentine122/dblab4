package ua.lviv.iot.view;

import ua.lviv.iot.controller.*;
import ua.lviv.iot.model.entity.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {

    private final ChildController childController = new ChildController();
    private final ChildGroupController childGroupController = new ChildGroupController();
    private final KindergartenController kindergartenController = new KindergartenController();
    private final ParentInfoController parentInfoController = new ParentInfoController();
    private final PaymentController paymentController = new PaymentController();
    private final VaccinationController vaccinationController = new VaccinationController();
    private final WorkerController workerController = new WorkerController();

    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private static final Scanner INPUT = new Scanner(System.in);

    public View() {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();

        menu.put("Q", "Q - exit program");
        menu.put("S", "S - show menu");

        menu.put("1", "1 - Get all children");
        menu.put("2", "2 - Get a technic by ID");
        menu.put("3", "3 - Create a technic");
        menu.put("4", "4 - Delete a technic by ID");
        menu.put("5", "5 - Update a technic \n");

        menu.put("6", "6 - Get all technics status");
        menu.put("7", "7 - Get a technic status by ID");
        menu.put("8", "8 - Create a technic status");
        menu.put("9", "9 - Delete a technic status");
        menu.put("0", "0 - Update a technic status \n");

        menu.put("11", "11 - Get all bosch services");
        menu.put("12", "12 - Get a bosch service by ID");
        menu.put("13", "13 - Create a bosch service");
        menu.put("14", "14 - Delete a bosch service");
        menu.put("15", "15 - Update a bosch service \n");

        menu.put("21", "21 - Get all tech info");
        menu.put("22", "22 - Get tech info by technic ID");
        menu.put("23", "23 - Create tech info for technic");
        menu.put("24", "24 - Delete tech info by technic ID");
        menu.put("25", "25 - Update tech info \n");

        menu.put("31", "31 - Get all payment info");
        menu.put("32", "32 - Get payment info by worker ID");
        menu.put("33", "33 - Create payment info for worker");
        menu.put("34", "34 - Delete payment info by worker ID");
        menu.put("35", "35 - Update payment info \n");

        menu.put("41", "41 - Get all replaced part info");
        menu.put("42", "42 - Get replaced part info by technic ID");
        menu.put("43", "43 - Create replaced part info for technic");
        menu.put("44", "44 - Delete replaced part info by technic ID");
        menu.put("45", "45 - Update replaced part info \n");

        menu.put("51", "51 - Get all workers");
        menu.put("52", "52 - Get a worker by ID");
        menu.put("53", "53 - Create a worker");
        menu.put("54", "54 - Delete a worker by ID");
        menu.put("55", "55 - Update a worker \n");

        methodsMenu.put("S", this::outputMenu);

        methodsMenu.put("1", this::getAllTechnics);
        methodsMenu.put("2", this::getTechnicById);
        methodsMenu.put("3", this::createTechnic);
        methodsMenu.put("4", this::deleteTechnic);
        methodsMenu.put("5", this::updateTechnics);

        methodsMenu.put("6", this::getAllStatuses);
        methodsMenu.put("7", this::getStatusById);
        methodsMenu.put("8", this::createStatus);
        methodsMenu.put("9", this::deleteStatus);
        methodsMenu.put("0", this::updateStatuses);

        methodsMenu.put("11", this::getAllBoschs);
        methodsMenu.put("12", this::getBoschsById);
        methodsMenu.put("13", this::createBoschs);
        methodsMenu.put("14", this::deleteBosch);
        methodsMenu.put("15", this::updateBosch);

        methodsMenu.put("21", this::getAllTechInfo);
        methodsMenu.put("22", this::getTechInfoByTechnicId);
        methodsMenu.put("23", this::createTechInfoByTechnicId);
        methodsMenu.put("24", this::deleteTechInfoByTechnicId);
        methodsMenu.put("25", this::updateTechInfo);

        methodsMenu.put("31", this::getAllPaymentInfo);
        methodsMenu.put("32", this::getPaymentInfoByWorkerId);
        methodsMenu.put("33", this::createPaymentInfoByWorkerId);
        methodsMenu.put("34", this::deletePaymentInfoByWorkerId);
        methodsMenu.put("35", this::updatePaymentInfo);

        methodsMenu.put("41", this::getAllReplacedPartsInfo);
        methodsMenu.put("42", this::getReplacedPartsInfoByTechnicId);
        methodsMenu.put("43", this::createReplacedPartsInfoByTechnicId);
        methodsMenu.put("44", this::deleteReplacedPartsInfoByTechnicId);
        methodsMenu.put("45", this::updateReplacedPartsInfo);

        methodsMenu.put("51", this::getAllWorkers);
        methodsMenu.put("52", this::getWorkerById);
        methodsMenu.put("53", this::createWorker);
        methodsMenu.put("54", this::deleteWorker);
        methodsMenu.put("55", this::updateWorker);
    }

    private void getAllTechnics() throws SQLException {
        System.out.println("\nTechnics:");
        System.out.println(childController.findAll());
    }

    private void getTechnicById() throws SQLException {
        System.out.println("\nEnter ID for a technic you want to find");
        int id = INPUT.nextInt();
        System.out.println(childController.findBy(id));
    }

    private void createTechnic() throws SQLException {
        System.out.println("\nEnter technic name");
        String name = INPUT.next();
        System.out.println("\nEnter date of entry (yyyy-mm-dd)");
        String dateOfEntry = INPUT.next();
        System.out.println("\nEnter technic group ID");
        int childGroupId = INPUT.nextInt();
        System.out.println("\nEnter bosch service ID");
        int childGroupKindergartenId = INPUT.nextInt();
        System.out.println("\nEnter technic status");
        String status = INPUT.next();
        Child child = new Child(name, Date.valueOf(dateOfEntry), childGroupId, childGroupKindergartenId, status);
        System.out.println(childController.create(child));
    }

    private void updateTechnics() throws SQLException {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter technic name");
        String name = INPUT.next();
        System.out.println("\nEnter date of entry (yyyy-mm-dd)");
        String dateOfEntry = INPUT.next();
        System.out.println("\nEnter technic group ID");
        int childGroupId = INPUT.nextInt();
        System.out.println("\nEnter bosch service ID");
        int childGroupKindergartenId = INPUT.nextInt();
        System.out.println("\nEnter technic status");
        String status = INPUT.next();
        Child child = new Child(id, name, Date.valueOf(dateOfEntry), childGroupId, childGroupKindergartenId, status);
        System.out.println(childController.update(child));
    }

    private void deleteTechnic() throws SQLException {
        System.out.println("\nEnter ID for technic you want to delete");
        int id = INPUT.nextInt();
        System.out.println(childController.delete(id));
    }

    private void getAllStatuses() throws SQLException {
        System.out.println("\nStatus:");
        System.out.println(childGroupController.findAll());
    }

    private void getStatusById() throws SQLException {
        System.out.println("\nEnter ID for a status you want to find");
        int id = INPUT.nextInt();
        System.out.println(childGroupController.findBy(id));
    }

    private void createStatus() throws SQLException {
        System.out.println("\nEnter bosch service ID");
        int kindergartenId = INPUT.nextInt();
        System.out.println("\nEnter technic status name");
        String name = INPUT.next();
        System.out.println("\nEnter count of technics");
        int countOfChildren = INPUT.nextInt();
        ChildGroup childGroup = new ChildGroup(kindergartenId, name, countOfChildren);
        System.out.println(childGroupController.create(childGroup));
    }

    private void updateStatuses() throws SQLException {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter bosch service ID");
        int kindergartenId = INPUT.nextInt();
        System.out.println("\nEnter technic status name");
        String name = INPUT.next();
        System.out.println("\nEnter count of technics");
        int countOfChildren = INPUT.nextInt();
        ChildGroup childGroup = new ChildGroup(id, kindergartenId, name, countOfChildren);
        System.out.println(childGroupController.update(childGroup));
    }

    private void deleteStatus() throws SQLException {
        System.out.println("\nEnter ID for technic status you want to delete");
        int id = INPUT.nextInt();
        System.out.println(childGroupController.delete(id));
    }

    private void getAllBoschs() throws SQLException {
        System.out.println("\nBosch service:");
        System.out.println(kindergartenController.findAll());
    }

    private void getBoschsById() throws SQLException {
        System.out.println("\nEnter ID for a bosch service you want to find");
        int id = INPUT.nextInt();
        System.out.println(kindergartenController.findBy(id));
    }

    private void createBoschs() throws SQLException {
        System.out.println("\nEnter bosch service name");
        String name = INPUT.next();
        System.out.println("\nEnter bosch service street");
        String street = INPUT.next();
        System.out.println("\nEnter bosch service building number");
        int buildingNumber = INPUT.nextInt();
        System.out.println("\nEnter count of technic statuses");
        int countOfGroup = INPUT.nextInt();
        Kindergarten kindergarten = new Kindergarten(name, street, buildingNumber, countOfGroup);
        System.out.println(kindergartenController.create(kindergarten));
    }

    private void updateBosch() throws SQLException {
        System.out.println("\nEnter bosch service ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter bosch service name");
        String name = INPUT.next();
        System.out.println("\nEnter bosch service street");
        String street = INPUT.next();
        System.out.println("\nEnter bosch service building number");
        int buildingNumber = INPUT.nextInt();
        System.out.println("\nEnter count of technic statuses");
        int countOfGroup = INPUT.nextInt();
        Kindergarten kindergarten = new Kindergarten(id, name, street, buildingNumber, countOfGroup);
        System.out.println(kindergartenController.update(kindergarten));
    }

    private void deleteBosch() throws SQLException {
        System.out.println("\nEnter ID for bosch service you want to delete");
        int id = INPUT.nextInt();
        System.out.println(kindergartenController.delete(id));
    }

    private void getAllTechInfo() throws SQLException {
        System.out.println("\nTech info:");
        System.out.println(parentInfoController.findAll());
    }

    private void getTechInfoByTechnicId() throws SQLException {
        System.out.println("\nEnter ID to get information about tech");
        int id = INPUT.nextInt();
        System.out.println(parentInfoController.findBy(id));
    }

    private void createTechInfoByTechnicId() throws SQLException {
        System.out.println("\nEnter technic ID");
        int childId = INPUT.nextInt();
        System.out.println("\nEnter father surname");
        String fatherSurname = INPUT.next();
        System.out.println("\nEnter mother phone number");
        String motherPhoneNumber = INPUT.next();
        ParentInfo parentInfo = new ParentInfo(childId, fatherSurname, motherPhoneNumber);
        System.out.println(parentInfoController.create(parentInfo));
    }

    private void updateTechInfo() throws SQLException {
        System.out.println("\nEnter technic ID");
        int childId = INPUT.nextInt();
        System.out.println("\nEnter father surname");
        String fatherSurname = INPUT.next();
        System.out.println("\nEnter mother phone number");
        String motherPhoneNumber = INPUT.next();
        ParentInfo parentInfo = new ParentInfo(childId, fatherSurname, motherPhoneNumber);
        System.out.println(parentInfoController.update(parentInfo));
    }

    private void deleteTechInfoByTechnicId() throws SQLException {
        System.out.println("\nEnter ID to delete information about tech");
        int id = INPUT.nextInt();
        System.out.println(parentInfoController.delete(id));
    }

    private void getAllPaymentInfo() throws SQLException {
        System.out.println("\nPayment info:");
        System.out.println(paymentController.findAll());
    }

    private void getPaymentInfoByWorkerId() throws SQLException {
        System.out.println("\nEnter ID to get information about payment");
        int id = INPUT.nextInt();
        System.out.println(paymentController.findBy(id));
    }

    private void createPaymentInfoByWorkerId() throws SQLException {
        System.out.println("\nEnter worker ID");
        int workerId = INPUT.nextInt();
        System.out.println("\nEnter salary");
        int salary = INPUT.nextInt();
        System.out.println("\nEnter amount of remuneration");
        int amountOfRemuneration = INPUT.nextInt();
        System.out.println("\nEnter date of pay (yyyy-mm-dd)");
        String dateOfPay = INPUT.next();
        Payment payment = new Payment(workerId, salary, amountOfRemuneration, Date.valueOf(dateOfPay));
        System.out.println(paymentController.create(payment));
    }

    private void updatePaymentInfo() throws SQLException {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter worker ID");
        int workerId = INPUT.nextInt();
        System.out.println("\nEnter salary");
        int salary = INPUT.nextInt();
        System.out.println("\nEnter amount of remuneration");
        int amountOfRemuneration = INPUT.nextInt();
        System.out.println("\nEnter date of pay (yyyy-mm-dd)");
        String dateOfPay = INPUT.next();
        Payment payment = new Payment(id, workerId, salary, amountOfRemuneration, Date.valueOf(dateOfPay));
        System.out.println(paymentController.update(payment));
    }

    private void deletePaymentInfoByWorkerId() throws SQLException {
        System.out.println("\nEnter ID to delete information about payment");
        int id = INPUT.nextInt();
        System.out.println(paymentController.delete(id));
    }

    private void getAllReplacedPartsInfo() throws SQLException {
        System.out.println("\nReplaced part info:");
        System.out.println(vaccinationController.findAll());
    }

    private void getReplacedPartsInfoByTechnicId() throws SQLException {
        System.out.println("\nEnter ID to get information about replaced part");
        int id = INPUT.nextInt();
        System.out.println(vaccinationController.findBy(id));
    }

    private void createReplacedPartsInfoByTechnicId() throws SQLException {
        System.out.println("\nEnter technic ID");
        int childId = INPUT.nextInt();
        System.out.println("\nEnter replaced part name");
        String name = INPUT.next();
        System.out.println("\nEnter date of vaccination (yyyy-mm-dd)");
        String dateOfVaccination = INPUT.next();
        Vaccination vaccination = new Vaccination(childId, name, Date.valueOf(dateOfVaccination));
        System.out.println(vaccinationController.create(vaccination));
    }

    private void updateReplacedPartsInfo() throws SQLException {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter technic ID");
        int childId = INPUT.nextInt();
        System.out.println("\nEnter replaced part name");
        String name = INPUT.next();
        System.out.println("\nEnter date of replaced part (yyyy-mm-dd)");
        String dateOfVaccination = INPUT.next();
        Vaccination vaccination = new Vaccination(id, childId, name, Date.valueOf(dateOfVaccination));
        System.out.println(vaccinationController.update(vaccination));
    }

    private void deleteReplacedPartsInfoByTechnicId() throws SQLException {
        System.out.println("\nEnter ID to delete information about replaced part");
        int id = INPUT.nextInt();
        System.out.println(vaccinationController.delete(id));
    }

    private void getAllWorkers() throws SQLException {
        System.out.println("\nWorkers:");
        System.out.println(workerController.findAll());
    }

    private void getWorkerById() throws SQLException {
        System.out.println("\nEnter ID for a worker you want to find");
        int id = INPUT.nextInt();
        System.out.println(workerController.findBy(id));
    }

    private void createWorker() throws SQLException {
        System.out.println("\nEnter worker name");
        String name = INPUT.next();
        System.out.println("\nEnter worker surname");
        String surname = INPUT.next();
        System.out.println("\nEnter date of employment (yyyy-mm-dd)");
        String dateOfEmployment = INPUT.next();
        System.out.println("\nEnter technic status ID");
        int childGroupId = INPUT.nextInt();
        System.out.println("\nEnter bosch service ID");
        int childGroupKindergartenId = INPUT.nextInt();
        System.out.println("\nEnter worker status");
        String status = INPUT.next();
        Worker worker = new Worker(name, surname, Date.valueOf(dateOfEmployment), childGroupId, childGroupKindergartenId, status);
        System.out.println(workerController.create(worker));
    }

    private void updateWorker() throws SQLException {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter worker name");
        String name = INPUT.next();
        System.out.println("\nEnter worker surname");
        String surname = INPUT.next();
        System.out.println("\nEnter date of employment (yyyy-mm-dd)");
        String dateOfEmployment = INPUT.next();
        System.out.println("\nEnter technic status ID");
        int childGroupId = INPUT.nextInt();
        System.out.println("\nEnter bosch service ID");
        int childGroupKindergartenId = INPUT.nextInt();
        System.out.println("\nEnter worker status");
        String status = INPUT.next();
        Worker worker = new Worker(id, name, surname, Date.valueOf(dateOfEmployment), childGroupId, childGroupKindergartenId, status);
        System.out.println(workerController.update(worker));
    }

    private void deleteWorker() throws SQLException {
        System.out.println("\nEnter ID for worker you want to delete");
        int id = INPUT.nextInt();
        System.out.println(workerController.delete(id));
    }

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    private void outputSubMenu() {
        System.out.println(menu.get("S"));
        System.out.println(menu.get("Q"));
        System.out.println("Please, select menu point.");
    }

    public void show() {
        String keyMenu;
        outputSubMenu();
        do {
            keyMenu = INPUT.next().toUpperCase();
            try {
                methodsMenu.get(keyMenu).print();
            }
            catch (Exception ignored) {
            }
            outputSubMenu();
        } while (!keyMenu.equals("Q"));
    }
}
