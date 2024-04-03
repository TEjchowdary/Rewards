package com.example.rewards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rewards")
public class RewardController {

    @Autowired
    private RewardCalculationService rewardService;

    @PostMapping("/calculate")
    public ResponseEntity<Map<String, Map<String, Integer>>> calculateRewards(@RequestBody List<Transaction> transactions) {
        Map<String, Map<String, Integer>> rewards = rewardService.calculateRewardsPerMonth(transactions);
        return ResponseEntity.ok(rewards);
    }
}
