import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        // Crear cultura proporcionando nombre y descripción
        Culture greek = new Culture("Griega", "Mitologia Griega. Deidad principal Zeus");
        Culture nordic = new Culture("Nórdica", "Mitología nórdica. Deidad principal Odín");

        greek.addRelatedCountry("Grecia"); //añadir país influenciado

        nordic.addRelatedCountry("Suecia");
        nordic.addRelatedCountry("Dinamarca");
        nordic.addRelatedCountry("Noruega");
        nordic.addRelatedCountry("Finlandia");
        nordic.addRelatedCountry("Islandia");

        // crear deidad proporcionar nombre y descripcion
        Deity zeus = new Deity("Zeuz", "Dios del rayo");

        zeus.addParent(new Deity("Cronos", "Titan")); // añadir papá/mamá
        zeus.addParent(new Deity("Era", "Titan"));

        Deity athena = new Deity("Athena", "Diosa de la sabiduria");

        athena.addParent(zeus);

        greek.addDeity(zeus);
        greek.addDeity(athena);

        printCulture(greek);
        printCulture(nordic);
    }

    private static void printCulture(Culture culture) {
        System.out.print("================ ");
        System.out.print(culture.getName() + " - " + culture.getDescription());
        System.out.println("================ ");

        LinkedList<String> countries = culture.getRelatedContries();

        System.out.println("Countries");

        for (String country : countries) {
            System.out.println(country);
        }

        System.out.println("-------------------------------");

        List<Deity> deities = culture.getDeities();

        for (Deity deity : deities) {
            System.out.println(String.format("%s >> %s", deity.getName(), deity.getDescription()) );

            LinkedList<Deity> parents = deity.getParents();
            Iterator<Deity> parentsIterator = parents.iterator();

            System.out.println("Hijo de:");
            while (parentsIterator.hasNext()) {
                Deity parent = parentsIterator.next();
                System.out.println("  " + parent.getName());
            }

        }

    }


}
