// I worked on the homework assignment alone, using only course materials.

/**
  * This class defines the basic functionality of a SoftwareEngineer, which is
  * a subclass of a TenXer. SoftwareEngineers have additional stars and knows
  * Java properties.
  *
  * @author iwebb6
  * @version 1.0
  */
public class SoftwareEngineer extends TenXer {
    private int githubStars;
    private boolean knowsJava;

    /**
      * The default constructor for a SoftwareEngineer. Sets the name, annual
      * salary, years of experience, GitHub stars, and whether or not they know
      * Java.
      *
      * @param name The SoftwareEngineer's name
      * @param salary The SoftwareEngineer's annual salary
      * @param yearsExperience The SoftwareEngineer's years of experience
      * @param githubStars The SoftwareEngineer's GitHub stars
      * @param knowsJava Whether or not the SoftwareEngineer knows Java
      */
    public SoftwareEngineer(String name, int salary, int yearsExperience,
                            int githubStars, boolean knowsJava) {
        super(name, salary, yearsExperience);
        this.githubStars = githubStars;
        this.knowsJava = knowsJava;
    }

    /**
      * The no parameters constructor for a SoftwareEngineer that sets the name
      * to an empty String, all numbers to 0, and knowsJava to false.
      */
    public SoftwareEngineer() {
        this("", 0, 0, 0, false);
    }

    /**
      * Returns the number of GitHub stars this SoftwareEngineer has.
      *
      * @return This SoftwareEngineer's GitHub stars
      */
    public int getGithubStars() {
        return githubStars;
    }

    /**
      * Returns whether or not this SoftwareEngineer knows Java.
      *
      * @return Whether or not this SoftwareEngineer knows Java
      */
    public boolean getKnowsJava() {
        return knowsJava;
    }

    /**
      * A custom equals implementation that compares SoftwareEngineers based on
      * all TenXer properties in addition to the number of GitHub stars and
      * whether or not they know Java.
      *
      * @param o The Object to compare the SoftwareEngineer to
      * @return true if the Objects are equal, false if they are not
      */
    @Override
    public boolean equals(Object o) {
        if (o != null) {
            if (o instanceof SoftwareEngineer) {
                SoftwareEngineer softEng = (SoftwareEngineer) o;
                return githubStars == softEng.githubStars
                       && knowsJava == softEng.knowsJava && super.equals(o);
            }
        }

        return false;
    }

    /**
      * A custom implementation of compareTo that orders SoftwareEngineers based
      * on GitHub stars (high to low), then knowing Java (true to false), then
      * the default TenXer compareTo implementation.
      *
      * @param tenxer The TenXer to compare this SoftwareEngineer to
      * @return A positive number if this SoftwareEngineer is greater, 0 if it
      *         is equal, and a negative number if it is less than
      */
    @Override
    public int compareTo(TenXer tenxer) {
        if (tenxer instanceof SoftwareEngineer) {
            SoftwareEngineer softEng = (SoftwareEngineer) tenxer;
            int result = githubStars - softEng.githubStars;
            if (result != 0) {
                return result;
            } else {
                result = (knowsJava ? 1 : 0) - (softEng.knowsJava ? 1 : 0);
                if (result != 0) {
                    return result;
                }
            }

            return super.compareTo(tenxer);
        } else {
            return getClass().getCanonicalName().compareTo(tenxer.getClass()
                                                           .getCanonicalName());
        }
    }

    /**
      * A custom toString implementation that returns the class name,
      * SoftwareEngineer's name, annual salary, years of experience, GitHub
      * stars, and whether or not they know Java.
      *
      * @return A String containing all of the information regarding the
      *         SoftwareEngineer
      */
    @Override
    public String toString() {
        return String.format("%s\nGitHub Stars: %d\nKnows Java: %b",
                             super.toString(),
                             githubStars,
                             knowsJava);
    }
}
