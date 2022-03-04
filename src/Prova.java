
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


//https://www.benchresources.net/java-8-sorting-list-of-objects-on-multiple-fields/


public class Prova {


    // customer list
    private static List<Customer> getUnSortedCustomers() {

        return Arrays.asList(
                new Customer("Shalini", "Chennai", 60, "12/12/2077"),
                new Customer("Sneha", "Pune", 73, "12/12/2010"),
                new Customer("Simran", "Bangalore", 37, "01/01/2010"),
                new Customer("Trisha", "Hyderabad", 52, "01/01/2090"),
                new Customer("Shalini", "Chennai", 70, "12/12/2020"),
                new Customer("Abirami", "Bangalore", 48, "12/12/2070"),
                new Customer("AZIZI", "NADIA", 73, "12/12/2060"),
                new Customer("Sneha", "Pune", 62, "12/12/2030"),
                new Customer("AZIZI", "ENDRI", 50, "12/12/2020")
        );
    }

    // main() method
    public static void main(String[] args) {

        // get customer list
        List<Customer> unsortedCustomerList = getUnSortedCustomers();

        System.out.println("Before Sorting: Customer list :- \n");
        unsortedCustomerList.stream().forEach(System.out::println);


        System.out.println("\n\nSorted Customer list on multiple fields"
                + " using Lambda Expression :- \n");

        // 1. customer Name comparator
        Comparator<Customer> nameComparatorLEx =
                (cust1, cust2) -> cust1.getCustName().compareTo(cust2.getCustName());

        // 2. customer City comparator
        Comparator<Customer> cityComparatorLEx =
                (cust1, cust2) -> cust1.getCustCity().compareTo(cust2.getCustCity());

        // 3. customer Age comparator
        Comparator<Customer> ageComparatorLEx =
                (cust1, cust2) -> cust1.getCustAge().compareTo(cust2.getCustAge());

        // sorting on multiple fields (3-level) using Lambda expression
        List<Customer> sortedCustomerList = unsortedCustomerList
                .stream()
                .sorted(
                        nameComparatorLEx // 1st compare Name
                                .thenComparing(cityComparatorLEx) // then 2nd compare City
                                .thenComparing(ageComparatorLEx)) // then 3rd compare Age
                .collect(Collectors.toList()); // collect sorted customers to new list

        // print new list to console using forEach()
        sortedCustomerList.stream().forEach(cust -> System.out.println(cust));


        unsortedCustomerList.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                // - ORDINE DECRESCENTE
                //int resultPrimoConfrontoDaPunteggio = -((o1.getCustAge()).compareTo(o2.getCustAge()));
                //int resultPrimoConfrontoDaPunteggio = -((o1.getDataDiNascita()).compareTo(o2.getDataDiNascita()));

                DateFormat f = new SimpleDateFormat("dd/mm/yyyy");
                Date d1 = f.parse(o1.getDataDiNascita(), new ParsePosition(0));
                Date d2 = f.parse(o2.getDataDiNascita(), new ParsePosition(0));

                System.out.println("getPunteggioDisabilita == 0");
                int resultPrimoConfrontoDaPunteggio = (d1.compareTo(d2));

//                int punteggioFratelli = (o1.getCustName().compareTo(o2.getCustName()));
//
//                if (resultPrimoConfrontoDaPunteggio == 0) {
//                    System.out.println("resultPrimoConfrontoDaPunteggio == 0    TRUE");
//                    resultPrimoConfrontoDaPunteggio = punteggioFratelli;
//
//                }


                return resultPrimoConfrontoDaPunteggio;
            }


        });


        System.out.println("\n\nSorted Customer list on multiple fields"
                + " using Lambda Expression :- \n");

        // print new list to console using forEach()
        unsortedCustomerList.stream().forEach(cust -> System.out.println(cust));



    }

}


