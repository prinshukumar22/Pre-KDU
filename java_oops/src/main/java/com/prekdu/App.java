package com.prekdu;
import java.util.*;
/*
 * Design a Library Management System that handles different types of library resources
(books, digital content, periodicals). The system should demonstrate(Use enums, classes, functions etc):

1. Create an abstract class LibraryResource that contains:
   - Protected fields for resourceId, title, and availabilityStatus
   - Abstract method calculateLateFee(int daysLate)
   - Abstract method getMaxLoanPeriod()

2. Implement different types of resources:
   - Book: Has additional fields for author and ISBN
   - DigitalContent: Has fields for fileSize and format (PDF, EPUB)
   - Periodical: Has fields for issueNumber and frequency (WEEKLY, MONTHLY)

3. Create an interface Renewable with method:
   - boolean renewLoan(LibraryMember member)

4. Create an interface Reservable with methods:
   - void reserve(LibraryMember member)
   - void cancelReservation(LibraryMember member)

5. Implement a LibraryMember class that:
   - Maintains a list of borrowed resources
   - Has a membership type (STANDARD, PREMIUM)
   - Has methods to borrow and return resources

6. Implement proper exception handling for:
   - ResourceNotAvailableException
   - MaximumLoanExceededException
 - InvalidMembershipException

Requirements:
- Books and Periodicals should be both Renewable and Reservable
- DigitalContent should only be Renewable
- Different resource types should have different late fees and loan periods
- Premium members should have higher loan limits and lower late fees and loan periods
- Implement proper validation and business logic

 */

// Enum for MembershipType
enum MembershipType {
    STANDARD, PREMIUM
}

// Enum for ResourceStatus
enum ResourceStatus {
    AVAILABLE, BORROWED, RESERVED
}

// Enum for ContentFormat
enum ContentFormat {
    PDF, EPUB
}

// Abstract class for Library Resources
abstract class LibraryResource {
    protected String resourceId;
    protected String title;
    protected ResourceStatus status;

    public LibraryResource(String resourceId, String title) {
        this.resourceId = resourceId;
        this.title = title;
        this.status = ResourceStatus.AVAILABLE;
    }

    public abstract double calculateLateFee(int daysLate);

    public abstract int getMaxLoanPeriod();

    public ResourceStatus getStatus() {
        return status;
    }

    public void setStatus(ResourceStatus status) {
        this.status = status;
    }
}

// Interface Renewable
interface Renewable {
    boolean renewLoan(LibraryMember member);
}

// Interface Reservable
interface Reservable {
    void reserve(LibraryMember member);

    void cancelReservation(LibraryMember member);
}

// Book class implementing Renewable and Reservable
class Book extends LibraryResource implements Renewable, Reservable {
    private String author;
    private String isbn;
    private LibraryMember reservedBy;

    public Book(String resourceId, String title, String author, String isbn) {
        super(resourceId, title);
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 0.5 * daysLate; // $0.5 per day late
    }

    @Override
    public int getMaxLoanPeriod() {
        return 14; // 14 days
    }

    @Override
    public boolean renewLoan(LibraryMember member) {
        return status != ResourceStatus.RESERVED; // Cannot renew if reserved
    }

    @Override
    public void reserve(LibraryMember member) {
        if (status == ResourceStatus.BORROWED) {
            this.reservedBy = member;
            status = ResourceStatus.RESERVED;
        } else {
            throw new IllegalStateException("Resource is not borrowed, cannot reserve.");
        }
    }

    @Override
    public void cancelReservation(LibraryMember member) {
        if (reservedBy != null && reservedBy.equals(member)) {
            reservedBy = null;
            status = ResourceStatus.BORROWED;
        }
    }
}

// DigitalContent class implementing Renewable only
class DigitalContent extends LibraryResource implements Renewable {
    private double fileSize;
    private ContentFormat format;

    public DigitalContent(String resourceId, String title, double fileSize, ContentFormat format) {
        super(resourceId, title);
        this.fileSize = fileSize;
        this.format = format;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 0.25 * daysLate; // $0.25 per day late
    }

    @Override
    public int getMaxLoanPeriod() {
        return 7; // 7 days
    }

    @Override
    public boolean renewLoan(LibraryMember member) {
        return true;
    }
}

// Periodical class implementing Renewable and Reservable
class Periodical extends LibraryResource implements Renewable, Reservable {
    private int issueNumber;
    private String frequency;
    private LibraryMember reservedBy;

    public Periodical(String resourceId, String title, int issueNumber, String frequency) {
        super(resourceId, title);
        this.issueNumber = issueNumber;
        this.frequency = frequency;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 1.0 * daysLate; // $1 per day late
    }

    @Override
    public int getMaxLoanPeriod() {
        return 7; // 7 days
    }

    @Override
    public boolean renewLoan(LibraryMember member) {
        return status != ResourceStatus.RESERVED;
    }

    @Override
    public void reserve(LibraryMember member) {
        if (status == ResourceStatus.BORROWED) {
            this.reservedBy = member;
            status = ResourceStatus.RESERVED;
        } else {
            throw new IllegalStateException("Resource is not borrowed, cannot reserve.");
        }
    }

    @Override
    public void cancelReservation(LibraryMember member) {
        if (reservedBy != null && reservedBy.equals(member)) {
            reservedBy = null;
            status = ResourceStatus.BORROWED;
        }
    }
}

// LibraryMember class
class LibraryMember {
    private String memberId;
    private MembershipType membershipType;
    private List<LibraryResource> borrowedResources;

    public LibraryMember(String memberId, MembershipType membershipType) {
        this.memberId = memberId;
        this.membershipType = membershipType;
        this.borrowedResources = new ArrayList<>();
    }

    public void borrowResource(LibraryResource resource) {
        int maxBorrowLimit = (membershipType == MembershipType.PREMIUM) ? 10 : 5;

        if (borrowedResources.size() >= maxBorrowLimit) {
            throw new MaximumLoanExceededException("Exceeded maximum loan limit.");
        }

        if (resource.getStatus() == ResourceStatus.BORROWED || resource.getStatus() == ResourceStatus.RESERVED) {
            throw new ResourceNotAvailableException("Resource is not available.");
        }

        resource.setStatus(ResourceStatus.BORROWED);
        borrowedResources.add(resource);
    }

    public void returnResource(LibraryResource resource) {
        if (borrowedResources.remove(resource)) {
            resource.setStatus(ResourceStatus.AVAILABLE);
        }
    }

    public List<LibraryResource> getBorrowedResources() {
        return borrowedResources;
    }
}

// Custom Exceptions
class ResourceNotAvailableException extends RuntimeException {
    public ResourceNotAvailableException(String message) {
        super(message);
    }
}

class MaximumLoanExceededException extends RuntimeException {
    public MaximumLoanExceededException(String message) {
        super(message);
    }
}

class InvalidMembershipException extends RuntimeException {
    public InvalidMembershipException(String message) {
        super(message);
    }
}


