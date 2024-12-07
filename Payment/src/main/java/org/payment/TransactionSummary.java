package org.payment;

public class TransactionSummary {
    int transactionId;
    boolean isSenderEligibleForReward;

    public TransactionSummary(boolean isSenderEligibleForReward, int transactionId) {
        this.isSenderEligibleForReward = isSenderEligibleForReward;
        this.transactionId = transactionId;
    }

    @Override
    public String toString(){
        return transactionId+" "+isSenderEligibleForReward;
    }
}


