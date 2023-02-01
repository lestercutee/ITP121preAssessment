package src;

import java.util.*;

public class preAssessment {

    String component;
    String peripheral;
    String employee;
    String code;

    preAssessment(String code, String component, String peripheral, String employee) {
        this.code = code;
        this.component = component;
        this.peripheral = peripheral;
        this.employee = employee;
    }

    public String getCode() {
        return this.code;
    }

    public String getComponent() {
        return this.component;
    }

    public String getPeripheral() {
        return this.peripheral;
    }

    public String getEmployee() {
        return this.employee;
    }
    static int id = 0001;

    public static void main(String[] args) {

        ArrayList<preAssessment> lists = new ArrayList<preAssessment>();
        Scanner sc = new Scanner(System.in);

        int ch;
        ch = 1;
        while (ch != 0) {
            System.out.println("\n1. Add Record");
            System.out.println("2. View Record");
            System.out.println("3. Delete Record");
            System.out.println("4. Edit Record");
            System.out.println("5. Report");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:

                    System.out.print("Enter Component Name: ");
                    String component = sc.next();

                    System.out.print("Enter Peripheral Type(Input/Output): ");
                    String peripheral = sc.next().toLowerCase();

                    System.out.print("Assign to employee(skip if none): ");
                    sc.nextLine();
                    String employee = sc.nextLine();

                    if (employee == "") {
                        employee = "None";
                    }

                    Iterator iter = lists.iterator();
                    if (iter.hasNext()) {
                        id++;
                    }

                    String code = "2023" + String.format("%04d", id);

                    lists.add(new preAssessment(code, component, peripheral, employee));
                    break;

                case 2:
                    System.out.println("\na. View all peripherals");
                    System.out.println("b. View available peripherals");
                    System.out.println("c. View not available peripherals");
                    System.out.println("d. View all input devices");
                    System.out.println("e. View all output devices");
                    System.out.println("f. View all input/output devices");
                    System.out.println("g. View all employess");
                    System.out.print("Enter your choice: ");
                    String choice = sc.next();

                    System.out.println("*---------------------------*");
                    for (preAssessment list : lists) {
                        if (choice.equals("a")) {
                            System.out.println("Code: " + list.getCode());
                            System.out.println("Component: " + list.getComponent());
                            System.out.println("Peripheral: " + list.getPeripheral());
                            System.out.println("Assigned to: " + list.getEmployee());
                            System.out.println("*---------------------------*");
                        } else if (choice.equals("b")) {
                            if (list.getEmployee().equals("None")) {

                                System.out.println("Code: " + list.getCode());
                                System.out.println("Component: " + list.getComponent());
                                System.out.println("Peripheral: " + list.getPeripheral());
                                System.out.println("Assigned to: " + list.getEmployee());
                                System.out.println("*---------------------------*");
                            }
                        } else if (choice.equals("c")) {
                            if (!list.getEmployee().equals("None")) {

                                System.out.println("Code: " + list.getCode());
                                System.out.println("Component: " + list.getComponent());
                                System.out.println("Peripheral: " + list.getPeripheral());
                                System.out.println("Assigned to: " + list.getEmployee());
                                System.out.println("*---------------------------*");
                            }
                        } else if (choice.equals("d")) {
                            if (list.getPeripheral().equals("input")) {

                                System.out.println("Code: " + list.getCode());
                                System.out.println("Component: " + list.getComponent());
                                System.out.println("Peripheral: " + list.getPeripheral());
                                System.out.println("Assigned to: " + list.getEmployee());
                                System.out.println("*---------------------------*");
                            }
                        } else if (choice.equals("e")) {
                            if (list.getPeripheral().equals("output")) {
                                System.out.println("Code: " + list.getCode());
                                System.out.println("Component: " + list.getComponent());
                                System.out.println("Peripheral: " + list.getPeripheral());
                                System.out.println("Assigned to: " + list.getEmployee());
                                System.out.println("*---------------------------*");
                            }
                        } else if (choice.equals("f")) {
                            if (list.getPeripheral().equals("input/output")) {
                                System.out.println("Code: " + list.getCode());
                                System.out.println("Component: " + list.getComponent());
                                System.out.println("Peripheral: " + list.getPeripheral());
                                System.out.println("Assigned to: " + list.getEmployee());
                                System.out.println("*---------------------------*");

                            }

                        }
                        if (choice.equals("g")) {
                            System.out.println("Assigned to: " + list.getEmployee());
                            System.out.println("*---------------------------*");
                        }
                    }
                    break;

                case 3:
                    boolean found = false;
                    System.out.print("Enter Code to Delete: ");
                    String delCode = sc.next();
                    int i = 0;
                    try {
                        for (var list : lists) {
                            if (delCode.equals(list.getCode())) {
                                lists.remove(i);
                                found = true;
                            }
                            if (!found) {
                                System.out.println("*---------------------------*");
                                System.out.println("Record not Found");
                                System.out.println("*---------------------------*");
                            } else {
                                System.out.println("*--------------------------------*");
                                System.out.println("Record is Deleted Successfully");
                                System.out.println("*--------------------------------*");
                            }

                            i++;
                        }
                    } catch (Exception e) {

                    }
                    break;

                case 4:
                    found = false;
                    System.out.print("Enter Code to Edit: ");
                    String edCode = sc.next();
                    String newComponent,
                     newType,
                     newEmployee;
                    for (int index = 0; index < lists.size(); index++) {
                        preAssessment assessment = lists.get(index);
                        if (edCode.equals(assessment.getCode())) {
                            found = true;
                            System.out.print("Enter new component: ");
                            newComponent = sc.next();
                            System.out.print("Enter new peripheral: ");
                            newType = sc.next();
                            System.out.print("Assign to new employee: ");
                            newEmployee = sc.next();

                            lists.set(index, new preAssessment(edCode, newComponent, newType, newEmployee));
                            System.out.println("*--------------------------------*");
                            System.out.println("Record Edited Successfully");
                            System.out.println("*--------------------------------*");
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("*---------------------------*");
                        System.out.println("Record not Found");
                        System.out.println("*---------------------------*");
                    }
                    break;
                case 5:
                    int availablePeripherals = 0,
                     assignedPeripherals = 0,
                     inputDevices = 0,
                     outputDevices = 0,
                     employees = 0;
                    System.out.println("\na. Number of available peripherals");
                    System.out.println("b. Number of assigned peripherals");
                    System.out.println("c. Number of input device");
                    System.out.println("d. Number of output device");
                    System.out.println("e. Number of employees with peripherals assigned");
                    System.out.print("Enter your choice: ");

                    String choices = sc.next();
                    for (var list : lists) {
                        if (list.getEmployee().equals("None")) {
                            availablePeripherals++;
                        }
                        if (!list.getEmployee().equals("None")) {
                            assignedPeripherals++;
                        }
                        if (list.getPeripheral().equals("input")) {
                            inputDevices++;
                        }
                        if (list.getPeripheral().equals("output")) {
                            outputDevices++;
                        }
                        if (!list.getEmployee().equals("None")) {
                            employees++;
                        }
                    }

                    if (choices.equals("a")) {
                        System.out.println("Number of available peripherals: " + availablePeripherals);
                    } else if (choices.equals("b")) {
                        System.out.println("Number of assigned peripherals: " + assignedPeripherals);
                    } else if (choices.equals("c")) {
                        System.out.println("Number of assigned peripherals: " + inputDevices);
                    } else if (choices.equals("d")) {
                        System.out.println("Number of assigned peripherals: " + outputDevices);
                    } else if (choices.equals("e")) {
                        System.out.println("Number of employees with peripherals assigned: " + employees);
                    }

                    break;

                default:
                    ch = 0;
                    System.out.println("Thank You!");
                    break;
            }
        }

    }

}
