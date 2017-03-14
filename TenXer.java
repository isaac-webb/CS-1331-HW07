// I worked on the homework assignment alone, using only course materials.

/**
  * A class defining the functionality and characteristics of a TenXer, a very
  * efficient employee in Silicon Valley.
  *
  * @author iwebb6
  * @version 1.0
  */
public abstract class TenXer implements Comparable<TenXer> {
    private String name;
    private int yearsOfExperience;
    private int annualSalary;

    /**
      * The default constructor for a TenXer. Sets the TenXer's name, salary,
      * and
      * years of experience.
      *
      * @param name The TenXer's name
      * @param salary The TenXer's annual salary
      * @param yearsExperience The TenXer's years of experience
      */
    public TenXer(String name, int salary, int yearsExperience) {
        this.name = name;
        annualSalary = salary > 0 ? salary : 0;
        yearsOfExperience = yearsExperience > 0 ? yearsExperience : 0;
    }

    /**
      * A no parameters constructor for a TenXer that creates a TenXer with no
      * name, 0 salary, and 0 years of experience. The constructor with
      * parameters is preferred.
      */
    public TenXer() {
        this("", 0, 0);
    }

    /**
      * Returns this TenXer's name.
      *
      * @return The TenXer's name
      */
    public String getName() {
        return name;
    }

    /**
      * Returns this TenXer's salary.
      *
      * @return This TenXer's salary.
      */
    public int getSalary() {
        return annualSalary;
    }

    /**
      * Returns this TenXer's years of experience.
      *
      * @return This TenXer's years of experience
      */
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    /**
      * A custom compareTo implementation that orders TenXers based on their
      * years of experience (high to low), then salary (low to high), then name
      * (alphabetically).
      *
      * @param tenxer The TenXer to compare to
      * @return A positive number if this TenXer is greater, 0 if it is equal,
      *         and a negative number if it is less than.
      */
    @Override
    public int compareTo(TenXer tenxer) {
        int result = yearsOfExperience - tenxer.yearsOfExperience;
        if (result == 0) {
            result = tenxer.annualSalary - annualSalary;
            if (result == 0) {
                result = name.compareTo(tenxer.name);
            }
        }

        return result;
    }

    /**
      * A custom equals implementation that compares all attributes of a TenXer
      * for equality.
      *
      * @param o The Object to compare the TenXer to
      * @return true if the input Object is a TenXer and has the same attributes
      *         values; false otherwise
      */
    @Override
    public boolean equals(Object o) {
        if (o != null) {
            if (o instanceof TenXer) {
                TenXer tenxer = (TenXer) o;
                return name.equals(tenxer.name)
                       && tenxer.annualSalary == annualSalary
                       && tenxer.yearsOfExperience == yearsOfExperience;
            }
        }

        return false;
    }

    /**
      * A custom toString implementation that returns the class name, TenXer's
      * name, annual salary, and years of experience.
      *
      * @return A String containing all of the information regarding the TenXer
      */
    @Override
    public String toString() {
        return String.format("%s: %s\nSalary: $%d\nYears of Experience: %d",
                             getClass().getName(), name, annualSalary,
                             yearsOfExperience);
    }
}
