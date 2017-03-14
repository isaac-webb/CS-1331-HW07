// I worked on the homework assignment alone, using only course materials.

/**
  * This class defines the basic functionality of a CEO, which is
  * a subclass of a TenXer. CEOs have an additional number of startups
  * attribute.
  *
  * @author iwebb6
  * @version 1.0
  */
public class Cfo extends TenXer {
    private int moneySkills;

    /**
      * The default constructor for a CFO. Sets the name, annual salary, years
      * of experience, and money skills.
      *
      * @param name The CEO's name
      * @param salary The CEO's annual salary
      * @param yearsExperience The CEO's years of experience
      * @param moneySkills How good the CFO is with money
      */
    public Cfo(String name, int salary, int yearsExperience,
               int moneySkills) {
        super(name, salary, yearsExperience);
        this.moneySkills = moneySkills;
    }

    /**
      * The no parameters constructor for a CFO that sets the name to an empty
      * String and all numbers to 0.
      */
    public Cfo() {
        this("", 0, 0, 0);
    }

    /**
      * Returns the money skills this CFO has.
      *
      * @return This CFO's money skills
      */
    public int getMoneySkills() {
        return moneySkills;
    }

    /**
      * A custom equals implementation that compares CFOs based on all TenXer
      * properties in addition to the money skills they have.
      *
      * @param o The Object to compare the CFO to
      * @return true if the Objects are equal, false if they are not
      */
    @Override
    public boolean equals(Object o) {
        if (o != null) {
            if (o instanceof Cfo) {
                Cfo ceo = (Cfo) o;
                return moneySkills == ceo.moneySkills && super.equals(o);
            }
        }

        return false;
    }

    /**
      * A custom implementation of compareTo that orders CFOs based on the
      * money skills, then by TenXer properties if the money skills are equal.
      *
      * @param tenxer The TenXer to compare this CFO to
      * @return A positive number if this CFO is greater, 0 if it is equal, and
      *         a negative number if it is less than
      */
    @Override
    public int compareTo(TenXer tenxer) {
        if (tenxer instanceof Cfo) {
            Cfo ceo = (Cfo) tenxer;
            int result = moneySkills - ceo.moneySkills;
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
      * CFO's name, annual salary, years of experience, and their money skills.
      *
      * @return A String containing all of the information regarding the CFO
      */
    @Override
    public String toString() {
        return String.format("%s\nMoney Skills: %d",
                             super.toString(), moneySkills);
    }
}
