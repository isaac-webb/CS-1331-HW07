// I worked on the homework assignment alone, using only course materials.

/**
  * This class defines the basic functionality of a CEO, which is
  * a subclass of a TenXer. CEOs have an additional number of startups
  * attribute.
  *
  * @author iwebb6
  * @version 1.0
  */
public class Ceo extends TenXer {
    private int numStartups;

    /**
      * The default constructor for a CEO. Sets the name, annual salary, years
      * of experience, and number of startups.
      *
      * @param name The CEO's name
      * @param salary The CEO's annual salary
      * @param yearsExperience The CEO's years of experience
      * @param numOfStartups The CEO's number of startups
      */
    public Ceo(String name, int salary, int yearsExperience,
               int numOfStartups) {
        super(name, salary, yearsExperience);
        numStartups = numOfStartups;
    }

    /**
      * The no parameters constructor for a CEO that sets the name to an empty
      * String and all numbers to 0.
      */
    public Ceo() {
        this("", 0, 0, 0);
    }

    /**
      * Returns the number of startups this CEO has.
      *
      * @return This CEO's number of startups
      */
    public int getNumStartups() {
        return numStartups;
    }

    /**
      * A custom equals implementation that compares CEOs based on all TenXer
      * properties in addition to the number of startups they have.
      *
      * @param o The Object to compare the CEO to
      * @return true if the Objects are equal, false if they are not
      */
    @Override
    public boolean equals(Object o) {
        if (o != null) {
            if (o instanceof Ceo) {
                Ceo ceo = (Ceo) o;
                return numStartups == ceo.numStartups && super.equals(o);
            }
        }

        return false;
    }

    /**
      * A custom implementation of compareTo that orders CEOs based on the
      * number of startups, then by TenXer properties if the number of startups
      * are equal.
      *
      * @param tenxer The TenXer to compare this CEO to
      * @return A positive number if this CEO is greater, 0 if it is equal, and
      *         a negative number if it is less than
      */
    @Override
    public int compareTo(TenXer tenxer) {
        if (tenxer instanceof Ceo) {
            Ceo ceo = (Ceo) tenxer;
            int result = ceo.numStartups - numStartups;
            if (result != 0) {
                return result;
            }

            return super.compareTo(tenxer);
        } else {
            return getClass().getCanonicalName().compareTo(tenxer.getClass()
                                                           .getCanonicalName());
        }
    }

    /**
      * A custom toString implementation that returns the class name,
      * CEO's name, annual salary, years of experience, and their number of
      * startups.
      *
      * @return A String containing all of the information regarding the CEO
      */
    @Override
    public String toString() {
        return String.format("%s\nNumber of Startups: %d",
                             super.toString(), numStartups);
    }
}
