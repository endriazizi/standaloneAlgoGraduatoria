
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


//https://www.benchresources.net/java-8-sorting-list-of-objects-on-multiple-fields/


public class Prova {


    // customer list
    private static List<Customer> getUnSortedCustomers() {

        return Arrays.asList(
                new Customer("Shalini", "Chennai", 60),
                new Customer("Sneha", "Pune", 73),
                new Customer("Simran", "Bangalore", 37),
                new Customer("Trisha", "Hyderabad", 52),
                new Customer("Shalini", "Chennai", 70),
                new Customer("Abirami", "Bangalore", 48),
                new Customer("AZIZI", "NADIA", 73),
                new Customer("Sneha", "Pune", 62),
                new Customer("AZIZI", "ENDRI", 50)
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
                int resultPrimoConfrontoDaPunteggio = -((o1.getCustAge()).compareTo(o2.getCustAge()));

                // ==0 se il confronto ho due parimerito prendo la persono con in orfine alfabetico
                //crescente infatti non c'è il - che mi idica decrescente

//                resultPrimoConfrontoDaPunteggio = (Integer.compare(o1.getPunteggioFratelli(), o2.getPunteggioFratelli()));
                int punteggioFratelli = (o1.getCustName().compareTo(o2.getCustName()));

                if (resultPrimoConfrontoDaPunteggio == 0) {
                    System.out.println("resultPrimoConfrontoDaPunteggio == 0    TRUE");
                    resultPrimoConfrontoDaPunteggio = punteggioFratelli;

                }


//                else if(punteggioFratelli == 0){
//                    System.out.println("resultPrimoConfrontoDaPunteggio == 0    PIPPO");
//                    resultPrimoConfrontoDaPunteggio= -(Integer.compare(o1.getPuntLavoroMadrePrimaScelta(), o2.getPuntLavoroMadrePrimaScelta()));
//                }


//                int punteggioFratelli = -(Integer.compare(o1.getPunteggioFratelli(), o2.getPunteggioFratelli()));
//                int madrePrimaScelta = -(Integer.compare(o1.getPuntLavoroMadrePrimaScelta(), o2.getPuntLavoroMadrePrimaScelta()));
//
//                if (punteggioFratelli == 0) {
//                    return punteggioFratelli;
//                }
//
//                if (madrePrimaScelta == 0) {
//                    return -(Integer.compare(o1.getPuntLavoroMadreSecondaScelta(), o2.getPuntLavoroMadreSecondaScelta()));
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


