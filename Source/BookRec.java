import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class BookRec {
    public static String changePathBasedOnOS(String windowsPath, String generalPath){
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("windows")) {

            return windowsPath;             
        }
        return generalPath;
    }
    public static String changeAuthorsPathBasedOnOS(){ 
        String windowsPath = "Data\\Authors.csv";
        String generalPath = "Data/Authors.csv";
        return changePathBasedOnOS(windowsPath,generalPath);
    }

    public static String changeAuthorshipPathBasedOnOS(){
        String windowsPath = "Data\\Authorship.csv";             
        String generalPath = "Data/Authorship.csv";
        return changePathBasedOnOS(windowsPath,generalPath);
    }

    public static String changeReadPathBasedOnOS(){
        String windowsPath = "Data\\ReadBook.csv";
        String generalPath = "Data/ReadBook.csv";
        return changePathBasedOnOS(windowsPath,generalPath);
    }

    public static String changeTBRPathBasedOnOS(){
        String windowsPath = "Data\\TBRBook.csv";
        String generalPath = "Data/TBRBook.csv";
        return changePathBasedOnOS(windowsPath,generalPath);
    }

    public static ArrayList<author> readAuthors(){

        String authorsFile = changeAuthorsPathBasedOnOS();
        ArrayList<author> authorList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(authorsFile))) {

            scanner.useDelimiter(",|\\n");

            while (scanner.hasNext()) {

                String id = scanner.next();
                String name = scanner.next();
                String country = scanner.next();
                String birthYear = scanner.next();
                boolean isAlive = Boolean.parseBoolean(scanner.next());

                author newAuthor = new author(name, country, birthYear, isAlive, id);
                authorList.add(newAuthor);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + authorsFile);
            e.printStackTrace();
        }
        return authorList;
    }

    public static ArrayList<readBook> readReadBooks() {
        String readBooksFile = changeReadPathBasedOnOS();
        ArrayList<readBook> readBookList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(readBooksFile))) {
            scanner.useDelimiter(",|\\n");

            while (scanner.hasNext()) {
                String id = scanner.next();
                String title = scanner.next();
                String publicationYear = scanner.next();
                float rating = Float.parseFloat(scanner.next());

                readBook readBook = new readBook(id, title, publicationYear, rating);
                readBookList.add(readBook);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + readBooksFile);
            e.printStackTrace();
        }

        return readBookList;
    }

    public static ArrayList<tBRBook> readTBRBooks(){
        String tBRBooksFile = changeTBRPathBasedOnOS();
        ArrayList<tBRBook> tBRBookList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(tBRBooksFile))) {
            scanner.useDelimiter(",|\\n");

            while (scanner.hasNext()) {
                String id = scanner.next();
                String title = scanner.next();
                String publicationYear = scanner.next();
                Boolean priority = Boolean.parseBoolean(scanner.next());

                tBRBook tBRBook = new tBRBook(id, title, publicationYear, priority);
                tBRBookList.add(tBRBook);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + tBRBooksFile);
            e.printStackTrace();
        }

        return tBRBookList;
    }

    public static ArrayList<authorship> readAuthorship() {
        String authorshipFile = changeAuthorshipPathBasedOnOS();
        ArrayList<authorship> authorshipList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(authorshipFile))) {
            scanner.useDelimiter(",|\\n");

            while (scanner.hasNext()) {
                String bookId = scanner.next();
                String authorId = scanner.next();

                authorship authorship = new authorship(bookId, authorId);
                authorshipList.add(authorship);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + authorshipFile);
            e.printStackTrace();
        }

        return authorshipList;
    }

    public static String getAuthorNameById(String authorId, ArrayList<author> authorList){
        String authorName = null;

        for (author author : authorList) {
            if (authorId.equals(author.getId())) {
                authorName = author.getName();
                break;
            }
        }

        return authorName;
    }

    public static ArrayList<String> getAuthorsForBook(String bookId, ArrayList<authorship> authorshipList, ArrayList<author> authorList) {
        ArrayList<String> bookAuthors = new ArrayList<>();
        String authorName;
        for (authorship authorship : authorshipList) {
            if (authorship.getBookId().equals(bookId)) {
                authorName = getAuthorNameById(authorship.getAuthorId(), authorList);
                if (authorName == null) {
                    authorName = authorship.getAuthorId();
                }
                else{
                    bookAuthors.add(authorName);
                }
            }
        }
        return bookAuthors;
    }

    public static ArrayList<String> getTBRBookListIDs(ArrayList<tBRBook> tBRBookList) {
        ArrayList<String> ids = new ArrayList<>();
        for (tBRBook book : tBRBookList) {
            ids.add(book.getId());
        }
        return ids;
    }

    public static ArrayList<String> getTBRBookListTitles(ArrayList<tBRBook> tBRBookList) {
        ArrayList<String> titles = new ArrayList<>();
        for (tBRBook book : tBRBookList) {
            titles.add(book.getTitle());
        }
        return titles;
    }

