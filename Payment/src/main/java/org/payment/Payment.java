package org.payment;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Payment {

    // Store transactions with sender ID and their counts for each type.
    private final Map<Integer, Map<TransactionType, Integer>> transactionCounts = new HashMap<>();

    // Track total P2M amounts per user to determine top 100 users for rewards.
    private final Map<Integer,Integer> p2mTransactionAmounts = new HashMap<>();

    // Maintain a sorted set of the top 100 users for rewards.
    private final TreeSet<Integer> top100Users = new TreeSet<>((a, b) -> {
        if (!p2mTransactionAmounts.get(a).equals(p2mTransactionAmounts.get(b))) {
            return p2mTransactionAmounts.get(b) - p2mTransactionAmounts.get(a);
        }
        return a - b;
    });

    public TransactionSummary makePayment(int transactionUd, int senderId, int amount, TransactionType transactionType){
        transactionCounts.putIfAbsent(senderId, new HashMap<>());
        transactionCounts.get(senderId).put(transactionType, transactionCounts.get(senderId).getOrDefault(transactionType, 0)+1);

        boolean isEligibleForReward = false;
        if(transactionType == TransactionType.P2M){
            p2mTransactionAmounts.put(senderId, p2mTransactionAmounts.getOrDefault(senderId, 0)+amount);
            top100Users.add(senderId);
            // Limit for top users
            int REWARD_LIMIT = 3;
            if(top100Users.size() > REWARD_LIMIT){
                top100Users.pollLast();
            }
            isEligibleForReward = top100Users.contains(senderId);

        }
        return new TransactionSummary(isEligibleForReward,transactionUd);
    }

    public int getNumberOfTransactions(int senderId, TransactionType transactionType) {
        if (!transactionCounts.containsKey(senderId)) {
            return 0;
        }
        return transactionCounts.get(senderId).getOrDefault(transactionType, 0);
    }

}
