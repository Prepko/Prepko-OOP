package hr.fer.oop;

import java.util.Objects;

public class Consumer {
    private String firstName;
    private String lastName;
    private int rewardPoints;
    private int membershipYears;

    public Consumer(String firstName, String lastName, int rewardPoints, int membershipYears) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rewardPoints = rewardPoints;
        this.membershipYears = membershipYears;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public int getMembershipYears() {
        return membershipYears;
    }

    @Override
    public int hashCode() {
       return Objects.hash(firstName, lastName);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Consumer)) return false;

        Consumer consumer = (Consumer) obj;

        return consumer.getFirstName().equals(firstName) &&
                consumer.getLastName().equals(lastName);
    }

    @Override
    public String toString() {
        return String.format("%s %s [points: %d, years: %d]", firstName, lastName, rewardPoints, membershipYears);
    }
}
