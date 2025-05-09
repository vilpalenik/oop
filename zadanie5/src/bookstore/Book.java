package bookstore;


public class Book implements Comparable<Book> {

    private final String ISBN;
    private final String title;
    private final String author;
    private final int year;
    /**
     * Calculate the checksum of the ISBN.
     * ISBN may be ISBN-10 or ISBN-13.
     * ISBN is represented as a string without hyphens.
     * If the input contains any hyphens, spaces, or other characters which are not digits or the character X,
     * the potentialISBN check returns false.
     * Only check the checksum, you may disregard any other information the ISBN contains (e.g. country code).
     * @param potentialISBN the string the check. It must only contain characters 0-9, X.
     * @return true if the potentialISBN is a valid ISBN, false otherwise
     */
    public static boolean isISBNValid(String potentialISBN) {
        if (potentialISBN == null || potentialISBN.isEmpty()) return false;

        if (!potentialISBN.matches("^\\d{9}[\\dX]$") && !potentialISBN.matches("^\\d{13}$")) {
            return false;
        }

        if (potentialISBN.length() == 10) {
            // ISBN-10 checksum
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                char c = potentialISBN.charAt(i);
                int value;
                if (i == 9 && c == 'X') {
                    value = 10;
                } else if (Character.isDigit(c)) {
                    value = c - '0';
                } else {
                    return false; // Invalid character
                }
                sum += value * (10 - i);
            }
            return sum % 11 == 0;
        } else if (potentialISBN.length() == 13) {
            // ISBN-13 checksum
            int sum = 0;
            for (int i = 0; i < 13; i++) {
                int digit = potentialISBN.charAt(i) - '0';
                sum += (i % 2 == 0) ? digit : digit * 3;
            }
            return sum % 10 == 0;
        }

        // Not ISBN-10 or ISBN-13 length
        return false;
    }

    /**
     * Initialize the book.
     * @param ISBN a valid ISBN
     * @param title a non-null, non-empty title of the book
     * @param author a non-null, non-empty full name of the author
     * @param year a non-negative year of publication
     * @throws IllegalArgumentException if any of the parameters are invalid
     */
    public Book(String ISBN, String title, String author, int year) {
        if (!isISBNValid(ISBN)) {
            throw new IllegalArgumentException("Invalid ISBN");
        }
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Invalid title");
        }
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Invalid author");
        }
        if (year < 0) {
            throw new IllegalArgumentException("Invalid year");
        }

        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.year = year;
    }


    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
                ISBN.equals(book.ISBN) &&
                title.equals(book.title) &&
                author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return ISBN.hashCode();
    }

    @Override
    public int compareTo(Book other) {
        int yearCompare = Integer.compare(this.year, other.year);
        if (yearCompare != 0) {
            return yearCompare;
        }
        return this.ISBN.compareTo(other.ISBN);
    }
}