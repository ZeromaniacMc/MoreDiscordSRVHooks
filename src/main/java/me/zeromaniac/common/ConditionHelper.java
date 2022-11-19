package me.zeromaniac.common;

import org.bukkit.entity.Player;

public class ConditionHelper {

    public boolean stringComparator(String input, String logicalOperator, String compare) {
        // == or equals
        // != or !equals
        // contains
        // !contains

        if (logicalOperator.equals("==") || (logicalOperator.equalsIgnoreCase("equals"))) {
            return input.equalsIgnoreCase(compare);
        }

        if (logicalOperator.equals("!=") || (logicalOperator.equalsIgnoreCase("!equals"))) {
            return !input.equalsIgnoreCase(compare);
        }

        if (logicalOperator.equalsIgnoreCase("contains")) {
            return input.toLowerCase().contains(compare.toLowerCase());
        }

        if (logicalOperator.equalsIgnoreCase("!contains")) {
            return !input.toLowerCase().contains(compare.toLowerCase());
        }
        return false;
    }

    public boolean permissionComparator(Player player, String[] input, String logicalOperator, boolean compare) {
        // operator "and" ,"or"
        // compare true/ false


        if (logicalOperator.equalsIgnoreCase("and")) {
            for (String perm : input) {
                if (player.hasPermission(perm) != compare) {
                    return false;
                }
            }
        } else if (logicalOperator.equalsIgnoreCase("or")) {
            for (String perm : input) {
                if (player.hasPermission(perm) == compare) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public boolean numericalComparator(String input, String logicalOperator, double compare) {
        // <, <=, >, >=, ==

        if (logicalOperator.equals("<") || logicalOperator.equalsIgnoreCase("smallerThan")) {
            try {
                return Double.valueOf(input) < compare;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (logicalOperator.equals("<=") || logicalOperator.equalsIgnoreCase("smallerOrEqual")) {
            try {
                return Double.valueOf(input) <= compare;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (logicalOperator.equals(">") || logicalOperator.equalsIgnoreCase("biggerThan")) {
            try {
                return Double.valueOf(input) > compare;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (logicalOperator.equals(">=") || logicalOperator.equalsIgnoreCase("biggerOrEqual")) {
            try {
                return Double.valueOf(input) >= compare;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (logicalOperator.equals("==") || logicalOperator.equalsIgnoreCase("equals")) {
            try {
                return Double.valueOf(input) == compare;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
