package com.example.rewards;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RewardCalculationService {

    public Map<String, Map<String, Integer>> calculateRewardsPerMonth(List<Transaction> transactions) {
        Map<String, Map<String, Integer>> rewardsPerCustomerPerMonth = new HashMap<>();

        // Iterate through each transaction
        for (Transaction transaction : transactions) {
            String customerId = transaction.getCustomerId();
            String monthName = transaction.getDate().getMonth().toString();
            int points = calculatePoints(transaction.getAmount());

            // Update rewards map
            rewardsPerCustomerPerMonth.putIfAbsent(customerId, new HashMap<>());
            Map<String, Integer> customerRewards = rewardsPerCustomerPerMonth.get(customerId);
            customerRewards.put(monthName, customerRewards.getOrDefault(monthName, 0) + points);
        }

        // Calculate total rewards for each customer and add to the map
        calculateAndAddTotalRewards(rewardsPerCustomerPerMonth);

        return rewardsPerCustomerPerMonth;
    }

    private void calculateAndAddTotalRewards(Map<String, Map<String, Integer>> rewardsPerCustomerPerMonth) {
        for (Map.Entry<String, Map<String, Integer>> entry : rewardsPerCustomerPerMonth.entrySet()) {
            int totalRewards = entry.getValue().values().stream().mapToInt(Integer::intValue).sum();
            entry.getValue().put("Total", totalRewards);
        }
    }

    private int calculatePoints(double amount) {
        int points = 0;
        if (amount > 100) {
            points += (int) ((amount - 100) * 2);
            amount = 100;
        }
        if (amount > 50) {
            points += (int) (amount - 50);
        }
        return points;
    }
}
