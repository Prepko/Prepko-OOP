package hr.fer.oop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class RewardsProgram {
    private List<Consumer> consumers = new ArrayList<>();

    public void addConsumer(String firstName, String lastName, int rewardPoints, int membershipYears) {
        Consumer consumer = new Consumer(firstName, lastName, rewardPoints, membershipYears);
        consumers.add(consumer);
    }

    public List<Consumer> getConsumers() {
        return consumers;
    }

    public void removeConsumers(List<String> removalNames){
        Iterator<Consumer> it = consumers.iterator();
        while(it.hasNext()){
            Consumer consumer = it.next();
            if(removalNames.contains(consumer.getLastName())){
                it.remove();
            }
        }
    }

    public static final Comparator<Consumer> COMPARATOR = Comparator.comparing(Consumer::getRewardPoints).reversed()
            .thenComparing(Comparator.comparing(Consumer::getMembershipYears).reversed())
            .thenComparing(Comparator.comparing(Consumer::getLastName));


    public void rankConsumers(){
        consumers.sort(COMPARATOR);
    }
}