public static void printBookTitlesAndId(ArrayList<tBRBook> tBRBookList){
        ArrayList<String> ids = getTBRBookListIDs(tBRBookList), titles = getTBRBookListTitles(tBRBookList);
        System.out.println("Ids - Títulos");
 
        for (int i = 0; i < ids.size(); i++) {
            System.out.println(ids.get(i) + " - " + titles.get(i));
        }
    }
    
    public static void printBookTitlesAndIdRead(ArrayList<readBook> readBookList){
        System.out.println("Ids - Títulos");
    
        for (readBook book : readBookList) {
            System.out.println(book.getId() + " - " + book.getTitle());
        }
    }

    public static ArrayList<String> getReadBookListIDs(ArrayList<readBook> readBookList) {
        ArrayList<String> ids = new ArrayList<>();
        for (readBook book : readBookList) {
            ids.add(book.getId());
        }
        return ids;
    }

    public static void printAll( ArrayList<author> authorList, ArrayList<readBook> readBookList, ArrayList<tBRBook> tBRBookList, ArrayList<authorship> authorshipList) {
        ArrayList<String> bookAuthorship;

        System.out.println("Dados Registrados:");

        for (author a : authorList) {

            System.out.println("    ID: " + a.getId());
            System.out.println("    Name: " + a.getName());
            System.out.println("    Country: " + a.getCountry());
            System.out.println("    Birth Year: " + a.getBirthYear());
            System.out.println("    Is Alive: " + a.getIsAlive());
            System.out.println();
        }
        for (readBook rb : readBookList) {

            bookAuthorship = getAuthorsForBook(rb.getId(), authorshipList, authorList);

            System.out.println("    ID: " + rb.getId());
            System.out.println("    Title: " + rb.getTitle());
            System.out.println("    Publication: " + rb.getPublicationYear());
            System.out.println("    Rating: " + rb.getRating());
            System.out.println("    Authors:" + bookAuthorship);
            System.out.println();
        }

        for (tBRBook tbrb : tBRBookList) {

            bookAuthorship = getAuthorsForBook(tbrb.getId(), authorshipList, authorList);

            System.out.println("    ID: " + tbrb.getId());
            System.out.println("    Title: " + tbrb.getTitle());
            System.out.println("    Publication: " + tbrb.getPublicationYear());
            System.out.println("    Priority: " + tbrb.isPriority());
            System.out.println("    Authors:" + bookAuthorship);
            System.out.println();
        }
    }

    public static void deleteBook(ArrayList<tBRBook> tBRBookList, ArrayList<readBook> readBookList) {

        printBookTitlesAndId(tBRBookList);
        printBookTitlesAndIdRead(readBookList);
        System.out.print("Digite a ID do livro que você deseja marcar como lido: ");

        Scanner scanner = new Scanner(System.in);

        String bookId = scanner.nextLine();

        scanner.close();

        for (int i = 0; i < tBRBookList.size(); i++) {
            if (tBRBookList.get(i).getId().equals(bookId)) {
                tBRBookList.remove(i);
                System.out.println("Book with ID " + bookId + " removed from 'to be read' list.");
                return;
            }
        }

        for (int i = 0; i < readBookList.size(); i++) {
            if (readBookList.get(i).getId().equals(bookId)) {
                readBookList.remove(i);
                System.out.println("Book with ID " + bookId + " removed from 'read' list.");
                return;
            }
        }
    

        System.out.println("Book with ID " + bookId + " not found in any list.");
    }
    

    public static void moveFromTBRToRead(ArrayList<tBRBook> tBRBookList, ArrayList<readBook> readBookList) {

        printBookTitlesAndId(tBRBookList);
        System.out.print("Digite a ID do livro que você deseja marcar como lido: ");

        Scanner scanner = new Scanner(System.in);

        String bookId = scanner.nextLine();

        scanner.close();

        tBRBook foundBook = null;
        for (tBRBook book : tBRBookList) {
            if (book.getId().equals(bookId)) {
                foundBook = book;
                break;
            }
        }
        if (foundBook != null) {
            tBRBookList.remove(foundBook);
            readBook readBook = new readBook(foundBook.getId(), foundBook.getTitle(), foundBook.getPublicationYear(), 0.0f); // You can set the initial rating as desired
            readBookList.add(readBook);
    
            System.out.println(foundBook.getTitle() + " agora está na lista de livros lidos.");
        } else {
            System.out.println("Livro com a ID " + bookId + " não foi achado na lista de livros a serem lidos.");
        }
    }

    public static void updateBook(ArrayList<readBook> readBookList, ArrayList<tBRBook> tBRBookList) {
        Scanner scanner = new Scanner(System.in);
        String bookId;
    
        System.out.println("1. Atualizar um livro lido.");
        System.out.println("2. Atualizar um livro na lista de livros a serem lidos.");
        System.out.println("0. Cancel.");
    
        System.out.print("Digite o número da sua escolha: ");
        int choice = scanner.nextInt();
    
        scanner.nextLine();


        System.out.println("ID - Título");

        switch (choice) {
            case 1:
                printBookTitlesAndIdRead(readBookList);
                System.out.print("Digite o ID do livro que você quer atualizar: ");
                bookId = scanner.nextLine();
                for (readBook book : readBookList) {
                    if (book.getId().equals(bookId)) {
                        System.out.print("Insira o novo título (Aperte Enter para pular): ");
                        String newTitle = scanner.nextLine();
                        if (!newTitle.isEmpty()) {
                            book.setTitle(newTitle); 
                        }
                        System.out.print("Insira o novo ano de publicação (Aperte Enter para pular): ");
                        String newPublicationYear = scanner.nextLine();
                        if (!newPublicationYear.isEmpty()) {
                            book.setPublicationYear(newPublicationYear);
                        }
                        System.out.print("Insira a nova nota, entre 0.0 e 5.0 (Aperte Enter para pular): ");
                        float newRating = (float)(-99.0);
                        newRating = scanner.nextFloat();
                        if (newRating >= 0.0 && newRating <= 5.0) {
                            book.setRating(newRating);
                        }
                        System.out.println("Informação atualizada com sucesso.");
                        scanner.close();
                        return;
                    }
                }
                System.out.println("Livro com a ID " + bookId + " não foi achado na lista de livros lidos.");
                break;
            case 2:
                printBookTitlesAndId(tBRBookList);
                System.out.print("Digite o ID do livro que você quer atualizar: ");
                bookId = scanner.nextLine();
                for (tBRBook book : tBRBookList) {
                    if (book.getId().equals(bookId)) {
                        System.out.print("Insira o novo título (Aperte Enter para pular): ");
                        String newTitle = scanner.nextLine();
                        if (!newTitle.isEmpty()) {
                            book.setTitle(newTitle);
                        }
                        System.out.print("Insira o novo ano de publicação (Aperte Enter para pular): ");
                        String newPublicationYear = scanner.nextLine();
                        if (!newPublicationYear.isEmpty()) {
                            book.setPublicationYear(newPublicationYear);
                        }
                        System.out.print("Digite S ou Y se o seu livro é uma prioridade entre suas próximas leituras (Aperte Enter para pular):");
                        char aux = scanner.next().charAt(0);
                        if ('Y' == aux || 'S' == aux || 'y' == aux || 's' == aux) {
                            book.setPriority(true);
                        }
                        else{
                            book.setPriority(false);
                        }
                        System.out.println("Informação atualizada com sucesso.");
                        scanner.close();
                        return;
                    }
                }
                System.out.println("Livro com a ID " + bookId + " não foi achado na lista de livros a serem lidos.");
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    
        scanner.close();
    }
    

    public static void printMenuNewBook() {
        System.out.println("Menu:");
        System.out.println("1. Inserir na lista de livros lidos.");
        System.out.println("2. Inserir na lista de livros a serem lidos.");
        System.out.println("0. Cancelar.");
    }

    public static void insertNewBook(ArrayList<readBook> readBookList, ArrayList<tBRBook> tBRBookList) {
        int choice;
        ArrayList<String> tBRBookIDList, readBookIDList;
        String newBookTitle, newBookPublicationYear, newBookID;
        char aux2;
        float newBookRating;
        Boolean newBookPriority;

        Scanner scanner = new Scanner(System.in);
        do {
            printMenuNewBook();
            System.out.print("Insira o número da sua escolha:");
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Insira o título do livro: ");
            newBookTitle = scanner.nextLine();
            System.out.print("Insira o ano de publicação do livro: ");
            newBookPublicationYear = scanner.nextLine();

            Random random = new Random();

            switch (choice) {
                case 1:
                    tBRBookIDList = getTBRBookListIDs(tBRBookList);
                    do {
                        newBookID = "tbr" + random.nextInt(1000);
                    } while (tBRBookIDList.contains(newBookID));

                    System.out.print("Insira a nota, entre 0.0 e 5.0 estrelas, do livro: ");
                    newBookRating = scanner.nextFloat();
                    readBook newReadBook = new readBook(null, newBookTitle, newBookPublicationYear, newBookRating);

                    readBookList.add(newReadBook);
                    System.out.println(newBookTitle + " foi inserido na lista.");
                    break;
                case 2:
                    readBookIDList = getReadBookListIDs(readBookList);
                    do {
                        newBookID = "r" + random.nextInt(1000);
                    } while (readBookIDList.contains(newBookID));

                    System.out.print("Se o seu livro é uma prioridade entre suas próximas leituras, digite S ou Y:");
                    aux2 = scanner.next().charAt(0);
                    if ('Y' == aux2 || 'S' == aux2 || 'y' == aux2 || 's' == aux2) {
                        newBookPriority = true;
                    }
                    else{
                        newBookPriority = false;
                    }
                    tBRBook newTBRBook = new tBRBook(null, newBookTitle, newBookPublicationYear, newBookPriority);

                    tBRBookList.add(newTBRBook);
                    System.out.println(newBookTitle + " foi inserido na lista.");
                    break;
                case 0:
                    return;
                default:
                    break;
            }

        } while (choice != 0);
        scanner.close();
    }

    public static void printMenu () {
        System.out.println("Menu:");
        System.out.println("1. Exibir todos os dados registrados.");
        System.out.println("2. Inserir livro.");
        System.out.println("3. Remover livro.");
        System.out.println("4. Atualizar livro.");
        System.out.println("5. Registrar livro como lido.");
        System.out.println("0. Sair.");
    }
    
    public static void main(String[] args) {
        ArrayList<author> authorList = readAuthors();
        ArrayList<readBook> readBookList = readReadBooks();
        ArrayList<tBRBook> tBRBookList = readTBRBooks();
        ArrayList<authorship> authorshipList = readAuthorship();
        int choice;

        Scanner scanner = new Scanner(System.in);
        do {
            printMenu();
            System.out.print("Insira o número da sua escolha:");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    printAll(authorList, readBookList, tBRBookList, authorshipList);
                    break;
                case 2:
                    insertNewBook(readBookList,tBRBookList);
                    break;
                case 3:
                deleteBook(tBRBookList,readBookList);
                    break;
                case 4:
                    
                    break;
                case 5:
                    moveFromTBRToRead(tBRBookList,readBookList);
                    break;
                case 0:
                        
                    break;
            
                default:
                    break;
            }
        } while (choice != 0);
        scanner.close();
    }
}
